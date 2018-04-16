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
public class J02_ALogin extends Thread{
	
	@Override
	public void run() {
		J01_LoginServlet.doPost("a", "aa");
	}
}
