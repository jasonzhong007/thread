package com.thread.c01.s05_api;

/**
 * <p>
 * Function:
 * <p>
 * Description:priority 线程优先级，1-10个等级，超出JDK抛IllegalArgumentException
 * 预置 MIN_PRIORITY=1,NORM_PRIORITY=5,MAX_PRIORITY=10
 * 线程优先级具有继承性，比如A线程启动B线程，则B线程的优先级与A是一样的
 * @since 1.0
 * @version 1.0
 * @author 1132381386@qq.com 钟秋森 2018年3月7日
 */
public class J09_01_priority extends Thread{

	@Override
	public void run() {
		System.out.println("S06_07_priority run priority="+this.getPriority());
		J08_yield y=new J08_yield();
		y.start();
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		System.out.println("main priority="+Thread.currentThread().getPriority());
		Thread.currentThread().setPriority(7);
		System.out.println("main priority="+Thread.currentThread().getPriority());
		J09_01_priority s=new J09_01_priority();
		s.start();
	}
}
