package com.thread.c02.s08;

/**
 * <p>
 * Function:synchronized 锁重入
 * <p>
 * Description:synchronized 方法/块的内部调用本类的其他
 * synchronize 方法/块时，是永远可以得到锁的。
 * 可重入锁也支持在父子类继承的环境中
 * 
 * @since 1.0
 * @version 1.0
 * @author 1132381386@qq.com 钟秋森 2018年3月8日
 */
public class J02_Sub extends J01_Main{
	
	@Override
	public synchronized void operateIMainMethod() {
		try {
			while(i>0){
				i--;
				System.out.println("sub print i="+i);
				Thread.sleep(100);
				this.operateIMainMethod();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
