package com.thread.c02.s04;

/**
 * <p>
 * Function:
 * <p>
 * Description: synchronized 同步方法,验证线程锁的是对象
 * 
 * @since 1.0
 * @version 1.0
 * @author 1132381386@qq.com 钟秋森 2018年3月8日
 */
public class J02_ThreadA extends Thread{
	private J01_MyObject numRef;

	public J02_ThreadA(J01_MyObject numRef) {
		super();
		this.numRef = numRef;
	}
	@Override
	public void run() {
		super.run();
		numRef.methodA();
	}

}
