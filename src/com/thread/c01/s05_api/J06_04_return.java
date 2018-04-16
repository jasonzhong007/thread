package com.thread.c01.s05_api;

/**
 * <p>
 * Function:
 * <p>
 * Description:return 也可以实现线程的停止
 * @since 1.0
 * @version 1.0
 * @author 1132381386@qq.com 钟秋森 2018年3月7日
 */
public class J06_04_return extends Thread{

	
	@Override
	public void run() {
		while(true){
			if(this.isInterrupted()){
				System.out.println(" 停止了！");
				return;
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		J06_04_return thread=new J06_04_return();
		thread.start();
		Thread.sleep(2000);
		thread.interrupt();
	}
	
}
