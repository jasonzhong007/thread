package com.thread.c03.s19;

import java.util.Date;

/**
 * <p>
 * Function: ThreadLocal 解决每个线程绑定自己的值，
 * 可以看成是全局存放数据的盒子，
 * 盒子中可以存储每个线程的私有数据
 * 验证ThreadLocal隔离性
 * <p>
 * Description:
 * @since 1.0
 * @version 1.0
 * @author 1132381386@qq.com 钟秋森 2018年3月19日
 */
public class J01_ThreadLocalExt extends ThreadLocal{

	@Override
	protected Object initialValue() {
		return new Date().getTime();
	}
	

}
