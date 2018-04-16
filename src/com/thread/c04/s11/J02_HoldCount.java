package com.thread.c04.s11;

import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>
 * Function: ReentrantLock类在功能上相对比synchronized更多
 * 调用ReenTrantLock对象的lock方法获取锁，调用unlock方法释放锁 借助Condition对象，实现
 * wait和notify/notifyAll的等待/通知模式
 * notify/notifyAll是通过JVM随机选择的，但是ReentrantLock+Condition可以实现“选择性通知”
 * <p>
 * Description:公平与非公平锁-Lock：
 * 公平锁按照线程加锁的顺序来分配，先来先得的FIFO先进先出顺序。
 * 非公平锁是一种获取锁的抢占机制，是随机得锁的，可能造成某线程一直拿不到锁，结果也就是不公平的了。
 * @since 1.0
 * @version 1.0
 * @author 1132381386@qq.com 钟秋森 2018年3月19日
 */
public class J02_HoldCount {

	private ReentrantLock lock;

	public J02_HoldCount(boolean isFair) {
		super();
		lock=new ReentrantLock(isFair);
	}
	
	public void serviceMethod(){
		try {
			lock.lock();
			System.out.println("ThreadName="+Thread.currentThread().getName()+"获得锁定");
		}finally{
			lock.unlock();
		}
	}

	public static void main(String[] args) {
		//公平
		final J02_HoldCount service=new J02_HoldCount(true);
		Runnable runnable=new Runnable() {
			
			@Override
			public void run() {
				System.out.println("@线程"+Thread.currentThread().getName()+"运行了");
				service.serviceMethod();
				
			}
		};
		Thread[] threadArray=new Thread[10];
		for (int i = 0; i < 10; i++) {
			threadArray[i]=new Thread(runnable);
		}
		for (int i = 0; i < 10; i++) {
			threadArray[i].start();
		}
		
		//不公平
//		final J01_MyService service1=new J01_MyService(false);
//		Runnable runnable1=new Runnable() {
//			
//			@Override
//			public void run() {
//				System.out.println("@线程"+Thread.currentThread().getName()+"运行了");
//				service1.serviceMethod();
//				
//			}
//		};
//		Thread[] threadArray1=new Thread[10];
//		for (int i = 0; i < 10; i++) {
//			threadArray1[i]=new Thread(runnable1);
//		}
//		for (int i = 0; i < 10; i++) {
//			threadArray1[i].start();
//		}
	}
	
}
