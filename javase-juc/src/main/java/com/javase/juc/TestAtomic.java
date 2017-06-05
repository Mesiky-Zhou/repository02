package com.javase.juc;

public class TestAtomic {

	public static void main(String[] args) {
		AtomicThread td = new AtomicThread();
		
		for(int i=0;i<10; i++){
			new Thread(td).start();;
		}

	}

}

class AtomicThread implements Runnable{
	private int sn = 0;

	public void run() {
		
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(this.getSn());
		
	}
	
	public int getSn(){
		return this.sn++;
	}
	
}
