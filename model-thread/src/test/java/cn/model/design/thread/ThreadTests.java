package cn.model.design.thread;

import cn.model.thread.collects.TaskCollectionPool;
import cn.model.thread.collects.TaskThread;
import cn.model.thread.consumer.BlockQueueHandler;
import cn.model.thread.consumer.ConsumerThread;
import cn.model.thread.model.Element;
import org.junit.Test;

public class ThreadTests {

	@Test
	public void collPool(){
		for (int i=0;i<5;i++) {
			Element element=new Element(
					i+"","thread1"+i);
			TaskThread taskThread = new TaskThread(element);

			String id = element.getId();
			if(TaskCollectionPool.getInstance().isExist(element.getId())){
				continue;
			}
			TaskCollectionPool.getInstance().doAction(taskThread);
		}
		System.out.println("s1");
		for (int i=0;i<5;i++) {

			Element element=new Element(
					i+"","thread1"+i);
			TaskThread taskThread = new TaskThread(element);

			if(TaskCollectionPool.getInstance().isExist(element.getId())){
				System.out.println("存在");
				continue;
			}
			TaskCollectionPool.getInstance().doAction(taskThread);
		}
		System.out.println("s2");

		while (true){

		}
	}

	@Test
	public void producerThread(){

		new Thread(new ConsumerThread(BlockQueueHandler.getInstance().getBlockingQueue())).start();

		new Thread(()->{Element element=new Element(
				0+"","thread"+0);
				BlockQueueHandler.getInstance().putIfNot(element);
		}).start();
		new Thread(()->{Element element=new Element(
				0+"","thread"+0);
			BlockQueueHandler.getInstance().putIfNot(element);
		}).start();
		new Thread(()->{Element element=new Element(
				0+"","thread"+0);
			BlockQueueHandler.getInstance().putIfNot(element);
			}).start();
		new Thread(()->{
			Element element=new Element(
				0+"","thread"+0);
				BlockQueueHandler.getInstance().putIfNot(element);
			}).start();



		while (true){}
	}



}
