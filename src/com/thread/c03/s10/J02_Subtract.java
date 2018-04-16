package com.thread.c03.s10;

/**
 * <p>
 * Function: 如果wait等待的条件发生了变化，也容易造成程序逻辑的混乱
 * <p>
 * Description:
 * 
 * @since 1.0
 * @version 1.0
 * @author 1132381386@qq.com 钟秋森 2018年3月19日
 */
public class J02_Subtract{
	private String lock;

	public J02_Subtract(String lock) {
		super();
		this.lock = lock;
	}

	public void subtract() {
		try {
			synchronized (lock){
//				if(J03_ValueObject.list.size()==0){
//					System.out.println("wait begin ThreadName="+Thread.currentThread().getName());
//					lock.wait();
//					System.out.println("wait end ThreadName="+Thread.currentThread().getName());
//				}
//				J03_ValueObject.list.remove(0);
//				System.out.println("list size="+J03_ValueObject.list.size());
				while(J03_ValueObject.list.size()==0){
					System.out.println("wait begin ThreadName="+Thread.currentThread().getName());
					lock.wait();
					System.out.println("wait end ThreadName="+Thread.currentThread().getName());
				}
				J03_ValueObject.list.remove(0);
				System.out.println("list size="+J03_ValueObject.list.size());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
