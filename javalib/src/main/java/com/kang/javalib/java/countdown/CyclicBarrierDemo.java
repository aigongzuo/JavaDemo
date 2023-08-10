package com.kang.javalib.java.countdown;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
    static CyclicBarrier cyclicBarrier = new CyclicBarrier(2, new Runnable() {
        @Override
        public void run() {
            System.out.println("cyclicBarrier OVER !!!");
        }
    });

    public static void main(String[] args) {
        new Thread() {
            @Override
            public void run() {
                try {
                    System.out.println("cyclicBarrier One Thread Start !!!");
                    cyclicBarrier.await();
                    System.out.println("cyclicBarrier One Thread OVER !!!");
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                try {
                    System.out.println("cyclicBarrier Two Thread Start !!!");
                    Thread.sleep(3000);
                    cyclicBarrier.await();
                    System.out.println("cyclicBarrier Two Thread OVER !!!");
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}
