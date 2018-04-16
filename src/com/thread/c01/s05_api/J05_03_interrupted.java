package com.thread.c01.s05_api;

/**
 * <p>
 * Function:
 * <p>
 * Description:interrupt判断并进行终止线程,虽然停止了循环，但是后面的还是会执行
 * 
 * @since 1.0
 * @version 1.0
 * @author 1132381386@qq.com 钟秋森 2018年3月7日
 */
public class J05_03_interrupted extends Thread {

	public void run() {
		super.run();
		for (int i = 0; i < 500000; i++) {
			if(this.interrupted()){
				System.out.println("已经是停止状态了！我要退出了！");
				break;
			}
			System.out.println("i=" + (i + 1));
		}
	}
	
	public static void main(String[] args) {
		try {
			J05_03_interrupted i=new J05_03_interrupted();
			i.start();
			Thread.sleep(2000);
			i.interrupt();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("end!");
	}
}
