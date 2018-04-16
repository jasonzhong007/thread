package com.thread.c01.s05_api;

import java.util.Random;

/**
 * <p>
 * Function:优先级的效果1
 * <p>
 * Description:priority 线程优先级，1-10个等级，超出JDK抛IllegalArgumentException
 * 预置 MIN_PRIORITY=1,NORM_PRIORITY=5,MAX_PRIORITY=10
 * 线程优先级具有继承性，比如A线程启动B线程，则B线程的优先级与A是一样的
 * @since 1.0
 * @version 1.0
 * @author 1132381386@qq.com 钟秋森 2018年3月7日
 */
public class J09_02_priority extends Thread{

	@Override
	public void run() {
		long beginTime=System.currentTimeMillis();
		long addResult=0;
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 50000; j++) {
				Random random =new Random();
				random.nextInt();
				addResult=addResult+j;
			}
		}
		long endTime=System.currentTimeMillis();
		System.out.println("*****thread 1 use time="+(endTime-beginTime));
		
	}
}
