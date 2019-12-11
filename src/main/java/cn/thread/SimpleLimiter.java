package cn.thread;

import java.util.concurrent.TimeUnit;

public class SimpleLimiter {
    long storedPermits = 0;
    long maxPermits = 3;
    long next = System.nanoTime();
    long interval = 1000_000_000;
    void resync(long now){
        if(now > next){
            long newPermits = (now - next)/interval;
            storedPermits = Math.min(maxPermits, storedPermits + newPermits);
            next = now;
        }
    }
    synchronized long reserve(long now){
        resync(now);
        long at = next;
        long fb = Math.min(1, storedPermits);
        long nr = 1 - fb;
        next = next + nr * interval;
        storedPermits = storedPermits - fb;
        return Math.max(at, 0L);
    }
    void acquire(){
        long now = System.nanoTime();
        long at = reserve(now);
        long waitTime = Math.max(at - now, 0L);
        if(waitTime > 0){
            try {
                TimeUnit.SECONDS.sleep(waitTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
