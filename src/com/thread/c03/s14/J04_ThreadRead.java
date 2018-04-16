package com.thread.c03.s14;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * <p>
 * Function: 通过管道进行线程间通信：字节流
 * <p>
 * Description:
 * 
 * @since 1.0
 * @version 1.0
 * @author 1132381386@qq.com 钟秋森 2018年3月19日
 */
public class J04_ThreadRead extends Thread{
	private J02_ReadData readData;
	private PipedInputStream input;
	

	public J04_ThreadRead(J02_ReadData readData, PipedInputStream input) {
		super();
		this.readData = readData;
		this.input = input;
	}

	@Override
	public void run() {
		readData.readMethod(input);
	}

	public static void main(String[] args) {
		try {
			J01_WriteData writeData=new J01_WriteData();
			J02_ReadData readData=new J02_ReadData();
			PipedOutputStream out=new PipedOutputStream();
			PipedInputStream input=new PipedInputStream();
			
			//使用connect()的作用使两个Stream之间产生通信连接，这样才可以将数据进行输出和输入
//			input.connect(out);
			out.connect(input);
			
			J04_ThreadRead threadRead=new J04_ThreadRead(readData, input);
			threadRead.start();
			
			Thread.sleep(2000);
			
			J03_ThreadWrite threadWrite=new J03_ThreadWrite(writeData, out);
			threadWrite.start();
			
			
		} catch (InterruptedException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
