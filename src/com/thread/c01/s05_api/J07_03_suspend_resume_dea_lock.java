package com.thread.c01.s05_api;

/**
 * <p>
 * Function:
 * <p>
 * Description:suspend 暂停，resume 恢复,缺点--独占,坑
 * suspend方法是过期作废的方法，还是有必要研究。
 * @since 1.0
 * @version 1.0
 * @author 1132381386@qq.com 钟秋森 2018年3月7日
 */
public class J07_03_suspend_resume_dea_lock extends Thread{

	private long i=0;
	
	@Override
	public void run() {
		while(true){
			i++;
			//如果将System.out.println(i);去掉，控制台只会打出main end!
			//如果加上，这控制台不打印出main end!
			//原因：当程序运行到println()方法内部停止时，同步锁未被释放，println源码如下：
			//pring(x);newLine();
			System.out.println(i);
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		J07_03_suspend_resume_dea_lock s=new J07_03_suspend_resume_dea_lock();
		s.start();
		Thread.sleep(1000);
		s.suspend();
		System.out.println("main end!");
	}
}
