package com.thread.c04.s16;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * <p>
 * Function:读写互斥
 * <p>
 * Description: ReentrantReadWriteLock 提供读写锁，
 * 多个读锁之间不互斥，读锁与写锁互斥，写锁与写锁互斥
 * 同一时刻只允许一个Thread进行写入操作
 * 
 * @since 1.0
 * @version 1.0
 * @author 1132381386@qq.com 钟秋森 2018年3月19日
 */
public class J03_MyService {
	private ReentrantReadWriteLock lock=new ReentrantReadWriteLock();

	public void read(){
		try {
			try {
				lock.readLock().lock();
				System.out.println(" 获得读锁"+Thread.currentThread().getName()+" "+System.currentTimeMillis());
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}finally{
				lock.readLock().unlock();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void write(){
		try {
			try {
				lock.writeLock().lock();
				System.out.println(" 获得写锁"+Thread.currentThread().getName()+" "+System.currentTimeMillis());
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}finally{
				lock.writeLock().unlock();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		J03_MyService service=new J03_MyService();
		Runnable a=new Runnable() {
			
			@Override
			public void run() {
				service.read();
			}
		};
		Runnable b=new Runnable() {
			
			@Override
			public void run() {
				service.write();
			}
		};
		Thread aThread=new Thread(a);
		Thread bThread=new Thread(b);
		aThread.start();
		Thread.sleep(1000);
		bThread.start();
	}
}
