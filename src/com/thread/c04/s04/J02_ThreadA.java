package com.thread.c04.s04;

/**
 * <p>
 * Function: ReentrantLock类在功能上相对比synchronized更多
 * 调用ReenTrantLock对象的lock方法获取锁，调用unlock方法释放锁
 * 借助Condition对象，实现 wait和notify/notifyAll的等待/通知模式
 * notify/notifyAll是通过JVM随机选择的，但是ReentrantLock+Condition可以实现“选择性通知”
 * <p>
 * Description:
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
		service.waitMethod();
	}
	
	/**
	 * 调用了Condition 的 await方法，使当前执行任务的线程进入了等待WAITING状态，所以只打印了一个"A"
	 * @param args
	 * @author 1132381386@qq.com 钟秋森 2018年3月22日
	 */
	public static void main(String[] args) {
		J01_MyService service=new J01_MyService();
		J02_ThreadA a=new J02_ThreadA(service);
		a.start();
	}
}
