package com.thread.c02.s03;

/**
 * <p>
 * Function:
 * <p>
 * Description: synchronized 同步方法，方法内的变量为线程安全,因为变量是私有的，
 * 解决方法：在 addI方法前面加上 synchronized
 * 多个对象多个锁 tow object tow lock
 * 打印的顺序不是同步的，是交叉的，这个是对象锁lock,而不是一段代码或方法，当访问同一个对象时有效
 * 
 * synchronized 同步
 * asynchronized 异步
 * 
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
	
	/**
	 * 多个对象多个锁 tow object tow lock
	 * @param args
	 * @author 1132381386@qq.com 钟秋森 2018年3月8日
	 */
	public static void main(String[] args) {
		J01_HasSelfPrivateNum numRef1=new J01_HasSelfPrivateNum();
		J01_HasSelfPrivateNum numRef2=new J01_HasSelfPrivateNum();
		J02_ThreadA athread=new J02_ThreadA(numRef1);
		athread.start();
		J03_ThreadB bthread=new J03_ThreadB(numRef2);
		bthread.start();
		
	}

}
