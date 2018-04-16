package com.thread.c02.s16;

/**
 * <p>
 * Function synchronized 可以使多线程访问同一个资源具有同步性，而且它还具有将线程工作内存中
 * 的私有变量和公共内存中的变量同步的功能
 * 
 * *********学习多线程并发，要着重 “外练互斥，内修可见”，这是掌握多线程，学习多线程并发的重要技术点*********
 * <p>
 * @since 1.0
 * @version 1.0
 * @author 1132381386@qq.com 钟秋森 2018年3月8日
 */
public class J03_ThreadB extends Thread{

	private J01_SynchronizedUpdateNewValue service;
	
	public J03_ThreadB(J01_SynchronizedUpdateNewValue service) {
		super();
		this.service = service;
	}

	@Override
	public void run() {
		service.stopMethod();
	}
	
	public static void main(String[] args) {
		try {
			J01_SynchronizedUpdateNewValue service=new J01_SynchronizedUpdateNewValue();
			J02_ThreadA a=new J02_ThreadA(service);
			a.start();
			Thread.sleep(1000);
			J03_ThreadB b=new J03_ThreadB(service);
			b.start();
			System.out.println("已经发起停止的命令了！");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
