package com.kang.javalib.java.countdown;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class CountDownDemo {
    static CountDownLatch countDownLatch = new CountDownLatch(2);
    static boolean One = false;
    static boolean Two = false;

    public static void main(String[] args) {
        new Thread() {
            @Override
            public void run() {
                try {
                    countDownLatch.await();
                    System.out.println("One Thread await Over!!!" + countDownLatch.getCount());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("One Thread Over!!!" + countDownLatch.getCount());
                countDownLatch.countDown();
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Two Thread Over!!!" + countDownLatch.getCount());
                countDownLatch.countDown();
            }
        }.start();

        try {
            countDownLatch.await();
            System.out.println("main OVER!!!" + String.valueOf(countDownLatch.getCount()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
