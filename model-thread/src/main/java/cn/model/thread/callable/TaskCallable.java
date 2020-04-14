package cn.model.thread.callable;

import java.util.Random;
import java.util.concurrent.Callable;

import cn.model.thread.model.Element;

public class TaskCallable implements Callable {

	public Element element;

	public TaskCallable(Element element){
		this.element=element;
	}


	@Override
	public Boolean call() throws Exception {
		System.out.println(element.getDisplayName());

		try {
			Thread.sleep(10*new Random().nextInt(10));
		}catch (Exception e){
			System.out.println("thread wait failed!");
		}

		return true;
	}
}
