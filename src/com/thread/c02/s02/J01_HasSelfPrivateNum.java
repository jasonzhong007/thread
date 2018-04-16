package com.thread.c02.s02;

/**
 * <p>
 * Function:非线程安全 实例
 * <p>
 * Description: synchronized 同步方法，方法内的变量为线程安全
 * 
 * @since 1.0
 * @version 1.0
 * @author 1132381386@qq.com 钟秋森 2018年3月8日
 */
public class J01_HasSelfPrivateNum {
	/**
	 * 将num设置为private，当多个线程共同访问1个对象中的实例变量，则有可能出现“非线程安全”
	 */
	private int num = 0;
	synchronized public void addI(String username) throws InterruptedException {
		if (username.equals("a")) {
			num = 100;
			System.out.println("a set over!");
			Thread.sleep(2000);
		} else {
			num = 200;
			System.out.println("b set over!");
		}
		System.out.println(username + " num=" + num);
	}

}
