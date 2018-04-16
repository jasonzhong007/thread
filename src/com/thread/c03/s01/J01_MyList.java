package com.thread.c03.s01;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Function: 线程间的通信
 * <p>Description:       		
 * @since 1.0   
 * @version 1.0  
 * @author 1132381386@qq.com 钟秋森 2018年3月19日 
*/
public class J01_MyList {
	private List list=new ArrayList<>();
	
	public void add(){
		list.add("钟秋森");
	}
	
	public int size(){
		return list.size();
	}
}
