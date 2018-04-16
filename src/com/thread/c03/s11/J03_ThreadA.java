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
public class J03_ThreadA extends Thread {
	private J01_P p;

	public J03_ThreadA(J01_P p) {
		super();
		this.p = p;
	}

	@Override
	public void run() {
		while(true){
			p.setValue();
		}
	}
}
