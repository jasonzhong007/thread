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
public class J03_ThreadB extends Thread{
	private Object lock;

	public J03_ThreadB(Object lock) {
		super();
		this.lock = lock;
	}

	@Override
	public void run() {
		J01_Service service=new J01_Service();
		service.testMethod(lock);
	}
	
	public static void main(String[] args) {
		Object lock=new Object();
		J02_ThreadA t1=new J02_ThreadA(lock);
		t1.start();
		J03_ThreadB t2=new J03_ThreadB(lock);
		t2.start();
	}
}
