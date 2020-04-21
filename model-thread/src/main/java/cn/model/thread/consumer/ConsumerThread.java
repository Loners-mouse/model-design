package cn.model.thread.consumer;

import java.util.concurrent.BlockingQueue;

import cn.model.thread.model.Element;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConsumerThread implements Runnable {

	private BlockingQueue<Element> blockingQueue;

	public ConsumerThread(BlockingQueue blockingQueue){
		this.blockingQueue=blockingQueue;
	}

	@Override
	public void run() {

		int i=0;
		while (i<30){
			try {
				Thread.sleep(30000);
				//取出队列元素
				Element element=blockingQueue.take();

				//业务逻辑处理
				log.info("consumer:{}",element);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			i++;
		}
		BlockQueueHandler.getInstance().clear();
	}
}
