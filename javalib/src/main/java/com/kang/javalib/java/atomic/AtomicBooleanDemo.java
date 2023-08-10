package com.kang.javalib.java.atomic;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 *
 */
public class AtomicBooleanDemo implements Runnable {
    private static AtomicBoolean exists = new AtomicBoolean(false);


    private String name;

    public AtomicBooleanDemo(String name) {
        this.name = name;
    }

    int cont;

    @Override
    public void run() {
        if (exists.compareAndSet(false, true)) {
            new Thread() {

                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                        run();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }.start();
        }
        new Thread() {
            @Override
            public void run() {
                cont++;
                exists.set(false);
            }
        }.start();
    }


    public static void main(String[] args) {

        AtomicBooleanDemo bar1 = new AtomicBooleanDemo("bar1");
        AtomicBooleanDemo bar2 = new AtomicBooleanDemo("bar2");
        new Thread(bar1).start();
        new Thread(bar2).start();
    }

}
