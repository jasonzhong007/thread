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
//生产者
public class J01_P{	
	private String lock;

	public J01_P(String lock) {
		super();
		this.lock = lock;
	}

	public void setValue() {
		try {
			synchronized (lock){
				if(!J02_ValueObject.value.equals("")){
					System.out.println(" 生产者 "+Thread.currentThread().getName()+" WAITING了");
					lock.wait();
				}
				System.out.println(" 生产者 "+Thread.currentThread().getName()+" PUNNABLE了");
				String value=System.currentTimeMillis()+"_"+System.nanoTime();
				J02_ValueObject.value=value;
				lock.notify();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
