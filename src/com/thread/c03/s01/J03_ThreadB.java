package com.thread.c03.s01;

/**
 * <p>Function: 线程间的通信
 * <p>Description:       		
 * @since 1.0   
 * @version 1.0  
 * @author 1132381386@qq.com 钟秋森 2018年3月19日 
*/
public class J03_ThreadB extends Thread{
	private J01_MyList list;
	
	public J03_ThreadB(J01_MyList list) {
		this.list = list;
	}
	
	@Override
	public void run() {
		try {
			while(true){
//				System.out.println(Thread.currentThread().getName()+"list.size()="+list.size());
				if(list.size()==5){
					System.out.println("==5了，线程b要退出了");
					throw new InterruptedException();
				}
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		J01_MyList service=new J01_MyList();
		J02_ThreadA a=new J02_ThreadA(service);
		a.setName("A");
		a.start();
		J03_ThreadB b=new J03_ThreadB(service);
		b.setName("B");
		b.start();
		
	}
}
