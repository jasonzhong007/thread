package com.thread.c02.s08;

/**
 * <p>
 * Function:synchronized 锁重入
 * <p>
 * Description:synchronized 方法/块的内部调用本类的其他
 * synchronize 方法/块时，是永远可以得到锁的。
 * 可重入锁也支持在父子类继承的环境中，如果不可重入锁，会造成死锁。
 * 
 * @since 1.0
 * @version 1.0
 * @author 1132381386@qq.com 钟秋森 2018年3月8日
 */
public class J03_Thread extends Thread{
	
	@Override
	public void run() {
		J02_Sub s=new J02_Sub();
		s.operateIMainMethod();
	}
	
	public static void main(String[] args) {

		J03_Thread t=new J03_Thread();
		t.start();
		
	}

}
