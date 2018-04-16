package com.thread.c03.s06;

/**
 * <p>
 * Function: wait notify
 * <p>
 * Description:
 * 当方法wait被执行后，锁被自动释放，但执行完notify方法，锁却不自动释放
 * @since 1.0
 * @version 1.0
 * @author 1132381386@qq.com 钟秋森 2018年3月19日
 */
public class J01_Service extends Thread {
	public void testMethod(Object lock){
		try {
			synchronized (lock){
				System.out.println("begin wait");
				//将wait换成sleep
//				lock.wait();
				Thread.sleep(4000);
				System.out.println("end wait");
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
