package com.thread.c04.s09;

/**
 * <p>
 * Function: ReentrantLock类在功能上相对比synchronized更多
 * 调用ReenTrantLock对象的lock方法获取锁，调用unlock方法释放锁 借助Condition对象，实现
 * wait和notify/notifyAll的等待/通知模式
 * notify/notifyAll是通过JVM随机选择的，但是ReentrantLock+Condition可以实现“选择性通知”
 * <p>
 * Description:实现生产者/消费者模式：多对多交替打印
 * 
 * @since 1.0
 * @version 1.0
 * @author 1132381386@qq.com 钟秋森 2018年3月19日
 */
public class J03_ThreadB extends Thread {

	private J01_MyService service;

	public J03_ThreadB(J01_MyService service) {
		super();
		this.service = service;
	}

	@Override
	public void run() {
		for (int i = 0; i < Integer.MAX_VALUE; i++) {
			service.get();
		}
	}

	/**
	 * 调用了Condition 的 await方法，使当前执行任务的线程进入了等待WAITING状态，调用condition 的
	 * singal方法进行通知
	 * 
	 * @param args
	 * @author 1132381386@qq.com 钟秋森 2018年3月22日
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		J01_MyService service = new J01_MyService();
		J02_ThreadA[] a = new J02_ThreadA[10];
		J03_ThreadB[] b = new J03_ThreadB[10];
		for (int i = 0; i < 10; i++) {
			a[i]=new J02_ThreadA(service);
			b[i]=new J03_ThreadB(service);
			a[i].start();
			b[i].start();
		}
	}
}
