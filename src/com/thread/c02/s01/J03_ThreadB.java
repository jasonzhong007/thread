package com.thread.c02.s01;

/**
 * <p>
 * Function:
 * <p>
 * Description: synchronized 同步方法，方法内的变量为线程安全,因为变量是私有的
 * 
 * @since 1.0
 * @version 1.0
 * @author 1132381386@qq.com 钟秋森 2018年3月8日
 */
public class J03_ThreadB extends Thread{
	private J01_HasSelfPrivateNum numRef;

	public J03_ThreadB(J01_HasSelfPrivateNum numRef) {
		super();
		this.numRef = numRef;
	}
	@Override
	public void run() {
		super.run();
		try {
			numRef.addI("b");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		J01_HasSelfPrivateNum numRef=new J01_HasSelfPrivateNum();
		J02_ThreadA athread=new J02_ThreadA(numRef);
		athread.start();
		J03_ThreadB bthread=new J03_ThreadB(numRef);
		bthread.start();
		
	}

}
