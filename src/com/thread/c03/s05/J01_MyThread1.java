package com.thread.c03.s05;

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
public class J01_MyThread1 extends Thread {
	private Object lock;

	public J01_MyThread1(Object lock) {
		super();
		this.lock = lock;
	}

	@Override
	public void run() {
		try {
			synchronized (lock) {
				if (J03_MyList.size() != 5) {
					System.out.println("开始      wait time=" + System.currentTimeMillis());
					lock.wait();
					System.out.println("结束      wait time=" + System.currentTimeMillis());
				}
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
