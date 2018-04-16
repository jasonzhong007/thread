package com.thread.c03.s03;

/**
 * <p>Function: 没有 “对象监视器”，也就是没有同步加锁
 * <p>Description:       		
 * @since 1.0   
 * @version 1.0  
 * @author 1132381386@qq.com 钟秋森 2018年3月19日 
*/
public class J01_NotObject {
	public static void main(String[] args) {
		String newString=new String("");
		try {
			newString.wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
