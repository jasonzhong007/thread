package com.thread.c02.s01;

/**
 * <p>
 * Function:
 * <p>
 * Description: synchronized 同步方法，方法内的变量为线程安全
 * 
 * @since 1.0
 * @version 1.0
 * @author 1132381386@qq.com 钟秋森 2018年3月8日
 */
public class J02_ThreadA extends Thread{
	private J01_HasSelfPrivateNum numRef;

	public J02_ThreadA(J01_HasSelfPrivateNum numRef) {
		super();
		this.numRef = numRef;
	}
	@Override
	public void run() {
		super.run();
		try {
			numRef.addI("a");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
