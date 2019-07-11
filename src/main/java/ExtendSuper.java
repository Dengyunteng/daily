import java.util.ArrayList;
import java.util.List;

public class ExtendSuper {
    public static void print(ArrayList<? extends Fruit> list){
        for(Fruit f : list){

        }
    }

    public static <T extends Comparable<T>> int printT(T t){
        return 0;
    }
    public static <T extends Comparable<? super T>> int printL(List<T> list){
        return 0;
    }

    public static void main(String[] args){
        ArrayList<Fruit> al = new ArrayList<Fruit>();
        al.add(new Apple());
        ArrayList<? extends Fruit> fl = al;
        ArrayList<Fruit> f2 = new ArrayList<Fruit>();
        ArrayList<Apple> a = new ArrayList<Apple>();
        ArrayList<? super Fruit> f3 = al;
        printT(new Apple());
        printL(a);
    }
}

class Fruit implements Comparable<Fruit>{

    @Override
    public int compareTo(Fruit o) {
        return 0;
    }
}

class Apple extends Fruit{

}
class Orange extends Fruit{

}

interface K<T extends K>{
    public void k(T t);
}
class E implements K<E>{

    @Override
    public void k(E e) {

    }
}
