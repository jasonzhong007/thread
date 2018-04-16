package com.thread.c01.s03_share;

/**
 * <p>
 * Function:
 * <p>
 * Description:
 * 
 * @since 1.0
 * @version 1.0
 * @author 1132381386@qq.com 钟秋森 2018年3月7日
 */
public class J03_synchronized extends Thread {
	private int count = 5;

	@SuppressWarnings("static-access")
	@Override
	synchronized public void run() {
		super.run();
		count--;
		System.out.println("由" + this.currentThread().getName() + " 计算，count=" + count);
	}
	
	public static void main(String[] args) {
		J03_synchronized s02_ThreadShare=new J03_synchronized();
		Thread a=new Thread(s02_ThreadShare,"A");
		Thread b=new Thread(s02_ThreadShare,"B");
		Thread c=new Thread(s02_ThreadShare,"C");
		Thread d=new Thread(s02_ThreadShare,"D");
		Thread e=new Thread(s02_ThreadShare,"E");
		a.start();
		b.start();
		c.start();
		d.start();
		e.start();
	}
}
