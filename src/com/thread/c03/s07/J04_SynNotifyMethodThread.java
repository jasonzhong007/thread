package com.thread.c03.s07;

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
public class J04_SynNotifyMethodThread extends Thread{
	private Object lock;

	public J04_SynNotifyMethodThread(Object lock) {
		super();
		this.lock = lock;
	}

	@Override
	public void run() {
		J01_Service service=new J01_Service();
		service.synNotifyMethod(lock);
	}
	
	public static void main(String[] args) {
		Object lock =new Object();
		J02_ThreadA a=new J02_ThreadA(lock);
		a.start();
		J03_NotifyThread notifyA=new J03_NotifyThread(lock);
		notifyA.start();
		J04_SynNotifyMethodThread notifyB=new J04_SynNotifyMethodThread(lock);
		notifyB.start();
		
	}
}
