package com.thread.c03.s05;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * Function: wait notify
 * <p>
 * Description:
 * 
 * @since 1.0
 * @version 1.0
 * @author 1132381386@qq.com 钟秋森 2018年3月19日
 */
public class J03_MyList{
private static List list=new ArrayList<>();
	
	public static void add(){
		list.add("anyString");
	}
	
	public static int size(){
		return list.size();
	}
}
