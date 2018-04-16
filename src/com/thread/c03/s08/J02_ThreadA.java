package com.thread.c03.s08;

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
public class J02_ThreadA extends Thread {
	private Object lock;

	public J02_ThreadA(Object lock) {
		super();
		this.lock = lock;
	}

	@Override
	public void run() {
		J01_Service service=new J01_Service();
		service.testMethod(lock);
	}
	
	public static void main(String[] args) {
		try {
			Object lock=new Object();
			J02_ThreadA a=new J02_ThreadA(lock);
			a.start();
			Thread.sleep(5000);
			a.interrupt();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
