package com.thread.c03.s04;

/**
 * <p>
 * Function: wait notify
 * <p>
 * Description:
 * 
 * @since 1.0
 * @version 1.0
 * @author 1132381386@qq.com 钟秋森 2018年3月19日
 */
public class J02_MyThread2 extends Thread {
	private Object lock;

	public J02_MyThread2(Object lock) {
		super();
		this.lock = lock;
	}

	@Override
	public void run() {
		synchronized (lock) {
			System.out.println("开始      wait time="+System.currentTimeMillis());
			lock.notify();
			System.out.println("结束      wait time="+System.currentTimeMillis());
		}
	}
	
	public static void main(String[] args) {
		try {
			Object lock=new Object();
			J01_MyThread1 t1=new J01_MyThread1(lock);
			t1.start();
			Thread.sleep(3000);
			J02_MyThread2 t2=new J02_MyThread2(lock);
			t2.start();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
