package com.thread.c03.s13;

/**
 * <p>
 * Function: 生产者/消费者模式实现 一生产与一消费：操作栈
 * <p>
 * Description:
 * 
 * @since 1.0
 * @version 1.0
 * @author 1132381386@qq.com 钟秋森 2018年3月19日
 */
public class J04_ThreadA extends Thread {
	private J02_P c;

	public J04_ThreadA(J02_P c) {
		super();
		this.c = c;
	}

	@Override
	public void run() {
		while(true){
			c.pushService();
		}
	}
	
}
