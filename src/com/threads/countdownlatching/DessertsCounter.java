package com.threads.countdownlatching;

import com.threads.utils.ThreadUtils;

import java.util.concurrent.CountDownLatch;

public class DessertsCounter implements Runnable
{
    private CountDownLatch latch;

    public DessertsCounter(CountDownLatch latch)
    {
        this.latch = latch;
    }

    @Override
    public void run()
    {
        System.out.println("Cooking Deserts in progress...");
        ThreadUtils.sleepForTime(2000);

        System.out.println("Cooking Deserts Done :)");
        latch.countDown();
    }
}
