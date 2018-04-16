package com.thread.c02.s11;

/**
 * <p>
 * Function:synchronized 出现异常，锁自动释放,同步不具有继承性
 * <p>
 * Description:synchronized 方法/块的内部调用本类的其他
 * synchronize 方法/块时，是永远可以得到锁的。
 * 可重入锁也支持在父子类继承的环境中
 * 弊端：用来声明方法的时候只能等待上一个执行完才能继续执行，所以可以考虑声明同步块
 * 
 * @since 1.0
 * @version 1.0
 * @author 1132381386@qq.com 钟秋森 2018年3月8日
 */
public class J03_ThreadA extends Thread{
	
	private J01_Task task;
	
	
	public J03_ThreadA(J01_Task task) {
		super();
		this.task = task;
	}

	@Override
	public void run() {
		super.run();
		J02_CommonUtils.beginTime1=System.currentTimeMillis();
		task.doLongTimeTask();
		J02_CommonUtils.endTime1=System.currentTimeMillis();
	}
	
}
