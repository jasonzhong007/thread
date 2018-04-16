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
public class J05_ThreadB extends Thread {
	private J03_C r;

	public J05_ThreadB(J03_C r) {
		super();
		this.r = r;
	}

	@Override
	public void run() {
		while(true){
			r.popService();
		}
	}
	
	public static void main(String[] args) {
		J01_MyStack stack=new J01_MyStack();
		J02_P p=new J02_P(stack);
		J03_C r=new J03_C(stack);
		J04_ThreadA pThread=new J04_ThreadA(p);
		J05_ThreadB rThread=new J05_ThreadB(r);
		pThread.start();
		rThread.start();
	}
}
