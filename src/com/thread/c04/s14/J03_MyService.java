package com.thread.c04.s14;

import java.util.Calendar;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>
 * Function:
 * <p>
 * Description: awaitUntil(Date deadline) : 
 * 适用条件与行为与awaitNanos(long nanosTimeout)完全一样，
 * 唯一不同点在于它不是等待指定时间，而是等待由参数指定的某一时刻。
 * 
 * @since 1.0
 * @version 1.0
 * @author 1132381386@qq.com 钟秋森 2018年3月19日
 */
public class J03_MyService {

	public ReentrantLock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();

	public void waitMethod() {
		try {
			Calendar calendarRef=Calendar.getInstance();
			calendarRef.add(Calendar.SECOND, 10);
			lock.lock();
			System.out.println("wait begin timer="+System.currentTimeMillis());
			condition.awaitUntil(calendarRef.getTime());
			System.out.println("wait    end timer="+System.currentTimeMillis());
		} catch (Exception e) {
			System.out.println("catch");
			e.printStackTrace();
		}finally{
			lock.unlock();
		}
		
	}
	public void notifyMethod(){
		try {
			Calendar calendarRef=Calendar.getInstance();
			calendarRef.add(Calendar.SECOND, 3);
			lock.lock();
			System.out.println("notify begin timer="+System.currentTimeMillis());
			condition.signalAll();
			System.out.println("notify    end timer="+System.currentTimeMillis());
		}finally{
			lock.unlock();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		final J03_MyService service = new J03_MyService();
		Runnable runnableA = new Runnable() {

			@Override
			public void run() {
				service.waitMethod();

			}
		};
		Runnable runnableB = new Runnable() {
			
			@Override
			public void run() {
				service.notifyMethod();
				
			}
		};
		Thread threadA = new Thread(runnableA);
		threadA.setName("A");
		threadA.start();
		Thread.sleep(2000);
		Thread threadB = new Thread(runnableB);
		threadB.setName("B");
		threadB.start();
	}
}
