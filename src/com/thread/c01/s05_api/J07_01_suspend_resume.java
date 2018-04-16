package com.thread.c01.s05_api;

/**
 * <p>
 * Function:
 * <p>
 * Description:suspend 暂停，resume 恢复
 * @since 1.0
 * @version 1.0
 * @author 1132381386@qq.com 钟秋森 2018年3月7日
 */
public class J07_01_suspend_resume extends Thread{

	private long i=0;
	
	@Override
	public void run() {
		while(true){
			i++;
		}
	}
	
	protected void setI(long i) {
		this.i = i;
	}
	
	public long getI(){
		return i;
	}
	
	public static void main(String[] args) throws InterruptedException {
		J07_01_suspend_resume thread=new J07_01_suspend_resume();
		thread.start();
		Thread.sleep(5000);
		//A段
		thread.suspend();
		System.out.println("A="+System.currentTimeMillis()+" i="+thread.getI());
		Thread.sleep(5000);
		System.out.println("A="+System.currentTimeMillis()+" i="+thread.getI());
		
		//B段
		thread.resume();
		Thread.sleep(5000);
		
		//C段
		thread.suspend();
		System.out.println("B="+System.currentTimeMillis()+" i="+thread.getI());
		Thread.sleep(5000);
		System.out.println("B="+System.currentTimeMillis()+" i="+thread.getI());
	}
}
