package com.thread.c02.s06;

/**
 * <p>
 * Function:脏读，出现情况是在读取实例变量是，此值已经被其他线程更改过了
 * <p>
 * Description:
 * 
 * @since 1.0
 * @version 1.0
 * @author 1132381386@qq.com 钟秋森 2018年3月8日
 */
public class J02_ThreadA extends Thread{
	private J01_PublicVar numRef;

	public J02_ThreadA(J01_PublicVar numRef) {
		super();
		this.numRef = numRef;
	}
	@Override
	public void run() {
		super.run();
		numRef.setValue("B", "BB");
	}
	
	/**
	 * 解决脏读需加上synchronized
	 * @param args
	 * @author 1132381386@qq.com 钟秋森 2018年3月8日
	 */
	public static void main(String[] args) {


		try {
			J01_PublicVar pub=new J01_PublicVar();
			J02_ThreadA thread=new J02_ThreadA(pub);
			thread.start();
			Thread.sleep(200);
			pub.getValue();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
