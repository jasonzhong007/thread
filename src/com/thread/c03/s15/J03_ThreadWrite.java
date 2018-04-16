package com.thread.c03.s15;

import java.io.PipedWriter;

/**
 * <p>
 * Function: 通过管道进行线程间通信：字符流
 * <p>
 * Description:
 * 
 * @since 1.0
 * @version 1.0
 * @author 1132381386@qq.com 钟秋森 2018年3月19日
 */
public class J03_ThreadWrite extends Thread {
	private J01_WriteData writeData;
	private PipedWriter out;

	public J03_ThreadWrite(J01_WriteData writeData, PipedWriter out) {
		super();
		this.writeData = writeData;
		this.out = out;
	}

	@Override
	public void run() {
		writeData.writeMethod(out);
	}

}
