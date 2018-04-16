package com.thread.c01.s05_api;

/**
 * <p>
 * Function:
 * <p>
 * Description:stop 暴力停止
 * stop已经作废，如果强制让线程停止则有可能使一些清理性的工作得不到完成。
 * 另外一个情况就是对锁定的对象进行了“解锁”，导致数据得不到同步的处理，出现数据的不一致的问题。
 * stop() 方法已经在JDK中被注明是“作废/过期”的方法，显然它在功能上具有缺陷，所以不建议在程序中使用stop()方法。
 * @since 1.0
 * @version 1.0
 * @author 1132381386@qq.com 钟秋森 2018年3月7日
 */
public class J06_03_02_SynchronizedThread extends Thread{
	private J06_03_01_SynchronizedObject object;

	public J06_03_02_SynchronizedThread(J06_03_01_SynchronizedObject object) {
		super();
		this.object = object;
	}
	
	@Override
	public void run() {
		object.printString("b", "bb");
	}
	
	public static void main(String[] args) throws InterruptedException {
		J06_03_01_SynchronizedObject object=new J06_03_01_SynchronizedObject();
		J06_03_02_SynchronizedThread thread=new J06_03_02_SynchronizedThread(object);
		thread.start();
		Thread.sleep(500);
		thread.stop();
		System.out.println("username="+object.getUsername()+" userpass="+object.getUserpass());
	}
	
}
