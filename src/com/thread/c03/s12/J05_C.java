package com.thread.c03.s12;

/**
 * <p>
 * Function: 生产者/消费者模式实现 多线程
 * <p>
 * Description:
 * 
 * @since 1.0
 * @version 1.0
 * @author 1132381386@qq.com 钟秋森 2018年3月19日
 */
//消费者
public class J05_C{	
	private String lock;

	public J05_C(String lock) {
		super();
		this.lock = lock;
	}

	public void getValue() {
		try {
			synchronized (lock){
				if(J02_ValueObject.value.equals("")){
					System.out.println(" 消费者 "+Thread.currentThread().getName()+" WAITING了");
					lock.wait();
				}
				System.out.println(" 消费者 "+Thread.currentThread().getName()+" WAITING了");
				J02_ValueObject.value="";
				lock.notify();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		String lock=new String("");
		J01_P p=new J01_P(lock);
		J05_C c=new J05_C(lock);
		J03_ThreadA[] pThread=new J03_ThreadA[2];
		J04_ThreadB[] cThread=new J04_ThreadB[2];
		for (int i = 0; i < 2; i++) {
			pThread[i]=new J03_ThreadA(p);
			pThread[i].setName(" 生产者 "+(i+1));
			cThread[i]=new J04_ThreadB(c);
			cThread[i].setName(" 消费者 "+(i+1));
			pThread[i].start();
			cThread[i].start();
		}
		Thread.sleep(5000);
		Thread[] threadArray=new Thread[Thread.currentThread().getThreadGroup().activeCount()];
		Thread.currentThread().getThreadGroup().enumerate(threadArray);
		for (int i = 0; i < threadArray.length; i++) {
			System.out.println(threadArray[i].getName()+" "+threadArray[i].getState());
		}

	}
}
