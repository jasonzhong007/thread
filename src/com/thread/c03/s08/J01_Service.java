package com.thread.c03.s08;

/**
 * <p>
 * Function: wait 状态时，调用线程对象的interrupt会出现InterruptedException异常
 * <p>
 * Description:
 * 
 * @since 1.0
 * @version 1.0
 * @author 1132381386@qq.com 钟秋森 2018年3月19日
 */
public class J01_Service{
	public void testMethod(Object lock){
		try {
			synchronized (lock){
				System.out.println("begin wait ThreadName="+Thread.currentThread().getName());
				//将wait换成sleep
//				Thread.sleep(4000);
				lock.wait();
				System.out.println("end  wait ThreadName="+Thread.currentThread().getName());
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(" 出现异常了，因为呈wait状态的线程被interrupt了");
		}
	}
	
}
