package com.javase.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class TestCallable {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ThreadDemo td = new ThreadDemo();
		
		FutureTask<Integer> ft = new FutureTask<Integer>(td);
		
		new Thread(ft).start();
		
		int result = ft.get();//Ҳ�������ڱ���,��Ҫ�ȵ��߳�ִ�������ܷ���
		System.out.println(result);

	}

}

class ThreadDemo implements Callable<Integer>{

	public Integer call() throws Exception {
		int sum = 0;
		for (int i = 0; i <= 100; i++) {
			sum = sum+i;
		}
		return sum;
	}
	
}
