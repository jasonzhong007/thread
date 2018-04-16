package com.thread.c01.s05_api;

/**
 * <p>
 * Function:
 * <p>
 * Description:interrupted判断并进行终止线程,抛异常
 * 
 * @since 1.0
 * @version 1.0
 * @author 1132381386@qq.com 钟秋森 2018年3月7日
 */
public class J05_05_interrupted extends Thread {

	@SuppressWarnings("static-access")
	public void run() {
		super.run();
		try {
			for (int i = 0; i < 500000; i++) {
				if (this.interrupted()) {
					System.out.println("已经是停止状态了！我要退出了！");
					throw new InterruptedException();
				}
				System.out.println("i=" + (i + 1));
			}
			System.out.println("我在for下面");
		} catch (InterruptedException e) {
			System.out.println("进 S05_05_interrupted.java 类方法中的catch了！");
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		try {
			J05_05_interrupted i = new J05_05_interrupted();
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
