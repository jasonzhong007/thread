package com.thread.c01.s05_api;

/**
 * <p>
 * Function:
 * <p>
 * Description:suspend 暂停，resume 恢复,缺点--独占
 * @since 1.0
 * @version 1.0
 * @author 1132381386@qq.com 钟秋森 2018年3月7日
 */
public class J07_02_suspend_resume_dea_lock{

	synchronized public void printString(){
		System.out.println("begin");
		System.out.println("当先线程Name="+Thread.currentThread().getName());
		if(Thread.currentThread().getName().equals("a")){
			System.out.println("a 线程永远 suspend");
			Thread.currentThread().suspend();
		}
		System.out.println("end");
	}
	
	public static void main(String[] args) throws InterruptedException {
		final J07_02_suspend_resume_dea_lock s=new J07_02_suspend_resume_dea_lock();
		Thread thread1=new Thread(){
			public void run() {
				s.printString();
			};
		};
		thread1.setName("a");
		thread1.start();
		Thread.sleep(1000);
		Thread thread2=new Thread(){
			@Override
			public void run() {
				System.out.println("thread2启动了，但是进入不了printString()方法！只打印1个begin");
				System.out.println(" 因为printString()方法被线程a锁定并且永远的suspend暂停了");
				s.printString();
			}
		};
		thread2.start();
	}
}
