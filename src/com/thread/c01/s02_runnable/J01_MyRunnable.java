package com.thread.c01.s02_runnable;

public class J01_MyRunnable implements Runnable{
	
	@Override
	public void run() {
		System.out.println("S01_MyRunnable");
	}

	public static void main(String[] args) {
		Runnable runnable=new J01_MyRunnable();
		Thread thread=new Thread(runnable);
		thread.start();
		System.out.println("运行结束");
	}
}
