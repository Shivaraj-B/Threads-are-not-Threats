package com.threads.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

import com.threads.utils.DateUtils;
import com.threads.utils.ThreadUtils;

public class MidAgeRunners implements Runnable{
	
	private CyclicBarrier checkPoint5K ;
	private CyclicBarrier checkPoint10K ;
	

	public MidAgeRunners(CyclicBarrier checkPoint5K,CyclicBarrier checkPoint10k) {
		super();
		this.checkPoint5K = checkPoint5K;
		this.checkPoint10K = checkPoint10k;
	}


	@Override
	public void run() {
		System.out.println("Mid age people have started to run...till 5k:- "+DateUtils.getCurrentDateTime());
		ThreadUtils.sleepForTime(3000);
		try {
			 this.checkPoint5K.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Mid age people resuming the run from 5K towards 10k:- "+DateUtils.getCurrentDateTime() );
		
		ThreadUtils.sleepForTime(3000);
		try {
			this.checkPoint10K.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
