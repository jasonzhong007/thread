package com.thread.c04.s07;

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
 * Description:使用多个Condition实现通知部分线程
 * 
 * @since 1.0
 * @version 1.0
 * @author 1132381386@qq.com 钟秋森 2018年3月19日
 */
public class J01_MyService {

	private Lock lock = new ReentrantLock();
	private Condition conditionA = lock.newCondition();
	private Condition conditionB = lock.newCondition();

	public void awaitA() {
		try {
			lock.lock();
			System.out.println("begin awaitA await时间为 " + System.currentTimeMillis()+" ThreadName="+Thread.currentThread().getName());
			conditionA.await();
			System.out.println("end awaitA await时间为 " + System.currentTimeMillis()+" ThreadName="+Thread.currentThread().getName());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	
	public void awaitB() {
		try {
			lock.lock();
			System.out.println("begin awaitB await时间为 " + System.currentTimeMillis()+" ThreadName="+Thread.currentThread().getName());
			conditionB.await();
			System.out.println("end awaitB await时间为 " + System.currentTimeMillis()+" ThreadName="+Thread.currentThread().getName());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	
	public void signalAll_A(){
		try {
			lock.lock();
			System.out.println("signalAllA时间为"+System.currentTimeMillis()+" ThreadName="+Thread.currentThread().getName());
			conditionA.signalAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			lock.unlock();
		}
	}
	
	public void signalAll_B(){
		try {
			lock.lock();
			System.out.println("signalAllB时间为"+System.currentTimeMillis()+" ThreadName="+Thread.currentThread().getName());
			conditionB.signalAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			lock.unlock();
		}
	}

}
