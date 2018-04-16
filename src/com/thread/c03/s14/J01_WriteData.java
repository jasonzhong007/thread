package com.thread.c03.s14;

import java.io.IOException;
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
public class J01_WriteData {

	public void writeMethod(PipedOutputStream out) {
		try {
			System.out.println("write :");
			for (int i = 0; i < 300; i++) {
				String outData=""+(i+1);
				out.write(outData.getBytes());
				System.out.print(outData);
			}
			System.out.println();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
