package com.thread.c04.s12;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>
 * Function: 
 * <p>
 * Description:lockInterruptibly : 如果当前线程未被中断，则获取锁定，如果已经被中断则出现异常
 * @since 1.0
 * @version 1.0
 * @author 1132381386@qq.com 钟秋森 2018年3月19日
 */
public class J01_MyService {

	public ReentrantLock lock=new ReentrantLock();
	private Condition condition=lock.newCondition();
	
	public void waitMethod(){
		try {
			lock.lock();
			System.out.println("lock begin "+Thread.currentThread().getName());
			for (int i = 0; i < Integer.MAX_VALUE/10; i++) {
				Math.random();
			}
			System.out.println("lock end "+Thread.currentThread().getName());
		} finally{
			if(lock.isHeldByCurrentThread()){
				lock.unlock();
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		final J01_MyService service=new J01_MyService();
		Runnable runnableRef=new Runnable() {
			
			@Override
			public void run() {
				service.waitMethod();
				
			}
		};
		Thread threadA=new Thread(runnableRef);
		threadA.setName("A");
		threadA.start();
		Thread.sleep(500);
		Thread threadB=new Thread(runnableRef);
		threadB.setName("B");
		threadB.start();
		threadB.interrupt();//打标记
		System.out.println("main end!");
	}
}
