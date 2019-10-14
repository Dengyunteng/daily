package cn.thread;

import java.util.Collections;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BlockQueue<T> {
    Lock lock = new ReentrantLock();
    Condition notFull = lock.newCondition();
    Condition notEmpty = lock.newCondition();
    boolean isEmpty = true;
    boolean isFull = false;
    public void enq(T t){
        lock.lock();
        try{
            while(isFull){
                notFull.await();
            }
            notEmpty.signalAll();
        }catch(InterruptedException e){

        }finally {
            lock.unlock();
        }
    }

    public void deq(){
        lock.lock();
        try{
            while(isEmpty){
                notEmpty.await();
            }
            notFull.signalAll();
        }catch (InterruptedException e){

        }finally {

        }
    }
}
