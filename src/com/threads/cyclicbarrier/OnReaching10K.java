package com.threads.concurrent;

import com.threads.utils.DateUtils;
import com.threads.utils.ThreadUtils;

public class OnReaching10K implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Hurrah..!!kids, mid-aged and adults reached 10K point.. :)  "+DateUtils.getCurrentDateTime());
		ThreadUtils.sleepForTime(2000);
		System.out.println("End of Marathon. THanks for participating :)  "+DateUtils.getCurrentDateTime());
				
	}
	
	// micro services
	// spring boot
	

}
