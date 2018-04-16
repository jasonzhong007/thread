package com.thread.c01.s05_api;

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
public class J10_01_count_priority extends Thread{
	private int count=0;
	

	@Override
	public void run() {
		while(true){
			count++;
		}
		
	}


	public int getCount() {
		return count;
	}
	
}
