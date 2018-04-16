package com.thread.c01.s05_api;

/**
 * <p>
 * Function:
 * <p>
 * Description:yield()方法的作用是放弃当前的CPU资源，将它让给其他的任务去占用CPU执行时间，
 * 但放弃的时间不确定，有可能刚刚放弃，马上又获得CPU时间片
 * @since 1.0
 * @version 1.0
 * @author 1132381386@qq.com 钟秋森 2018年3月7日
 */
public class J08_yield extends Thread{

	@Override
	public void run() {
		long beginTime=System.currentTimeMillis();
		int count=0;
		for (int i = 0; i < 50000000; i++) {
			Thread.yield();
			count=count+(i+1);
		}
		long endTime =System.currentTimeMillis();
		System.out.println("用时："+(endTime-beginTime)+"毫秒");
		System.out.println("S06_06_yield run priority="+this.getPriority());
	}
	
	public static void main(String[] args) throws InterruptedException {
		J08_yield s=new J08_yield();
		s.start();
	}
}
