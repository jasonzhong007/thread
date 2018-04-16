package com.thread.c03.s19;

/**
 * <p>
 * Function: ThreadLocal 解决每个线程绑定自己的值， 可以看成是全局存放数据的盒子， 盒子中可以存储每个线程的私有数据
 * <p>
 * Description:
 * 
 * @since 1.0
 * @version 1.0
 * @author 1132381386@qq.com 钟秋森 2018年3月19日
 */
public class J03_ThreadA extends Thread {

	@Override
	public void run() {

		try {
			for (int i = 0; i < 100; i++) {
				System.out.println("在 ThreadA 线程中取值=" + J02_Tools.t1.get());
				Thread.sleep(100);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		try {
			for (int i = 0; i < 10; i++) {
				System.out.println("在 Main get Value=" + J02_Tools.t1.get());
				Thread.sleep(100);
			}
			Thread.sleep(5000);
			J03_ThreadA a=new J03_ThreadA();
			a.start();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
