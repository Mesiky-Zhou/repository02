package com.javase.juc;

import java.util.concurrent.CountDownLatch;

/**
 * �������������ĳЩ����ʱ��ֻ�еĵ�����ȫ�����󣬵�ǰ
 * �ֳ��Ż����ִ��
 * @author Administrator
 *
 */
public class TestCountDownLach {

	public static void main(String[] args) throws InterruptedException {
		CountDownLatch latch = new CountDownLatch(5);
		LatchDemo ld = new LatchDemo(latch);
		

		long start = System.currentTimeMillis();
		for(int i=0;i<5;i++){
			new Thread(ld).start();
		}
		
		latch.await();
		
		long end = System.currentTimeMillis();
		System.out.println("�ķ�ʱ��Ϊ��" + (end-start));
	}

}

class LatchDemo implements Runnable{
	private CountDownLatch latch;
	
	public LatchDemo(CountDownLatch latch){
		this.latch = latch;
	}

	public void run() {
		synchronized(this) {
			try{
				for(int i=0;i<50000;i++){
					if(i%2==0){
						System.out.println(i);
					}
				}
			}finally{
				this.latch.countDown();
			}
		} 
		
	}
	
	
}
