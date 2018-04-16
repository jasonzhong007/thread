package com.thread.c02.s14;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>
 * Function 使用 AtomicInterger 原子类进行synchronized同步的实现
 * <p>
 * @since 1.0
 * @version 1.0
 * @author 1132381386@qq.com 钟秋森 2018年3月8日
 */
public class J01_AddCountThread extends Thread {

	private AtomicInteger count =new AtomicInteger(0);


	@Override
	public void run() {
		for (int i = 0; i < 10000; i++) {
			System.out.println(count.incrementAndGet());
		}
	}
	
	public static void main(String[] args) {
		J01_AddCountThread countService=new J01_AddCountThread();
		Thread t1=new Thread(countService);
		t1.start();
		Thread t2=new Thread(countService);
		t2.start();
		Thread t3=new Thread(countService);
		t3.start();
		Thread t4=new Thread(countService);
		t4.start();
		Thread t5=new Thread(countService);
		t5.start();
	}
}
