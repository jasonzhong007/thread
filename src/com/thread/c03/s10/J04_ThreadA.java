package com.thread.c03.s10;

/**
 * <p>
 * Function: 如果wait等待的条件发生了变化，也容易造成程序逻辑的混乱
 * <p>
 * Description:
 * 
 * @since 1.0
 * @version 1.0
 * @author 1132381386@qq.com 钟秋森 2018年3月19日
 */
public class J04_ThreadA extends Thread {
	private J01_Add add;

	public J04_ThreadA(J01_Add add) {
		super();
		this.add = add;
	}

	@Override
	public void run() {
		add.Add();
	}
}
