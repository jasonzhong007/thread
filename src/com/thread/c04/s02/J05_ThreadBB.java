package com.thread.c04.s02;

/**
 * <p>
 * Function: ReentrantLock类在功能上相对比synchronized更多
 * 调用ReenTrantLock对象的lock方法获取锁，调用unlock方法释放锁
 * <p>
 * Description:
 * 
 * @since 1.0
 * @version 1.0
 * @author 1132381386@qq.com 钟秋森 2018年3月19日
 */
public class J05_ThreadBB extends Thread{

	private J01_MyService service;

	public J05_ThreadBB(J01_MyService service) {
		super();
		this.service = service;
	}
	@Override
	public void run() {
		service.methodB();
	}
	
	public static void main(String[] args) {
		J01_MyService service=new J01_MyService();
		J02_ThreadA a=new J02_ThreadA(service);
		a.setName("A");
		a.start();
		J03_ThreadAA aa=new J03_ThreadAA(service);
		aa.setName("AA");
		aa.start();
		J04_ThreadB b=new J04_ThreadB(service);
		b.setName("B");
		b.start();
		J05_ThreadBB bb= new J05_ThreadBB(service);
		bb.setName("BB");
		bb.start();
	}
}
