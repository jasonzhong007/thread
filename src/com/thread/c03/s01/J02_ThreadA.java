package com.thread.c03.s01;

/**
 * <p>Function: 线程间的通信
 * <p>Description:       		
 * @since 1.0   
 * @version 1.0  
 * @author 1132381386@qq.com 钟秋森 2018年3月19日 
*/
public class J02_ThreadA extends Thread{
	private J01_MyList list;
	
	public J02_ThreadA(J01_MyList list) {
		this.list = list;
	}
	
	@Override
	public void run() {
		try {
			for (int i = 0; i < 10; i++) {
				list.add();
				System.out.println("添加了"+(i+1)+"个元素");
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
