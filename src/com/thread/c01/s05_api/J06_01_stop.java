package com.thread.c01.s05_api;

/**
 * <p>
 * Function:
 * <p>
 * Description:stop 暴力停止
 * 
 * @since 1.0
 * @version 1.0
 * @author 1132381386@qq.com 钟秋森 2018年3月7日
 */
public class J06_01_stop extends Thread {
	private int i=0;

	@Override
	public void run() {
		super.run();
		
		try {
			while(true){
				i++;
				System.out.println("i="+i);
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		try {
			J06_01_stop i=new J06_01_stop();
			i.start();
			Thread.sleep(8000);
			i.stop();
			System.out.println("end!");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
