package com.thread.c04.s14;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>
 * Function:
 * <p>
 * Description: awaitUninterruptibly : 
 * 调用该方法的前提是，当前线程已经成功获得与该条件对象绑定的重入锁，
 * 否则调用该方法时会抛出IllegalMonitorStateException。
 * 调用该方法后，结束等待的唯一方法是其它线程调用该条件对象的signal()或signalALL()方法。
 * 等待过程中如果当前线程被中断，该方法仍然会继续等待，同时保留该线程的中断状态。
 * 
 * @since 1.0
 * @version 1.0
 * @author 1132381386@qq.com 钟秋森 2018年3月19日
 */
public class J02_MyService {

	public ReentrantLock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();

	public void waitMethod() {
		try {
			lock.lock();
			System.out.println("wait begin");
			condition.awaitUninterruptibly();
			System.out.println("wait   end");
		} catch (Exception e) {
			System.out.println("catch");
			e.printStackTrace();
		}finally{
			lock.unlock();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		final J02_MyService service = new J02_MyService();
		Runnable runnableRef = new Runnable() {

			@Override
			public void run() {
				service.waitMethod();

			}
		};
		Thread threadA = new Thread(runnableRef);
		threadA.setName("A");
		threadA.start();
		Thread.sleep(3000);
		threadA.interrupt();
	}
}
