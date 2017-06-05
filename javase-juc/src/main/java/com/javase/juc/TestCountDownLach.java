package com.javase.juc;

import java.util.concurrent.CountDownLatch;

/**
 * 闭锁：如在完成某些运算时，只有的当其他全部完后后，当前
 * 现场才会继续执行
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
		System.out.println("耗费时间为：" + (end-start));
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
