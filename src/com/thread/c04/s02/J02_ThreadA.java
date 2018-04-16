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
public class J02_ThreadA extends Thread{

	private J01_MyService service;

	public J02_ThreadA(J01_MyService service) {
		super();
		this.service = service;
	}
	@Override
	public void run() {
		service.methodA();
	}
}
