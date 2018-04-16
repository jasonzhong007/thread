package com.thread.c01.s05_api;

/**
 * <p>
 * Function:
 * <p>
 * Description:interrupt不能终止线程
 * 
 * @since 1.0
 * @version 1.0
 * @author 1132381386@qq.com 钟秋森 2018年3月7日
 */
public class J05_01_interrupt extends Thread {

	public void run() {
		super.run();
		for (int i = 0; i < 500000; i++) {
			System.out.println("i=" + (i + 1));
		}
	}
	
	public static void main(String[] args) {
		try {
			J05_01_interrupt i=new J05_01_interrupt();
			i.start();
			Thread.sleep(2000);
			i.interrupt();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
