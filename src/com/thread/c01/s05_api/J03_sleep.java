package com.thread.c01.s05_api;

/**
 * <p>
 * Function:
 * <p>
 * Description:在指定的毫秒数内让当前“正在执行的线程”休眠（暂停执行）
 * 
 * @since 1.0
 * @version 1.0
 * @author 1132381386@qq.com 钟秋森 2018年3月7日
 */
public class J03_sleep extends Thread{
	
	@Override
	public void run() {
		try {
			System.out.println("run threadName="+this.currentThread().getName()+" begin");
			Thread.sleep(2000);
			System.out.println("run threadName="+this.currentThread().getName()+" end");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		J03_sleep s=new J03_sleep();
		System.out.println("begin ="+System.currentTimeMillis());
		s.run();
		System.out.println("end ="+System.currentTimeMillis());
	}
}
