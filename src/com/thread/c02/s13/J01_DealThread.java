package com.thread.c02.s13;

/**
 * <p>
 * Function多线程的死锁
 * <p>
 * 与嵌套不嵌套synchronized代码结构无关，只要互相等待对方释放锁就有可能出现死锁。
 * @since 1.0
 * @version 1.0
 * @author 1132381386@qq.com 钟秋森 2018年3月8日
 */
public class J01_DealThread implements Runnable {

	public String username;
	public Object lock1 = new Object();
	public Object lock2 = new Object();

	public void setFlag(String username) {
		this.username = username;
	}

	@Override
	public void run() {
		if(username.equals("a")){
			synchronized (lock1){
				try {
					System.out.println("username="+username);
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				synchronized (lock2){
					System.out.println("按lock1->lock2代码顺序执行了");
				}
			}
		}
		if(username.equals("b")){
			synchronized (lock2){
				try {
					System.out.println("username="+username);
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				synchronized (lock1){
					System.out.println("按lock2->lock1代码顺序执行了");
				}
			}
		}
	}
	
	public static void main(String[] args) {
		try {
			J01_DealThread t1=new J01_DealThread();
			t1.setFlag("a");
			Thread thread1=new Thread(t1);
			thread1.start();
			Thread.sleep(100);
			t1.setFlag("b");
			Thread thread2=new Thread(t1);
			thread2.start();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
