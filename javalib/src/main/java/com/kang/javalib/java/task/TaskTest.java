package com.kang.javalib.java.task;

public class TaskTest {

    public static void main(String[] args) {
        LMTask task1 = new LMTask() {
            @Override
            protected void runInTryCatch() {
                System.out.println("task1");
            }
        };

        LMTask task2 = new LMTask() {
            @Override
            protected void runInTryCatch() {
                System.out.println("task2");
            }
        };
        LMTask task3 = new LMTask() {
            @Override
            protected void runInTryCatch() {
                System.out.println("task3");
            }
        };
        LMTask task4 = new LMTask() {
            @Override
            protected void runInTryCatch() {
                System.out.println("task4");
            }
        };
        LMTask task5 = new LMTask() {
            @Override
            protected void runInTryCatch() {
                System.out.println("task5");
            }
        };

        LMTask task6 = new LMTask() {
            @Override
            protected void runInTryCatch() {
                System.out.println("task6");
            }
        };

        LMTask task7 = new LMTask() {
            @Override
            protected void runInTryCatch() {
                System.out.println("task7");
            }
        };
        LMTask task8 = new LMTask() {
            @Override
            protected void runInTryCatch() {
                System.out.println("task8");
            }
        };
        LMTask task9 = new LMTask() {
            @Override
            protected void runInTryCatch() {
                System.out.println("task9");
            }
        };
        LMTask task10 = new LMTask() {
            @Override
            protected void runInTryCatch() {
                System.out.println("task10");
            }
        };


        task1.addSubTask(task2);
        task2.addSubTask(task3);
        task1.addSubTask(task4);
        task4.addSubTask(task5);
        task1.run();

    }
}
