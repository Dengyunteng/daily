package cn.thread;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinTest {
    public static void main(String[] args){
        ForkJoinPool forkJoinPool = new ForkJoinPool(9);
        Fibonacci fibonacci = new Fibonacci(30);
        Integer result = forkJoinPool.invoke(fibonacci);
        System.out.println(result);
    }
}
class Fibonacci extends RecursiveTask<Integer>{
    final int n;
    Fibonacci(int n){
        this.n = n;
    }
    @Override
    protected Integer compute() {
        if(n <= 1){
            return n;
        }
        Fibonacci f1 = new Fibonacci(n - 1);
        f1.fork();
        Fibonacci f2 = new Fibonacci(n - 2);
        System.out.println(Thread.currentThread().getName() + "--" + n);
        return f2.compute() + f1.join();
    }
}
