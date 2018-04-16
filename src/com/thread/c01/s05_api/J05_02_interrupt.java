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
public class J05_02_interrupt extends Thread {

	public void run() {
		super.run();
		for (int i = 0; i < 500000; i++) {
			System.out.println("i=" + (i + 1));
		}
	}
	
	public static void main(String[] args) {
//		try {
//			S05_02_interrupt i=new S05_02_interrupt();
//			i.start();
//			Thread.sleep(1000);
//			i.interrupt();
//			//Thread.currentThread.interrupt();
//			System.out.println(" 是否停止1？="+i.interrupted());
//			System.out.println(" 是否停止2？="+i.isInterrupted());
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println("end!");
		
		/*
		 * 如果连续两次调用interruoted,第二次回返回false
		 * interrupted会清除线程的中断状态,将状态重置为false
		 */
//		System.out.println("*****double interrupted*****");
//		Thread.currentThread().interrupt();
//		System.out.println(" 是否停止1？="+Thread.interrupted());
//		System.out.println(" 是否停止2？="+Thread.interrupted());
//		System.out.println("end!");
		
		/*
		 * isInterrupted方法不会清除状态标志
		 */
		try {
			J05_02_interrupt i=new J05_02_interrupt();
			i.start();
			Thread.sleep(3777);
			i.interrupt();
			System.out.println(" 是否停止1？="+i.isInterrupted());
			System.out.println(" 是否停止2？="+i.isInterrupted());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("end!");
	}
}
