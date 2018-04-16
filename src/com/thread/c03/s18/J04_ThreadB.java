package com.thread.c03.s18;

/**
 * <p>
 * Function: 
 * ThreadLocal 解决每个线程绑定自己的值，
 * 可以看成是全局存放数据的盒子，
 * 盒子中可以存储每个线程的私有数据
 * <p>
 * Description:
 * @since 1.0
 * @version 1.0
 * @author 1132381386@qq.com 钟秋森 2018年3月19日
 */
public class J04_ThreadB extends Thread{

	@Override
	public void run() {

		try {
			for (int i = 0; i < 100; i++) {
				J02_Tools.t1.set("ThreadB" + (i + 1));
				System.out.println("ThreadB get Value=" + J02_Tools.t1.get());
				Thread.sleep(200);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		try {
			J03_ThreadA a=new J03_ThreadA();
			J04_ThreadB b=new J04_ThreadB();
			a.start();
			b.start();
			for (int i = 0; i < 100; i++) {
				J02_Tools.t1.set("Main"+(i+1));
				System.out.println("Main get Value="+J02_Tools.t1.get());				
				Thread.sleep(200);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
