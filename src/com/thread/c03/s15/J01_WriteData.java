package com.thread.c03.s15;

import java.io.IOException;
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
public class J01_WriteData {

	public void writeMethod(PipedWriter out) {
		try {
			System.out.println("write :");
			for (int i = 0; i < 300; i++) {
				String outData=""+(i+1);
				out.write(outData);
				System.out.print(outData);
			}
			System.out.println();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
