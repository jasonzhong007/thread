package com.thread.c03.s13;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * Function: 生产者/消费者模式实现 一生产与一消费：操作栈
 * <p>
 * Description:
 * 
 * @since 1.0
 * @version 1.0
 * @author 1132381386@qq.com 钟秋森 2018年3月19日
 */
public class J01_MyStack {
	private List<String> list = new ArrayList<>();

	synchronized public void push() {
		try {
			if (list.size() == 1) {
				this.wait();
			}
			list.add("anyString=" + Math.random());
			this.notify();
			System.out.println("push=" + list.size());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	synchronized public String pop() {
		String returnValue = "";
		try {
			if (list.size() == 0) {
				System.out.println("pop操作中的："+Thread.currentThread().getName()+" 线程呈wait状态");
				this.wait();
			}
			returnValue=""+list.get(0);
			list.remove(0);
			this.notify();
			System.out.println("pop="+list.size());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnValue;
	}

}
