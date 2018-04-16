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
public class J01_ThreadNotShare extends Thread {
	private int count = 5;

	public J01_ThreadNotShare(String name) {
		super();
		this.setName(name);
	};

	@SuppressWarnings("static-access")
	@Override
	public void run() {
		super.run();
		while (count > 0) {
			count--;
			System.out.println("由" + this.currentThread().getName() + " 计算，count=" + count);
		}
	}
	
	public static void main(String[] args) {
		J01_ThreadNotShare a=new J01_ThreadNotShare("A");
		J01_ThreadNotShare b=new J01_ThreadNotShare("B");
		J01_ThreadNotShare c=new J01_ThreadNotShare("C");
		a.start();
		b.start();
		c.start();
	}
}
