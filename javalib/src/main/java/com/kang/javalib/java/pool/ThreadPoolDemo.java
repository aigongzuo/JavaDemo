package com.kang.javalib.java.pool;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadPoolDemo {
    static ReentrantLock reentrantLock = new ReentrantLock();


    public static void main(String[] args) throws InterruptedException {
        Condition condition = reentrantLock.newCondition();
        reentrantLock.lock();
        reentrantLock.unlock();
        LinkedBlockingDeque linkedBlockingDeque = new LinkedBlockingDeque();
        ThreadPoolExecutor executorol = new ThreadPoolExecutor(1, 5, 1,
                TimeUnit.DAYS, linkedBlockingDeque, new ThreadFactory() {
            @Override
            public Thread newThread(Runnable runnable) {
                return new Thread(runnable);
            }
        }, new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
                System.out.println("rejectedExecution...");
            }
        });
//        executorol.prestartAllCoreThreads();
//        executorol.prestartCoreThread();
        executorol.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("Work1....");
            }
        });
        executorol.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("Work2....");
            }
        });

        System.out.println("OVER!!!"+executorol.getCorePoolSize());
        Thread.sleep(3000);
        executorol.shutdown();
        System.out.println("OVER!!!");

    }

}
