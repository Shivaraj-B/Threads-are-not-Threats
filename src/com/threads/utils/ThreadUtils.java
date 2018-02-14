package com.threads.utils;

/**
 * Created by IntelliJ IDEA.
 * User: sbasavegowd
 * Date: 2/13/2018
 * Time: 2:57 PM
 */
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
}
