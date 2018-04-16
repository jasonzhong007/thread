package com.thread.c03.s18;

/**
 * <p>
 * Function: ThreadLocal 解决每个线程绑定自己的值，
 * 可以看成是全局存放数据的盒子，
 * 盒子中可以存储每个线程的私有数据
 * <p>
 * Description:
 * @since 1.0
 * @version 1.0
 * @author 1132381386@qq.com 钟秋森 2018年3月19日
 */
public class J01_Run{

	public static ThreadLocal<String> t1=new ThreadLocal<>();
	
	public static void main(String[] args) {
		if(t1.get()==null){
			System.out.println("从未放过值");
			t1.set("我的值");
		}
		System.out.println(t1.get());
		System.out.println(t1.get());
	}

}
