package com.thread.c04.s15;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>
 * Function:
 * <p>
 * Description: 使用Condition实现顺序执行
 * 
 * @since 1.0
 * @version 1.0
 * @author 1132381386@qq.com 钟秋森 2018年3月19日
 */
public class J01_MyService {
	volatile private static int nextPrintWho = 1;
	private static ReentrantLock lock = new ReentrantLock();
	final private static Condition conditionA = lock.newCondition();
	final private static Condition conditionB = lock.newCondition();
	final private static Condition conditionC = lock.newCondition();

	public static void main(String[] args) throws InterruptedException {
		Thread a = new Thread() {
			@Override
			public void run() {
				try {
					lock.lock();
					while (nextPrintWho != 1) {
						conditionA.await();
					}
					for (int i = 0; i < 3; i++) {
						System.out.println("ThreadA " + (i + 1));
					}
					nextPrintWho = 2;
					conditionB.signalAll();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}finally{
					lock.unlock();
				}
			}
		};
		Thread b = new Thread() {
			@Override
			public void run() {
				try {
					lock.lock();
					while (nextPrintWho != 2) {
						conditionB.await();
					}
					for (int i = 0; i < 3; i++) {
						System.out.println("ThreadB " + (i + 1));
					}
					nextPrintWho = 3;
					conditionC.signalAll();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}finally{
					lock.unlock();
				}
			}
		};
		Thread c = new Thread() {
			@Override
			public void run() {
				try {
					lock.lock();
					while (nextPrintWho != 3) {
						conditionC.await();
					}
					for (int i = 0; i < 3; i++) {
						System.out.println("ThreadB " + (i + 1));
					}
					nextPrintWho = 1;
					conditionA.signalAll();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}finally{
					lock.unlock();
				}
			}
		};
		Thread[] aArray=new Thread[5];
		Thread[] bArray=new Thread[5];
		Thread[] cArray=new Thread[5];
		
		for (int i = 0; i < 5; i++) {
			aArray[i]=new Thread(a);
			bArray[i]=new Thread(b);
			cArray[i]=new Thread(c);
			aArray[i].start();
			bArray[i].start();
			cArray[i].start();
		}
	}
}
