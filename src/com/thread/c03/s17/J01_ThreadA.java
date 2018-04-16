package com.thread.c03.s17;

/**
 * <p>
 * Function: join 等待线程对象销毁
 * <p>
 * Description:
 * 方法join具有使线程排队运行的作用，有些类似同步的运行效果。
 * join与synchronized的区别是：join在内部使用wait()方法进行等待，
 * 而synchronized关键字使用的是“对象监控”原理做为同步
 * 在join过程中，如果当前线程对象被中断，则当前线程出现异常
 * @since 1.0
 * @version 1.0
 * @author 1132381386@qq.com 钟秋森 2018年3月19日
 */
public class J01_ThreadA extends Thread{

	@Override
	public void run() {
		
		for (int i = 0; i < Integer.MAX_VALUE; i++) {
			String newString=new String();
			Math.random();
		}
	}

}
