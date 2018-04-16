package com.thread.c02.s12;

/**
 * <p>
 * Function:synchronized 出现异常，锁自动释放,同步不具有继承性
 * <p>
 * Description:synchronized 方法/块的内部调用本类的其他
 * synchronize 方法/块时，是永远可以得到锁的。
 * 可重入锁也支持在父子类继承的环境中
 * 弊端：用来声明方法的时候只能等待上一个执行完才能继续执行，所以可以考虑声明同步块
 * synchronized object
 * 
 * @since 1.0
 * @version 1.0
 * @author 1132381386@qq.com 钟秋森 2018年3月8日
 */
public class J03_ThreadB extends Thread{
	
	private J01_ObjectService service;
	
	
	public J03_ThreadB(J01_ObjectService service) {
		super();
		this.service = service;
	}

	@Override
	public void run() {
		super.run();
		service.serviceMethod();
	}
	
	public static void main(String[] args) {
		J01_ObjectService task=new J01_ObjectService();
		J02_ThreadA a=new J02_ThreadA(task);
		a.setName("a");
		a.start();
		J03_ThreadB b=new J03_ThreadB(task);
		b.setName("b");
		b.start();
		
	}
}
