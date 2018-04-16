package com.thread.c03.s20;

import java.util.Date;

/**
 * <p>
 * Function: InheritableThreadLocal可以在子线程中取得父线程继承下来的值
 * <p>
 * Description:
 * @since 1.0
 * @version 1.0
 * @author 1132381386@qq.com 钟秋森 2018年3月19日
 */
public class J01_InheritableThreadLocalExt extends InheritableThreadLocal<Object>{

	@Override
	protected Object initialValue() {
		return new Date().getTime();
	}
	

}
