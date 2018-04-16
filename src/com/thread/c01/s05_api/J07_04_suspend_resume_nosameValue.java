package com.thread.c01.s05_api;

/**
 * <p>
 * Function:
 * <p>
 * Description:suspend 暂停，resume 恢复,缺点--独占,不同步
 * suspend方法是过期作废的方法，还是有必要研究。
 * @since 1.0
 * @version 1.0
 * @author 1132381386@qq.com 钟秋森 2018年3月7日
 */
public class J07_04_suspend_resume_nosameValue{

	private String username="1";
	private String pass="11";
	
	public void setValue(String u,String p){
		this.username=u;
		if(Thread.currentThread().getName().equals("a")){
			System.out.println("停止线程a");
			Thread.currentThread().suspend();
		}
		this.pass=p;
	}
	
	public void printUsernamePass(){
		System.out.println(username+" " +pass);
	}
	
	public static void main(String[] args) throws InterruptedException {
		J07_04_suspend_resume_nosameValue s=new J07_04_suspend_resume_nosameValue();
		Thread thread1=new Thread(){
			@Override
			public void run() {
				s.setValue("a", "aa");
			}
		};
		thread1.setName("a");
		thread1.start();
		Thread.sleep(500);
		Thread thread2=new Thread(){
			@Override
			public void run() {
				s.printUsernamePass();
			}
		};
		thread2.start();
	}
}
