package com.threads.countdownlatching;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;


public class HotelFiveStar
{
    public static int NUM_OF_COUNTER = 3;
    static CountDownLatch countersLatch = new CountDownLatch(NUM_OF_COUNTER);

    public static void main(String args[])
    {
        /*
            Creating 3 counters
         */
        StartersCounter starterJob = new StartersCounter(countersLatch);
        DessertsCounter dessertsJob = new DessertsCounter(countersLatch);
        MainCourseCounter mainCourseJob = new MainCourseCounter(countersLatch);

        Thread t1 = new Thread(starterJob);
        Thread t2 = new Thread(dessertsJob);
        Thread t3 = new Thread(mainCourseJob);

        t1.start();
        t2.start();
        t3.start();
        boolean isOrderReady = false;

        try
        {
            isOrderReady = countersLatch.await(8, TimeUnit.SECONDS);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        if (isOrderReady)
        {
            System.out.println("Done with orders. Serving now..:)");
        }
        else
        {
            System.out.println("Customer waited for long.. They are leaving :(");

        }
    }
}
