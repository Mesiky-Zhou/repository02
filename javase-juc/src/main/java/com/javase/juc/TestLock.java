package com.javase.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ͬ����ʽ��
 * 1��synchronized��
 * 
 * 2��synchronized����
 * 
 * 
 * 3��JDK1.5��Lock�� ͨ��lock()������unlock������
 * @author Administrator
 *
 */
public class TestLock {

	public static void main(String[] args) {
		Ticket t = new Ticket();
		
		new Thread(t,"1�Ŵ���").start();
		new Thread(t,"2�Ŵ���").start();
		new Thread(t,"3�Ŵ���").start();
		new Thread(t,"4�Ŵ���").start();
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
						System.out.println(Thread.currentThread().getName() + "��Ʊ�ɹ�����ƱΪ:" + (--ticket));
					}
				} finally{
					lock.unlock();
				}
			}
		
		
	}
	
}
