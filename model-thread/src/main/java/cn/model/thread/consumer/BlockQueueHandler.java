package cn.model.thread.consumer;

import cn.model.thread.model.Element;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockQueueHandler {

    private BlockingQueue<Element> blockingQueue = new ArrayBlockingQueue(1000);

    public static BlockQueueHandler getInstance() {
        return SingleTon.instance.getBlockQueueHandler();
    }

    public void putIfNot(Element element) {
        if (!isExist(element)) {
            put(element);
        }
    }

    public boolean isExist(Element element) {
        return blockingQueue.contains(element);
    }

    public BlockingQueue getBlockingQueue() {
        return blockingQueue;
    }

    public void put(Element element) {
        try {
            blockingQueue.put(element);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void clear() {
        blockingQueue.clear();
    }

    private enum SingleTon {
        instance;
        private BlockQueueHandler blockQueueHandler;

        private SingleTon() {
            blockQueueHandler = new BlockQueueHandler();
        }

        public BlockQueueHandler getBlockQueueHandler() {
            return blockQueueHandler;
        }
    }
}
