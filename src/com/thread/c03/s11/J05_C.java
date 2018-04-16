package com.thread.c03.s11;

/**
 * <p>
 * Function: 生产者/消费者模式实现
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
					lock.wait();
				}
				System.out.println("get 的值是"+ J02_ValueObject.value);
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
		J03_ThreadA addThread=new J03_ThreadA(p);
		addThread.start();
		J04_ThreadB subtract1Thread=new J04_ThreadB(c);
		subtract1Thread.start();

	}
}
