package com.thread.c03.s17;

/**
 * <p>
 * Function: join 等待线程对象销毁
 * <p>
 * Description:
 * 方法join具有使线程排队运行的作用，有些类似同步的运行效果。
 * join与synchronized的区别是：join在内部使用wait()方法进行等待，
 * 而synchronized关键字使用的是“对象监控”原理做为同步
 * 在join过程中，如果当前线程对象被中断，则当前线程出现异常
 * @since 1.0
 * @version 1.0
 * @author 1132381386@qq.com 钟秋森 2018年3月19日
 */
public class J03_ThreadC extends Thread{
	private J02_ThreadB threadB;
	
	public J03_ThreadC(J02_ThreadB threadB) {
		super();
		this.threadB = threadB;
	}


	@Override
	public void run() {
		
		threadB.interrupt();
	}

	public static void main(String[] args) {
		try {
			J02_ThreadB b=new J02_ThreadB();
			b.start();
			Thread.sleep(500);
			J03_ThreadC c=new J03_ThreadC(b);
			c.start();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
