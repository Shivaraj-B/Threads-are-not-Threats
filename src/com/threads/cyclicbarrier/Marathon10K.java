package com.threads.concurrent;

import java.util.concurrent.CyclicBarrier;

public class Marathon10K {
	static CyclicBarrier checkPoint5k =new CyclicBarrier(3, new OnReaching5K());
	static CyclicBarrier checkPoint10k =new CyclicBarrier(3, new OnReaching10K());


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Thread t1= new Thread(new KidRunners(checkPoint5k, checkPoint10k));
		Thread t2= new Thread(new MidAgeRunners(checkPoint5k, checkPoint10k));
		Thread t3= new Thread(new AdultRunners(checkPoint5k, checkPoint10k));
		
		t1.start();
		t2.start();
		t3.start();


	}

}
