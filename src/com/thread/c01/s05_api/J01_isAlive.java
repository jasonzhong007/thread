package com.thread.c01.s05_api;

/**
 * <p>
 * Function:
 * <p>
 * Description:
 * 
 * @since 1.0
 * @version 1.0
 * @author 1132381386@qq.com 钟秋森 2018年3月7日
 */
public class J01_isAlive extends Thread{
	@Override
	public void run() {
		System.out.println("run="+this.isAlive());
	}
	
	public static void main(String[] args) {
		J01_isAlive a=new J01_isAlive();
		System.out.println("begin ==" + a.isAlive());
		a.start(); 
		System.out.println("end ==" + a.isAlive());
		
		try {
			/**
			 * 
			 * 本段代码最后end和上面代码相比结果变成了false
			 * 是因为start后再1秒执行完毕所以isAlive值是不确定的
			 * 
			 */
			Thread.sleep(1000);
			System.out.println("***************************");
			J01_isAlive b=new J01_isAlive();
			System.out.println("begin ==" + b.isAlive());
			b.start(); 
			Thread.sleep(1000);
			System.out.println("end ==" + b.isAlive());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
