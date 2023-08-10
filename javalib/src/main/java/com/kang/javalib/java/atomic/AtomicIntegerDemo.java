package com.kang.javalib.java.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 方法名	                    方法作用
 * get()	                    直接返回值
 * set(int)	                设置数据(注意这里是没有原子性操作的)
 * getAndIncrement()	        以原子方式将当前值加1，相当于线程安全的i++操作
 * incrementAndGet()	        以原子方式将当前值加1，相当于线程安全的++i操作
 * getAndDecrement()	        以原子方式将当前值减1，相当于线程安全的i–操作
 * decrementAndGet()	        以原子方式将当前值减1，相当于线程安全的–i操作
 * getAndSet(int)	        设置指定的数据，返回设置前的数据
 * addAndGet(int)	        增加指定的数据，返回增加后的数据
 * getAndAdd(int)	        增加指定的数据，返回变化前的数据
 * lazySet(int)	            仅仅当get时才会set
 * compareAndSet(int, int)	比较源数据和期望数据(参数一)，若一致，则设置新数据(参数二)到源数据中并返回true，否则返回false
 */
public class AtomicIntegerDemo {
    static AtomicInteger ai = new AtomicInteger(1);

    public static void main(String[] args) {
        //先获取，再自增
        System.out.println(ai.getAndIncrement());
        //先自增，再获取
        System.out.println(ai.incrementAndGet());
        //增加一个指定值，先add，再get
        System.out.println(ai.addAndGet(5));
        //增加一个指定值,先get，再set
        System.out.println(ai.getAndSet(5));
    }
}
