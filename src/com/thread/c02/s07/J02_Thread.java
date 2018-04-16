package com.thread.c02.s07;

/**
 * <p>
 * Function:synchronized 锁重入
 * <p>
 * Description:synchronized 方法/块的内部调用本类的其他
 * synchronize 方法/块时，是永远可以得到锁的。
 * 
 * @since 1.0
 * @version 1.0
 * @author 1132381386@qq.com 钟秋森 2018年3月8日
 */
public class J02_Thread extends Thread{
	
	@Override
	public void run() {
		J01_Service s=new J01_Service();
		s.service1();
	}
	
	public static void main(String[] args) {

		J02_Thread t=new J02_Thread();
		t.start();
		
	}

}
