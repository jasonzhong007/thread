package com.thread.c02.s16;

/**
 * <p>
 * Function synchronized 可以使多线程访问同一个资源具有同步性，而且它还具有将线程工作内存中
 * 的私有变量和公共内存中的变量同步的功能
 * *********学习多线程并发，要着重 “外练互斥，内修可见”，这是掌握多线程，学习多线程并发的重要技术点*********
 * <p>
 * @since 1.0
 * @version 1.0
 * @author 1132381386@qq.com 钟秋森 2018年3月8日
 */
public class J01_SynchronizedUpdateNewValue{

	private boolean isContinueRun=true;
	
	String anyString=new String();
	public void runMethod(){
		while(isContinueRun == true){
			//如果不加synchronized则会死循环
			synchronized (anyString){
				
			}
		}
		System.out.println("停下来了!");
	}

	public void stopMethod(){
		isContinueRun=false;
	}
}
