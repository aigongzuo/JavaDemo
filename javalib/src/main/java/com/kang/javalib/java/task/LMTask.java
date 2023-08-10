package com.kang.javalib.java.task;

import java.util.LinkedList;

public abstract class LMTask implements Runnable {
    private final LinkedList<LMTask> subListTask = new LinkedList<>();

    public LMTask() {
    }


    public final void run() {
        try {
            this.runInTryCatch();
            synchronized (subListTask) {
                runSubTask(subListTask);
            }
        } catch (Throwable var5) {
            var5.printStackTrace();
        } finally {

        }
    }

    protected abstract void runInTryCatch();

    /**
     * 递归执行子任务
     *
     * @param subListTask 子任务列表
     */
    private void runSubTask(LinkedList<LMTask> subListTask) {
        if (subListTask == null) {
            return;
        }
        while (subListTask.size() > 0) {
            LMTask lmTask = subListTask.poll();
            if (lmTask != null) {
                lmTask.run();
            }
        }
    }

    public void addSubTask(LMTask task) {
        subListTask.offer(task);
    }
}
