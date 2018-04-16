package com.thread.c01.s04_safe;

/**
 * <p>
 * Function:
 * <p>
 * Description:
 * 
 * @since 1.0
 * @version 1.0
 * @author 1132381386@qq.com 钟秋森 2018年3月7日
 */
public class J01_LoginServlet{
	private static String usernameRef;
	private static String passwordRef;

	synchronized public static void doPost(String username, String password) {

		try {
			usernameRef = username;
			if (username.equals("a")) {
				Thread.sleep(5000);
			}
			passwordRef = password;
			System.out.println("username=" + usernameRef + " password=" + password);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		J02_ALogin a=new J02_ALogin();
		a.start(); 
		J03_BLogin b=new J03_BLogin();
		b.start();
	}
	
}
