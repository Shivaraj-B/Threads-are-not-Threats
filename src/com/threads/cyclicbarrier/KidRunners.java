package com.threads.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

import com.threads.utils.DateUtils;
import com.threads.utils.ThreadUtils;

/*
 * This Class simulates the behaviour of Kids running the 10K marathon
 * These kids take 5 sec to run 5k.
 */

public class KidRunners implements Runnable{
	
	private CyclicBarrier checkPoint5K ;
	private CyclicBarrier checkPoint10K ;
	

	public KidRunners(CyclicBarrier checkPoint5K,CyclicBarrier checkPoint10k) {
		super();
		this.checkPoint5K = checkPoint5K;
		this.checkPoint10K = checkPoint10k;
	}


	@Override
	public void run() {
	
		
		System.out.println("Kids have started to run...till 5k:- "+DateUtils.getCurrentDateTime());
		ThreadUtils.sleepForTime(5000); 
		try {
			this.checkPoint5K.await(); //kids wait for others to reach the 5K check point.
		} catch (InterruptedException | BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Kids resuming the run from 5K towards 10k:- "+DateUtils.getCurrentDateTime() );
		
		ThreadUtils.sleepForTime(5000);
		try {
			this.checkPoint10K.await(); //kids wait for others to reach the 5K check point.
		} catch (InterruptedException | BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
