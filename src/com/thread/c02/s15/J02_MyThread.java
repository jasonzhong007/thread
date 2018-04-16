package com.thread.c02.s15;

/**
 * <p>
 * Function 使用 AtomicInteger 原子类进行synchronized同步的实现
 * 但是原子类在具有有逻辑性的情况下输出结果也具有随机性
 * <p>
 * @since 1.0
 * @version 1.0
 * @author 1132381386@qq.com 钟秋森 2018年3月8日
 */
public class J02_MyThread extends Thread{

	private J01_AtomicIntergerNoSafe service ;


	public J02_MyThread(J01_AtomicIntergerNoSafe service) {
		super();
		this.service = service;
	}

	@Override
	public void run() {
		service.addNum();
	}
	
	public static void main(String[] args) {
		
		try {
			J01_AtomicIntergerNoSafe service=new J01_AtomicIntergerNoSafe();
			J02_MyThread[] array=new J02_MyThread[5];
			for (int i = 0; i < array.length; i++) {
				array[i]=new  J02_MyThread(service);
			}
			for (int i = 0; i < array.length; i++) {
				array[i].start();
			}
			Thread.sleep(1000);
			System.out.println(service.count.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
