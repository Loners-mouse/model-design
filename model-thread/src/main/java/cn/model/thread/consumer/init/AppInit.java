package cn.model.thread.consumer.init;

import cn.model.thread.consumer.BlockQueueHandler;
import cn.model.thread.consumer.ConsumerThread;
import org.jvnet.hk2.annotations.Service;

@Service
public class AppInit implements InitService{

	@Override
	public void init() {

		//启动队列消费线程
		new Thread(
				new ConsumerThread(
						BlockQueueHandler.getInstance().getBlockingQueue())
		).start();
	}
}
