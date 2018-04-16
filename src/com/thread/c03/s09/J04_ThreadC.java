package com.thread.c03.s09;

/**
 * <p>
 * Function: wait notify
 * <p>
 * Description:
 * 调用方法notify一次只随机通知一个线程进行唤醒
 * @since 1.0
 * @version 1.0
 * @author 1132381386@qq.com 钟秋森 2018年3月19日
 */
public class J04_ThreadC extends Thread {
	private Object lock;

	public J04_ThreadC(Object lock) {
		super();
		this.lock = lock;
	}

	@Override
	public void run() {
		J01_Service service=new J01_Service();
		service.testMethod(lock);
	}
}
