package com.thread.c03.s02;

/**
 * <p>Function: 有 “对象监视器”，同步加锁
 * <p>Description:       		
 * @since 1.0   
 * @version 1.0  
 * @author 1132381386@qq.com 钟秋森 2018年3月19日 
*/
public class J02_HaveObject {
	public static void main(String[] args) {
		try {
			String lock=new String("");
			System.out.println("syn 上面");
			synchronized (lock){
				System.out.println("syn 第一行");
				lock.wait();
				System.out.println("wait 下的代码");
			}
			System.out.println("syn 下面的代码");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
