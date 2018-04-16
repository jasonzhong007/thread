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
public class J02_Sub extends J01_Main{
	
	//如果不加上synchronized则不同步，说明不具有继承性，没有继承Main的同步
	@Override
	public synchronized void serviceMethod() {
		try {
			System.out.println("int main 下一步 sleep begin threadName="+Thread.currentThread().getName()+" time="+System.currentTimeMillis());
			Thread.sleep(5000);
			System.out.println("int main 下一步 sleep end threadName="+Thread.currentThread().getName()+" time="+System.currentTimeMillis());
			super.serviceMethod();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
