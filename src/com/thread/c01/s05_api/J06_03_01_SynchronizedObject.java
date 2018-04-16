package com.thread.c01.s05_api;

/**
 * <p>
 * Function:
 * <p>
 * Description:stop 暴力停止
 * stop已经作废，如果强制让线程停止则有可能使一些清理性的工作得不到完成。
 * 另外一个情况就是对锁定的对象进行了“解锁”，导致数据得不到同步的处理，出现数据的不一致的问题。
 * 
 * @since 1.0
 * @version 1.0
 * @author 1132381386@qq.com 钟秋森 2018年3月7日
 */
public class J06_03_01_SynchronizedObject{
	private String username="a";
	private String userpass="aa";
	
	protected String getUsername() {
		return username;
	}
	protected void setUsername(String username) {
		this.username = username;
	}
	protected String getUserpass() {
		return userpass;
	}
	protected void setUserpass(String userpass) {
		this.userpass = userpass;
	}
	
	synchronized public void printString(String username,String userpass){
		try {
			this.username=username;
			Thread.sleep(100000);
			this.userpass=userpass;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
