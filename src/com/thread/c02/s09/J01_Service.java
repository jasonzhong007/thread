package com.thread.c02.s09;

/**
 * <p>
 * Function:synchronized 出现异常，锁自动释放
 * <p>
 * Description:synchronized 方法/块的内部调用本类的其他
 * synchronize 方法/块时，是永远可以得到锁的。
 * 可重入锁也支持在父子类继承的环境中
 * 
 * @since 1.0
 * @version 1.0
 * @author 1132381386@qq.com 钟秋森 2018年3月8日
 */
public class J01_Service {
	synchronized public void testMethod(){
		if(Thread.currentThread().getName().equals("a")){
			System.out.println("ThreadName="+Thread.currentThread().getName()+" run begin Time="+System.currentTimeMillis());
			int i=1;
			while(i==1){
				if((""+Math.random()).substring(0, 8).equals("0.123456")){
					System.out.println("ThreadName="+Thread.currentThread().getName()+" run exceptionTime="+System.currentTimeMillis());
					Integer.parseInt("a");
				}
			}
		}else{
			System.out.println("Thread B run Time="+System.currentTimeMillis());
		}
	}
}
