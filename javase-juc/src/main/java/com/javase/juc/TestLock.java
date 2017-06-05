package com.javase.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 同步方式：
 * 1、synchronized块
 * 
 * 2、synchronized方法
 * 
 * 
 * 3、JDK1.5后Lock： 通过lock()上锁，unlock解锁。
 * @author Administrator
 *
 */
public class TestLock {

	public static void main(String[] args) {
		Ticket t = new Ticket();
		
		new Thread(t,"1号窗口").start();
		new Thread(t,"2号窗口").start();
		new Thread(t,"3号窗口").start();
		new Thread(t,"4号窗口").start();
	}

}

class Ticket implements Runnable{
	private int ticket = 100;
	private Lock lock = new ReentrantLock();

	public void run() {
		
		
			while(true){
				
				try {
					lock.lock();
					if(ticket>0){
						System.out.println(Thread.currentThread().getName() + "卖票成功，余票为:" + (--ticket));
					}
				} finally{
					lock.unlock();
				}
			}
		
		
	}
	
}
