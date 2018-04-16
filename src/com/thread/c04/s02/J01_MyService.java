package com.thread.c04.s02;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>
 * Function: ReentrantLock类在功能上相对比synchronized更多
 * 调用ReenTrantLock对象的lock方法获取锁，调用unlock方法释放锁
 * <p>
 * Description:
 * 
 * @since 1.0
 * @version 1.0
 * @author 1132381386@qq.com 钟秋森 2018年3月19日
 */
public class J01_MyService {

	private Lock lock = new ReentrantLock();
	
	public void methodA(){
		try {
			lock.lock();
			System.out.println("methodA begin ThreadName="+Thread.currentThread().getName()+" time="+System.currentTimeMillis());
			Thread.sleep(5000);
			System.out.println("methodA end ThreadName="+Thread.currentThread().getName()+" time="+System.currentTimeMillis());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			lock.unlock();
		}
	}

	public void methodB(){
		try {
			lock.lock();
			System.out.println("methodB begin ThreadName="+Thread.currentThread().getName()+" time="+System.currentTimeMillis());
			Thread.sleep(5000);
			System.out.println("methodB end ThreadName="+Thread.currentThread().getName()+" time="+System.currentTimeMillis());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			lock.unlock();
		}
	}
}
