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
public class J05_NotifyThread extends Thread {
	private Object lock;

	public J05_NotifyThread(Object lock) {
		super();
		this.lock = lock;
	}

	@Override
	public void run() {
		synchronized (lock){
			//随机唤醒一个
//			lock.notify();
			lock.notifyAll();
			//确保所有线程都被唤醒，可以使用notifyAll()
		}
	}
	
	public static void main(String[] args) {
		try {
			Object lock=new Object();
			J02_ThreadA a=new J02_ThreadA(lock);
			a.start();
			J03_ThreadB b=new J03_ThreadB(lock);
			b.start();
			J04_ThreadC c=new J04_ThreadC(lock);
			c.start();
			Thread.sleep(1000);
			J05_NotifyThread n=new J05_NotifyThread(lock);
			n.start();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
