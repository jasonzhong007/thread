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
public class J05_ThreadB extends Thread {
	private J02_Subtract subtract;

	public J05_ThreadB(J02_Subtract subtract) {
		super();
		this.subtract = subtract;
	}

	@Override
	public void run() {
		subtract.subtract();
	}
	
	public static void main(String[] args) throws InterruptedException {
		String lock=new String("");
		J01_Add add=new J01_Add(lock);
		J02_Subtract subtract=new J02_Subtract(lock);
		J05_ThreadB subtract1Thread=new J05_ThreadB(subtract);
		subtract1Thread.setName("subtract1Thread");
		subtract1Thread.start();
		
		J05_ThreadB subtract2Thread=new J05_ThreadB(subtract);
		subtract2Thread.setName("subtract2Thread");
		subtract2Thread.start();
		Thread.sleep(1000);

		J04_ThreadA addThread=new J04_ThreadA(add);
		addThread.setName("addThread");
		addThread.start();
	}
}
