package com.threads.CallableFuture;

import com.threads.utils.ThreadUtils;

import java.util.concurrent.Callable;

/*
    A callable implementation, simulating the job of preparing the chats and returning back the order placed.
 */
public class DosaCounter implements Callable
{
    private String dosaType;
    private int count;

    public DosaCounter(String dosaType, int count)
    {
        this.dosaType = dosaType;
        this.count = count;
    }

    @Override
    public String call() throws Exception
    {
        System.out.println("Working on preparing " + dosaType);
        ThreadUtils.sleepForTime(count * 1000);
        String orderServed = " " + dosaType + " > " + count;
        return orderServed;
    }
}
