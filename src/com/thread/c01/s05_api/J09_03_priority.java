package com.thread.c01.s05_api;

import java.util.Random;

/**
 * <p>
 * Function:优先级的效果2
 * <p>
 * Description:priority 线程优先级，1-10个等级，超出JDK抛IllegalArgumentException
 * 预置 MIN_PRIORITY=1,NORM_PRIORITY=5,MAX_PRIORITY=10
 * 线程优先级具有继承性，比如A线程启动B线程，则B线程的优先级与A是一样的
 * 优先级还有一个随机性，并不是绝对的优先级高的先执行完后才执行优先级低的，当两个优先级相近时更能提现（不确定性，随机性）
 * @since 1.0
 * @version 1.0
 * @author 1132381386@qq.com 钟秋森 2018年3月7日
 */
public class J09_03_priority extends Thread{

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
		System.out.println("######thread 2 use time="+(endTime-beginTime));
		
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			J09_02_priority t1=new J09_02_priority();
			t1.setPriority(5);
			t1.start();
			J09_03_priority t2=new J09_03_priority();
			t2.setPriority(6);
			t2.start();
		}
	}
}
