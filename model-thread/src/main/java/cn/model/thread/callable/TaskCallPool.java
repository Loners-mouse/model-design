package cn.model.thread.callable;

import cn.model.thread.collects.TaskThread;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

import java.util.Iterator;
import java.util.Optional;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TaskCallPool {

    private ListeningExecutorService executorService;

    {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(4,
                4, 120L, TimeUnit.SECONDS, TaskQueue.blockingQueue);

        executorService = MoreExecutors.listeningDecorator(executor);
    }

    public static TaskCallPool getInstance() {
        return INSTANCE.instance.getInstance();
    }

    public ListenableFuture<Boolean> doAction(TaskCallable taskThread) {
        try {
            return executorService.submit(taskThread);
        } catch (RejectedExecutionException e1) {
            System.out.println("taskThread submit to TaskCallPool Rejected: " + taskThread.toString());
        } catch (Exception e) {
            System.out.println("taskThread submit to TaskCallPool error: " + taskThread.toString());
        }
        return Futures.immediateFuture(false);
    }

    public boolean isExist(String id) {
        return TaskQueue.isExist(id);
    }

    public void remove(String id) {
        TaskQueue.remove(id);
    }

    public Optional<TaskThread> query(String id) {
        return TaskQueue.query(id);
    }

    private enum INSTANCE {
        instance;
        private TaskCallPool taskPool;

        private INSTANCE() {
            taskPool = new TaskCallPool();
        }

        public TaskCallPool getInstance() {
            return taskPool;
        }
    }

    private static class TaskQueue {
        static ArrayBlockingQueue blockingQueue = new ArrayBlockingQueue<TaskThread>(1000);

        private static boolean isExist(String id) {
            return false;
        }

        private static Optional<TaskThread> query(String id) {
            TaskThread taskThread = null;
            Iterator<Runnable> it = blockingQueue.iterator();
            while (it.hasNext()) {
                TaskThread tt = (TaskThread) it.next();
                if (id.equals(tt.element.getId())) {
                    taskThread = tt;
                }
            }
            return Optional.ofNullable(taskThread);
        }

        private static void remove(String id) {
            Optional<TaskThread> taskThread = query(id);
            if (taskThread.isPresent())
                blockingQueue.remove(taskThread.get());
        }
    }
}
