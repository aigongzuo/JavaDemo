package com.kang.javalib.java.lock;

public class SynchronizedDemo {

    public static void main(String[] args) {
        final SynchronizedDemo demo = new SynchronizedDemo();
        new Thread() {
            @Override
            public void run() {
                demo.exec("Thread1");
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                demo.exec("Thread2");
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                demo.exec("Thread3");
            }
        }.start();
        System.out.println("OVER!!!");
    }

    public synchronized void exec(final String name) {
        System.out.println("start:" + name);
        new Thread() {
            @Override
            public void run() {
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
                System.out.println("end:" + name);
            }
        }.start();
    }
}
