package com.thread.c04.s08;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>
 * Function: ReentrantLock类在功能上相对比synchronized更多
 * 调用ReenTrantLock对象的lock方法获取锁，调用unlock方法释放锁 借助Condition对象，实现
 * wait和notify/notifyAll的等待/通知模式
 * notify/notifyAll是通过JVM随机选择的，但是ReentrantLock+Condition可以实现“选择性通知”
 * <p>
 * Description:实现生产者/消费者模式：一对一交替打印
 * 
 * @since 1.0
 * @version 1.0
 * @author 1132381386@qq.com 钟秋森 2018年3月19日
 */
public class J01_MyService {

	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();
	private boolean hasValue=false;

	public void set() {
		try {
			lock.lock();
			while(hasValue==true){
				condition.await();
			}
			System.out.println("打印@@@");
			hasValue=true;
			condition.signal();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	
	public void get(){
		try {
			lock.lock();
			while(hasValue==false){
				condition.await();
			}
			System.out.println("打印***");
			hasValue=false;
			condition.signal();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	
}
