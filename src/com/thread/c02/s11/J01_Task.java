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
public class J01_Task {
	private String getData1;
	private String getData2;
	public synchronized void doLongTimeTask(){
		try {
			System.out.println("begin task");
			Thread.sleep(3000);
			getData1="长时间处理任务后从远程返回的值1 threadName="+Thread.currentThread().getName();
			getData2="长时间处理任务后从远程返回的值2 threadName="+Thread.currentThread().getName();
			System.out.println(getData1);
			System.out.println(getData2);
			Thread.sleep(5000);
			System.out.println("end task");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
