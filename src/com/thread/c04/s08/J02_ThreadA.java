package com.thread.c04.s08;

/**
 * <p>
 * Function: ReentrantLock类在功能上相对比synchronized更多
 * 调用ReenTrantLock对象的lock方法获取锁，调用unlock方法释放锁
 * 借助Condition对象，实现 wait和notify/notifyAll的等待/通知模式
 * notify/notifyAll是通过JVM随机选择的，但是ReentrantLock+Condition可以实现“选择性通知”
 * <p>
 * Description:实现生产者/消费者模式：一对一交替打印
 * 
 * @since 1.0
 * @version 1.0
 * @author 1132381386@qq.com 钟秋森 2018年3月19日
 */
public class J02_ThreadA extends Thread{

	private J01_MyService service;

	public J02_ThreadA(J01_MyService service) {
		super();
		this.service = service;
	}
	@Override
	public void run() {
		for (int i = 0; i < Integer.MAX_VALUE; i++) {
			service.set();
		}
	}
}
