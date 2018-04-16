package com.thread.c01.s01_thread;

public class J01_MyThread extends Thread{
	
	@Override
	public void run() {
		super.run();
		System.out.println("MyThread");
	}

	public static void main(String[] args) {
		J01_MyThread myThread=new J01_MyThread();
		myThread.start();
		System.out.println("运行结束");
	}
}
