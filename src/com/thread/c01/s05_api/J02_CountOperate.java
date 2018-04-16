package com.thread.c01.s05_api;

/**
 * <p>
 * Function:
 * <p>
 * Description:Thread.currentThread() 和 this的差异
 * 
 * @since 1.0
 * @version 1.0
 * @author 1132381386@qq.com 钟秋森 2018年3月7日
 */
public class J02_CountOperate extends Thread{
	
	
	public J02_CountOperate() {
		System.out.println("CountOperate---begin");
		System.out.println("Thread.currentThread().getName()="+Thread.currentThread().getName());
		System.out.println("Thread.currentThread().isAlive()="+Thread.currentThread().isAlive());
		System.out.println("this.getName()="+this.getName());
		System.out.println("this.isAlive()="+this.isAlive());
		System.out.println("CountOperate---end");
	}

	@Override
	public void run() {
		System.out.println("run---begin");
		System.out.println("Thread.currentThread().getName()="+Thread.currentThread().getName());
		System.out.println("Thread.currentThread().isAlive()="+Thread.currentThread().isAlive());
		System.out.println("this.getName()="+this.getName());
		System.out.println("this.isAlive()="+this.isAlive());
		System.out.println("run---end");
	}
	
	public static void main(String[] args) {
		J02_CountOperate c=new J02_CountOperate();
		Thread t1=new Thread(c);
		System.out.println("main begin t1 isAlive="+t1.isAlive());
		t1.setName("A");
		t1.start();
		System.out.println("main end t1 isAlive="+t1.isAlive());
	}
}
