package com.kang.javalib.java.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {
    public static Lock lock = new ReentrantLock();
    public static void main(String[] args) {
        lock.tryLock();
    }



    public void incrementCounter() {
        lock.lock();
        try {
            //counter++;
        } finally {
            lock.unlock();
        }
    }

}
