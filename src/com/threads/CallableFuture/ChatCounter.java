package com.threads.CallableFuture;

import com.threads.utils.ThreadUtils;

import java.util.concurrent.Callable;

/*
    A callable implementation, simulating the job of preparing the chats and returning back the order placed.
 */
public class ChatCounter implements Callable
{
    private String chatType;
    private int count;

    public ChatCounter(String chatType, int count)
    {
        this.chatType = chatType;
        this.count = count;
    }

    @Override
    public String call() throws Exception
    {
        System.out.println("Working on preparing " + chatType);
        ThreadUtils.sleepForTime(count * 2000);
        String orderServed = " " + chatType + " > " + count;
        return orderServed;
    }
}
