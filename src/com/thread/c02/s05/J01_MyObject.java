package com.thread.c02.s05;

/**
 * <p>
 * Function:多个对象多个锁 tow object tow lock,验证线程锁的是对象
 * <p>
 * Description: synchronized 同步方法，方法内的变量为线程安全
 * 
 * @since 1.0
 * @version 1.0
 * @author 1132381386@qq.com 钟秋森 2018年3月8日
 */
public class J01_MyObject {
	//synchronized是后续加上
	synchronized public void methodA(){
		
		try {
			System.out.println("begin methodA threadName="+Thread.currentThread().getName()+" begin time="+System.currentTimeMillis());
			Thread.sleep(5000);
			System.out.println("end");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void methodB(){
		
		try {
			System.out.println("begin methodB threadName="+Thread.currentThread().getName()+" begin time="+System.currentTimeMillis());
			Thread.sleep(5000);
			System.out.println("end");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
