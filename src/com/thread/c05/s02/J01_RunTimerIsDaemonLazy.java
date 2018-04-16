package com.thread.c05.s02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * <p>Function: schedule(TimerTask task,Date firstTime,long period)
 * <p>Description: 
 * 在指定的日期之后，按指定的间隔周期性地无限循环地执行某一任务
 * @since 1.0   
 * @version 1.0  
 * @author 1132381386@qq.com 钟秋森 2018年3月26日 
*/
public class J01_RunTimerIsDaemonLazy {
	private static Timer timer=new Timer(false);
	static public class MyTask extends TimerTask{
		@Override
		public void run() {
			try {
				System.out.println("1 begin 运行了！时间为："+new Date());
				Thread.sleep(20000);
				System.out.println("1 end 运行了！时间为："+new Date());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	static public class MyTask2 extends TimerTask{
		@Override
		public void run() {
			System.out.println("2 begin 运行了！时间为："+new Date());
			System.out.println("运行了！时间为："+new Date());
			System.out.println("2 end 运行了！时间为："+new Date());
		}
	}
	
	public static void main(String[] args) throws ParseException {
		MyTask task=new MyTask();
		MyTask2 task2=new MyTask2();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat sdf2=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString="2018-03-26 18:06:40";
		String dateString2="2018-03-26 18:06:50";
		Date dateRef=sdf.parse(dateString);
		Date dateRef2=sdf2.parse(dateString2);
		System.out.println("字符串时间："+dateRef.toLocaleString()+"  当前时间："+new Date().toLocaleString());
		System.out.println("字符串时间："+dateRef2.toLocaleString()+"  当前时间："+new Date().toLocaleString());
		timer.schedule(task, dateRef);
		timer.schedule(task2, dateRef2);
	}
}
