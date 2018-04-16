package com.thread.c01.s05_api;

/**
 * <p>
 * Function:
 * <p>
 * Description:在sleep中interrupt。会进入catch并且清除停止状态值
 * 
 * @since 1.0
 * @version 1.0
 * @author 1132381386@qq.com 钟秋森 2018年3月7日
 */
public class J05_06_01_interrupt_sleep extends Thread {


	public void run() {
		super.run();
		try {
			System.out.println("run begin");
			Thread.sleep(200000);
			System.out.println("run end");
		} catch (InterruptedException e) {
			System.out.println("在沉睡中被停止！进去catch！"+this.isInterrupted());
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		try {
			J05_06_01_interrupt_sleep i = new J05_06_01_interrupt_sleep();
			i.start();
			Thread.sleep(200);
			i.interrupt();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("end!");
	}
}
