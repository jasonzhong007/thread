package com.thread.c01.s05_api;

/**
 * <p>
 * Function:
 * <p>
 * Description:stop 暴力停止
 * stop已经作废，如果强制让线程停止则有可能使一些清理性的工作得不到完成。
 * 另外一个情况就是对锁定的对象进行了“解锁”，导致数据得不到同步的处理，出现数据的不一致的问题。
 * 
 * @since 1.0
 * @version 1.0
 * @author 1132381386@qq.com 钟秋森 2018年3月7日
 */
public class J06_02_stop_ThreadDeath extends Thread {
	private int i = 0;

	@Override
	public void run() {
		super.run();

		try {
			this.stop();
		} catch (ThreadDeath e) {
			System.out.println("进入了catch()方法！");
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		J06_02_stop_ThreadDeath i = new J06_02_stop_ThreadDeath();
		i.start();

	}
}
