package com.threads.countdownlatching;

import com.threads.utils.ThreadUtils;

import java.util.concurrent.CountDownLatch;

public class MainCourseCounter implements Runnable
{
    private CountDownLatch latch;

    public MainCourseCounter(CountDownLatch latch)
    {
        this.latch = latch;
    }

    @Override
    public void run()
    {
        System.out.println("Cooking Main Course in progress...");
        ThreadUtils.sleepForTime(2000);

        System.out.println("Cooking  Main Course Done :)");
        latch.countDown();
    }
}
