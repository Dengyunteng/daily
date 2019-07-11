import java.util.ArrayList;
import java.util.List;

public class GenericTest {
    public static  <T extends Comparable<? super T>> T max(List<T> list){
        return null;
    }
    public static <T extends Comparable<T>> T max1(List<T> list){
        return null;
    }
    void test(B a){
       a.get();
    }

    public static void main(String[] args){
        List<Fruit1> fl = new ArrayList<Fruit1>();
        List<Apple1> al = new ArrayList<Apple1>();
        max(fl);
        max(al);
        max1(fl);
//        max1(al);
    }
}
class Fruit1 implements Comparable<Fruit1>{

    public int compareTo(Fruit1 o) {
        return 0;
    }
}

class Apple1 extends Fruit1{

}

interface A <T extends A<T>>{
    T get();
}
interface B extends A<B>{

}
