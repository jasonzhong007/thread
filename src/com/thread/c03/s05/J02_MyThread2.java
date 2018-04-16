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
public class J02_MyThread2 extends Thread {
	private Object lock;

	public J02_MyThread2(Object lock) {
		super();
		this.lock = lock;
	}

	@Override
	public void run() {
		try {
			synchronized (lock) {
				for (int i = 0; i < 10; i++) {
					J03_MyList.add();
					if (J03_MyList.size() == 5) {
						lock.notify();
						System.out.println("已发出通知");
					}
					System.out.println("添加了"+(i+1)+"个元素");
					Thread.sleep(1000);
				}
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		try {
			Object lock=new Object();
			J01_MyThread1 t1=new J01_MyThread1(lock);
			t1.start();
			Thread.sleep(50);
			J02_MyThread2 t2=new J02_MyThread2(lock);
			t2.start();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
