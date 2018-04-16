package com.thread.c01.s01_thread;
/**
 * <p>Function: 
 * <p>Description:       		
 * @since 1.0   
 * @version 1.0  
 * @author 1132381386@qq.com 钟秋森 2018年3月7日 
*/
public class J03_RunOrStart extends Thread{

	private int i;
	public J03_RunOrStart(int i){
		super();
		this.i=i;
	}
	
	@Override
	public void run() {
		System.out.println(i);
	}
	
	public static void main(String[] args) {
		J03_RunOrStart t11 =new J03_RunOrStart(1);
		J03_RunOrStart t12 =new J03_RunOrStart(2);
		J03_RunOrStart t13 =new J03_RunOrStart(3);
		J03_RunOrStart t14 =new J03_RunOrStart(4);
		J03_RunOrStart t15 =new J03_RunOrStart(5);
		J03_RunOrStart t16 =new J03_RunOrStart(6);
		J03_RunOrStart t17 =new J03_RunOrStart(7);
		J03_RunOrStart t18 =new J03_RunOrStart(8);
		J03_RunOrStart t19 =new J03_RunOrStart(9);
		J03_RunOrStart t110 =new J03_RunOrStart(10);
		J03_RunOrStart t111 =new J03_RunOrStart(11);
		J03_RunOrStart t112 =new J03_RunOrStart(12);
		J03_RunOrStart t113 =new J03_RunOrStart(13);
		t11.start();
		t12.start();
		t13.start();
		t14.start();
		t15.start();
		t16.start();
		t17.start();
		t18.start();
		t19.start();
		t110.start();
		t111.start();
		t112.start();
		t113.start();
	}
}
