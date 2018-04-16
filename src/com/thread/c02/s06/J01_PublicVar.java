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
public class J01_PublicVar {
	public String username = "A";
	public String password = "AA";

	synchronized public void setValue(String username, String password) {
		try {
			this.username = username;
			Thread.sleep(5000);
			this.password = password;
			System.out.println("setValue method thread name=" + Thread.currentThread().getName() + " username="
					+ username + " password=" + password);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//解决脏读需加上synchronized
	public void getValue(){
		System.out.println("setValue method thread name=" + Thread.currentThread().getName() + " username="
				+ username + " password=" + password);
	}
}
