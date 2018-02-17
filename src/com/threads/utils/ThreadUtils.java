package com.threads.utils;

import java.util.concurrent.locks.Lock;


public class ThreadUtils
{
    public static void sleepForTime(long milliSecs)
    {
        try
        {
            Thread.sleep(milliSecs);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    public static void acquireLocks(Lock lock1, Lock lock2)
    {
        while (true)
        {
            boolean gotFirstLock = false;
            boolean gotSecondLock = false;
            //Try acquiring Locks
            try
            {
                gotFirstLock = lock1.tryLock();
                gotSecondLock = lock2.tryLock();
            }
            finally
            {
                if (gotFirstLock && gotSecondLock)
                {
                    return;
                }
                if (gotFirstLock)
                {
                    lock1.unlock();
                }
                if (gotSecondLock)
                {
                    lock2.unlock();
                }
            }
            //Locks not acquired.
            sleepForTime(10);

        }
    }
}
