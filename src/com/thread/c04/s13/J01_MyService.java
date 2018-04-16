package com.thread.c04.s13;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>
 * Function:
 * <p>
 * Description: tryLock : 仅在调用时锁定未被另外一个线程报错的情况下，才获取该锁定
 * 
 * @since 1.0
 * @version 1.0
 * @author 1132381386@qq.com 钟秋森 2018年3月19日
 */
public class J01_MyService {

	public ReentrantLock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();

	public void waitMethod() {
		if(lock.tryLock()){
			System.out.println(Thread.currentThread().getName()+" 获得锁,时间："+System.currentTimeMillis());
		}else{
			System.out.println(Thread.currentThread().getName()+" 没有获得锁,时间："+System.currentTimeMillis());
		}
	}

	public static void main(String[] args) throws InterruptedException {
		final J01_MyService service = new J01_MyService();
		Runnable runnableRef = new Runnable() {

			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName()+" 调用waitMethod时间："+System.currentTimeMillis());
				service.waitMethod();

			}
		};
		Thread threadA = new Thread(runnableRef);
		threadA.setName("A");
		threadA.start();
		Thread.sleep(500);
		Thread threadB = new Thread(runnableRef);
		threadB.setName("B");
		threadB.start();
	}
}
