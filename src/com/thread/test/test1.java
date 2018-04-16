package com.thread.test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

/**
 * <p>
 * Function:
 * <p>
 * Description:
 * 
 * @since 1.0
 * @version 1.0
 * @author 1132381386@qq.com 钟秋森 2018年3月9日
 */
public class test1 {
	public static void main(String[] args) {
		File file = new File("D:\\a.txt");

		try {
			LineIterator lineIterator = FileUtils.lineIterator(file, "utf-8");
			int i = 1;
			while (lineIterator.hasNext()) {
				String line = lineIterator.nextLine();
				System.out.println("*********读取到第" + (i + 1) + "行，原文如下：***********");
				System.out.println(line);
				line=line.replaceAll("~\\|~~\\|~", "~\\|~ ~\\|~");
				System.out.println("*********读取到第" + (i + 1) + "行，加上空格后的原文如下：***********");
				System.out.println(line);
				line=line.replaceAll("~\\|~~\\|~", "~\\|~ ~\\|~");
				System.out.println("*********读取到第" + (i + 1) + "行，加上空格后的原文如下：***********");
				System.out.println(line);
				System.out.println("*********截取后的内容如下：***********");
				String[] custArray = line.split("~\\|~");
				for (int j = 0; j < custArray.length; j++) {
					System.out.println(custArray[j]);
				}
				// 行数据转换成数组

				Thread.sleep(10);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
