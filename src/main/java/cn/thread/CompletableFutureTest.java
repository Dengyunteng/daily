package cn.thread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.BiFunction;
import java.util.function.Supplier;

public class CompletableFutureTest {
    public static void main(String[] args){
        CompletableFuture<Void> f1 = CompletableFuture.runAsync(new Runnable() {
            @Override
            public void run() {
                System.out.println("T1:洗水壶...");
                sleep(1,TimeUnit.SECONDS);
                System.out.println("T1:烧开水...");
                sleep(15, TimeUnit.SECONDS);
            }
        });
        CompletableFuture<String> f2 = CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                System.out.println("T2:洗茶壶...");
                sleep(1,TimeUnit.SECONDS);
                System.out.println("T2:洗茶杯...");
                sleep(2, TimeUnit.SECONDS);
                System.out.println("T2:拿茶叶...");
                sleep(1, TimeUnit.SECONDS);
                return "龙井";
            }
        });
        CompletableFuture<String> f3 = f1.thenCombine(f2, new BiFunction<Void, String, String>() {
            @Override
            public String apply(Void aVoid, String s) {
                System.out.println("T3:拿到茶叶:" + s);
                System.out.println("T3:泡茶...");
                return "上茶:" + s;
            }
        });
        System.out.println(f3.join());
        System.out.println(f2.join());
    }
    static void sleep(int i, TimeUnit u){
        try{
            u.sleep(i);
        }catch (InterruptedException e){}
    }
}
