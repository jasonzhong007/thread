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
public class J04_getId{
	
	public static void main(String[] args) {
		Thread runThread=Thread.currentThread();
		System.out.println(runThread.getId()+"   "+runThread.getName());
	}
}
