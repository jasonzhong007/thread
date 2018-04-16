package com.thread.c01.s05_api;

/**
 * <p>
 * Function:
 * <p>
 * Description:守护进程，典型：GC(垃圾回收器)
 * 
 * @since 1.0
 * @version 1.0
 * @author 1132381386@qq.com 钟秋森 2018年3月7日
 */
public class J11_daemon_thread extends Thread {
	private int i = 0;

	@Override
	public void run() {
		try {
			while (true) {
				i++;
				System.out.println("i=" + (i));
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) throws InterruptedException {
		J11_daemon_thread a = new J11_daemon_thread();
		a.setDaemon(true);
		a.start();
		Thread.sleep(5000);
		System.out.println("我离开thread 对象也不再打印了，也就是停止了");
	}
}
