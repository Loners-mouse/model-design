package cn.model.thread.consumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import cn.model.thread.model.Element;

public class BlockQueueHandler {

	public static BlockQueueHandler getInstance(){
		return SingleTon.instance.getBlockQueueHandler();
	}

	private enum SingleTon{
		instance;
		private BlockQueueHandler blockQueueHandler;

		private SingleTon(){
			blockQueueHandler = new BlockQueueHandler();
		}

		public BlockQueueHandler getBlockQueueHandler(){
			return blockQueueHandler;
		}
	}


	private BlockingQueue<Element> blockingQueue = new ArrayBlockingQueue(1000);

	public void putIfNot(Element element){
		if(!isExist(element)){
			put(element);
		}
	}

	public boolean isExist(Element element){
		return blockingQueue.contains(element);
	}

	public BlockingQueue getBlockingQueue(){
		return blockingQueue;
	}

	public void put(Element element){
		try {
			blockingQueue.put(element);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
