package com.thread.c02.s15;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>
 * Function 使用 AtomicInteger 原子类进行synchronized同步的实现
 * 但是原子类在具有有逻辑性的情况下输出结果也具有随机性
 * <p>
 * @since 1.0
 * @version 1.0
 * @author 1132381386@qq.com 钟秋森 2018年3月8日
 */
public class J01_AtomicIntergerNoSafe{

	public AtomicInteger count =new AtomicInteger(0);


	//加上synchronized才确保结果和顺序正确
	synchronized public void addNum(){
		System.out.println(Thread.currentThread().getName()+"加了100之后的值是："+count.addAndGet(100));
		count.addAndGet(1);
	}
}
