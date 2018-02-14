package com.threads.com.threads.threadPool;


import com.threads.utils.ThreadUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
    Defines a job of Taxi riding. Based on the distance specified by each customer,
    this job sleeps for required amount of time before it says that the job is completed.
*/
public class TaxiRideTask implements Runnable
{
    public static int SPEED = 1;// 1Km/sec
    private int distance;
    private String customerName;

    public TaxiRideTask(int dist, String custName)
    {
        this.distance = dist;
        this.customerName = custName;
    }

    // Assuming all taxis will be driven at a constant speed of 1km/sec. Its too fast though!!
    @Override
    public void run()
    {
        SimpleDateFormat format;
        Date date;
        date = new Date();
        format = new SimpleDateFormat("hh:mm:ss");

        long timeTaken = (distance / SPEED) * 1000;

        System.out.println(customerName + " has started the ride at - " + format.format(date));
        ThreadUtils.sleepForTime(timeTaken);

        date = new Date();
        format = new SimpleDateFormat("hh:mm:ss");
        System.out.println(customerName + " has completed the ride - " + format.format(date));
    }
}
