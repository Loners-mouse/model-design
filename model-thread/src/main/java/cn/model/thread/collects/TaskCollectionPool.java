package cn.model.thread.collects;


import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TaskCollectionPool {

    private ThreadPoolExecutor threadPoolExecutor;

    {
        threadPoolExecutor = new ThreadPoolExecutor(1, 1, 120L, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(1000));
    }

    public static TaskCollectionPool getInstance() {
        return SingleTon.instance.getTaskCollectionPool();
    }

    public void doAction(TaskThread taskThread) {
        put(taskThread.element.getId());
        threadPoolExecutor.submit(taskThread);
    }

    public boolean isExist(String id) {
        return Collection.isExist(id);
    }

    public void put(String id) {
        Collection.put(id);
    }

    public void remove(String id) {
        if (isExist(id)) {
            Collection.remove(id);
        }
    }

    private enum SingleTon {
        instance;
        private TaskCollectionPool taskCollectionPool;

        private SingleTon() {
            taskCollectionPool = new TaskCollectionPool();
        }

        public TaskCollectionPool getTaskCollectionPool() {
            return taskCollectionPool;
        }

    }

    private static class Collection {
        private static Set<String> elements = new ConcurrentSkipListSet<>();

        private static boolean isExist(String id) {
            return elements.contains(id);
        }

        private static void put(String id) {
            elements.add(id);
        }

        private static void remove(String id) {
            elements.remove(id);
        }
    }


}
