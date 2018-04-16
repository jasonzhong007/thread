package com.thread.c03.s16;

/**
 * <p>
 * Function: join 等待线程对象销毁
 * <p>
 * Description:
 * 方法join具有使线程排队运行的作用，有些类似同步的运行效果。
 * join与synchronized的区别是：join在内部使用wait()方法进行等待，
 * 而synchronized关键字使用的是“对象监控”原理做为同步
 * @since 1.0
 * @version 1.0
 * @author 1132381386@qq.com 钟秋森 2018年3月19日
 */
public class J01_MyThread extends Thread{

	@Override
	public void run() {
		
		try {
			int secondValue=(int) (Math.random()*10000);
			System.out.println(secondValue);
			Thread.sleep(secondValue);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		J01_MyThread threadTest=new J01_MyThread();
		threadTest.start();
		threadTest.join();
		System.out.println("我想当threadTest对象执行完毕我再执行，我做到了");
	}
}
