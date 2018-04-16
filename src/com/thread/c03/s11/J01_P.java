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
					lock.wait();
				}
				String value=System.currentTimeMillis()+"_"+System.nanoTime();
				System.out.println("set 的值是"+ value);
				J02_ValueObject.value=value;
				lock.notify();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
