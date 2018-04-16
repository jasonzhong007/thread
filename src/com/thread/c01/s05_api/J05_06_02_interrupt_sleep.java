package com.thread.c01.s05_api;

/**
 * <p>
 * Function:
 * <p>
 * Description:interrupt判断并进行终止线程,虽然停止了循环，但是后面的还是会执行
 * 
 * @since 1.0
 * @version 1.0
 * @author 1132381386@qq.com 钟秋森 2018年3月7日
 */
public class J05_06_02_interrupt_sleep extends Thread {

	public void run() {
		super.run();
		
		try {
			for (int i = 0; i < 100000; i++) {
				System.out.println("i=" + (i + 1));
			}
			System.out.println("run begin");
			Thread.sleep(200000);
			System.out.println("run end");
		} catch (Exception e) {
			System.out.println(" 先停止，再遇到了sleep!进入catch！");
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		J05_06_02_interrupt_sleep i=new J05_06_02_interrupt_sleep();
		i.start();
		i.interrupt();
		System.out.println("end!");
	}
}
