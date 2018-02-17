package com.threads.countdownlatching;

import com.threads.utils.ThreadUtils;

import java.util.concurrent.CountDownLatch;

public class StartersCounter implements Runnable
{
    private CountDownLatch latch;

    public StartersCounter(CountDownLatch latch)
    {
        this.latch = latch;
    }

    @Override
    public void run()
    {
        System.out.println("Cooking Starters in progress...");
        ThreadUtils.sleepForTime(2000);

        System.out.println("Cooking Starters Done :)");
        latch.countDown();
    }
}
