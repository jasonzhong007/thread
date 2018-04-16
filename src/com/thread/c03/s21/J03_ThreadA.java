package com.thread.c03.s21;

/**
 * <p>
 * Function: InheritableThreadLocal可以在子线程中取得父线程继承下来的值
 * <p>
 * Description:
 * 
 * @since 1.0
 * @version 1.0
 * @author 1132381386@qq.com 钟秋森 2018年3月19日
 */
public class J03_ThreadA extends Thread{

	@Override
	public void run() {
		try {
			for (int i = 0; i < 10; i++) {
				System.out.println("在ThreadA线程中取值="+J02_Tools.t1.get());
				Thread.sleep(100);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		try {
			for (int i = 0; i < 10; i++) {
				System.out.println("     在Main线程中取值="+J02_Tools.t1.get());
				Thread.sleep(100);
			}
			Thread.sleep(5000);
			J03_ThreadA a=new J03_ThreadA();
			a.start();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
