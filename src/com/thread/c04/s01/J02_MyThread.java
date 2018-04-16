package com.thread.c04.s01;

/**
 * <p>
 * Function: ReentrantLock类在功能上相对比synchronized更多
 * <p>
 * Description:
 * 
 * @since 1.0
 * @version 1.0
 * @author 1132381386@qq.com 钟秋森 2018年3月19日
 */
public class J02_MyThread extends Thread {

	private J01_MyService service;

	public J02_MyThread(J01_MyService service) {
		super();
		this.service = service;
	}

	@Override
	public void run() {
		service.testMethod();
	}
	
	public static void main(String[] args) {
		J01_MyService service=new J01_MyService();
		
		J02_MyThread a1=new J02_MyThread(service);
		J02_MyThread a2=new J02_MyThread(service);
		J02_MyThread a3=new J02_MyThread(service);
		J02_MyThread a4=new J02_MyThread(service);
		J02_MyThread a5=new J02_MyThread(service);
		a1.start();
		a2.start();
		a3.start();
		a4.start();
		a5.start();
	}
}
