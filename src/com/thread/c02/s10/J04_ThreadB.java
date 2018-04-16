package com.thread.c02.s10;

/**
 * <p>
 * Function:synchronized 出现异常，锁自动释放,同步不具有继承性
 * <p>
 * Description:synchronized 方法/块的内部调用本类的其他
 * synchronize 方法/块时，是永远可以得到锁的。
 * 可重入锁也支持在父子类继承的环境中
 * 
 * @since 1.0
 * @version 1.0
 * @author 1132381386@qq.com 钟秋森 2018年3月8日
 */
public class J04_ThreadB extends Thread{
	
	private J02_Sub sub;
	
	
	public J04_ThreadB(J02_Sub sub) {
		super();
		this.sub = sub;
	}


	public void run() {
		sub.serviceMethod();
	}
	
	public static void main(String[] args) {
		J02_Sub a=new J02_Sub();
		J03_ThreadA threada=new J03_ThreadA(a);
		threada.setName("A");
		threada.start();
		J04_ThreadB threadb=new J04_ThreadB(a);
		threadb.setName("B");
		threadb.start();
	}

}
