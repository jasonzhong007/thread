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
public class J04_ThreadB extends Thread {
	private J05_C c;

	public J04_ThreadB(J05_C c) {
		super();
		this.c = c;
	}

	@Override
	public void run() {
		while(true){
			c.getValue();
		}
	}
	
}
