package com.threads.concurrent;

import com.threads.utils.DateUtils;
import com.threads.utils.ThreadUtils;

public class OnReaching5K implements Runnable{
	



	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Hurrah..!!kids, mid-aged and adults reached 5K point.. :)  "+DateUtils.getCurrentDateTime());
		ThreadUtils.sleepForTime(2000);
				
	}

}
