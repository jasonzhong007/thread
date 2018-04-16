package com.thread.c03.s14;

import java.io.IOException;
import java.io.PipedInputStream;

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
public class J02_ReadData {

	public void readMethod(PipedInputStream input) {
		try {
			System.out.println("read :");
			byte[] byteArray = new byte[20];
			int readLength = input.read(byteArray);
			while (readLength != -1) {
				String newData = new String(byteArray, 0, readLength);
				System.out.print(newData);
				readLength = input.read(byteArray);
			}
			System.out.println();
			input.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
