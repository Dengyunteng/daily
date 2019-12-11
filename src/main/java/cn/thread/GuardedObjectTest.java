package cn.thread;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Predicate;

public class GuardedObjectTest {
    public static void main(String[] args){
        List<Map<String, Object>> info = new ArrayList<>();
        Map<String,Object> map1 = new HashMap<>();
        Map<String,Object> map2 = new HashMap<>();
        map2.put("YEAR", "2016");
        map2.put("TARGETID", "t2");
        map2.put("TARGETNAME", "4. I类切口手术部位感染率▲");
        map2.put("VALUE", "1.22");
        map1.put("YEAR", "2016");
        map1.put("TARGETID", "t1");
        map1.put("TARGETNAME", "19.手术患者并发症发生率▲");
        map1.put("VALUE", "1.42");
        Map<String,Object> map4 = new HashMap<>();
        map4.put("YEAR", "2017");
        map4.put("TARGETID", "t4");
        map4.put("TARGETNAME", "4. I类切口手术部位感染率▲");
        map4.put("VALUE", "1.24");
        Map<String,Object> map3 = new HashMap<>();
        map3.put("YEAR", "2017");
        map3.put("TARGETID", "t3");
        map3.put("TARGETNAME", "19.手术患者并发症发生率▲");
        map3.put("VALUE", "1.23");
        Map<String,Object> map5 = new HashMap<>();
        map5.put("YEAR", "2018");
        map5.put("TARGETID", "t5");
        map5.put("TARGETNAME", "4.手术患者并发症发生率▲");
        map5.put("VALUE", "1.52");
        info.add(map2);
        info.add(map1);
        info.add(map3);
        info.add(map4);
        info.add(map5);
        System.out.println(handle3(info));
    }

    public static Map<String, List<Object>> handle(List<Map<String, Object>> data){
        Map<String, List<Object>> result = new HashMap<>();
        List<Object> yearList = new ArrayList<>();
        result.put("year", yearList);
        for(Map<String, Object> map : data){
            String year = map.get("YEAR").toString();

            if(!yearList.contains(year)){
                yearList.add(year);
                List<Object> temp = new ArrayList<>();
                result.put(year, temp);
            }
            List<Object> info = result.get(year);
            Map<String, Object> mapInfo = new HashMap<>();
            mapInfo.put("name", map.get("TARGETNAME"));
            mapInfo.put("value", map.get("VALUE"));
            info.add(mapInfo);
        }
        return result;
    }
//    public static Map<String, List<Object>> handle2(List<Map<String, Object>> data){
//        Map<String, List<Object>> result = new HashMap<>();
//        List<Object> yearList = new ArrayList<>();
//        result.put("year", yearList);
//        for(Map<String, Object> map : data){
//            String year = map.get("YEAR").toString();
//            if(!yearList.contains(year)){
//                yearList.add(year);
//            }
//            String targetName = map.get("TARGETNAME").toString();
//            if(result.get(targetName) == null){
//                result.put(targetName, new ArrayList<>());
//            }
//            List<Object> info = result.get(targetName);
//            Map<String, Object> mapInfo = new HashMap<>();
//
//            mapInfo.put("year", year);
//            mapInfo.put("name", targetName);
//            mapInfo.put("value", map.get("VALUE"));
//            info.add(mapInfo);
//        }
//        return result;
//    }
    public static List<Object> handle3(List<Map<String, Object>> data){
        LinkedHashMap<String, List<Object>> result = new LinkedHashMap<>();
        List<Object> yearList = new ArrayList<>();
        result.put("year", yearList);
        for(Map<String, Object> map : data){
            String year = map.get("YEAR").toString();
            if(!yearList.contains(year)){
                yearList.add(year);
            }
            String targetName = map.get("TARGETNAME").toString();
            List<Object> info = result.get(targetName);
            if(info == null){
                info = new ArrayList<>();
                result.put(targetName, info);
            }
            Map<String, Object> mapInfo = new HashMap<>();

            mapInfo.put("year", year);
            mapInfo.put("name", targetName);
            mapInfo.put("value", map.get("VALUE"));
            info.add(mapInfo);
        }
        return new ArrayList<>(result.values());
    }
}
class GuardedObject<T>{
    T obj;
    final static Map<Object, GuardedObject> maps = new ConcurrentHashMap<>();
    final Lock lock = new ReentrantLock();
    final Condition ready = lock.newCondition();
    final int timeout = 1;
    public static <K> GuardedObject create(K key){
        GuardedObject guardedObject = new GuardedObject();
        maps.put(key, guardedObject);
        return guardedObject;
    }
    public static <K, V> void fireEvent(K key, V obj){
        GuardedObject guardedObject = maps.remove(key);
        if(guardedObject != null){
            guardedObject.onChange(obj);
        }
    }

    public T get(Predicate<T> p){
        lock.lock();
        try{
            while(!p.test(obj)){
                ready.await(timeout, TimeUnit.SECONDS);
            }
        }catch(InterruptedException e){
            throw new RuntimeException();
        }finally{
            lock.unlock();
        }
        return obj;
    }

    public void onChange(T obj){
        lock.lock();
        try{
            this.obj = obj;
            ready.signalAll();
        }finally{
            lock.unlock();
        }
    }
}
class Message<T>{
    int id;
    T t;
    Message(int id, T t){
        this.id = id;
        this.t = t;
    }
    public T get(){
        return t;
    }
}
