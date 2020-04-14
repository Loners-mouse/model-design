package cn.model.thread.collects;

import cn.model.thread.model.Element;

public class TaskThread implements Runnable {

	public Element element;

	public TaskThread(Element element){
		this.element=element;
	}

	public void run() {
		System.out.println(element.getDisplayName());

		try {
			Thread.sleep(5000);
		}catch (Exception e){
			System.out.println("thread wait failed!");
		}finally {
			TaskCollectionPool.getInstance().remove(element.getId());
		}
	}
}
