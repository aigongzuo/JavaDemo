package com.kang.javalib.java.timer;

import java.util.Timer;
import java.util.TimerTask;

public class MultipleTaskSchedule {
    public static void main(String[] args) {
        Timer timer = new Timer();

        // 任务1
        TimerTask task1 = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Task 1 executed");
            }
        };

        // 任务2
        TimerTask task2 = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Task 2 executed");
            }
        };

        // 任务3
        TimerTask task3 = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Task 3 executed");
            }
        };

        // 安排任务执行，每隔2秒执行一次
        timer.schedule(task1, 0, 2000);
        timer.schedule(task2, 1000, 2000);
        timer.schedule(task3, 2000, 2000);

        timer.cancel();
    }
}
