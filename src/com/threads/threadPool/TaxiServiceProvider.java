package com.threads.threadPool;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/*
    This class simulates the customers for taking a Taxi ride.
    As of now we have only 3 Taxis, and customers are served by these pool of taxis.
 */
public class TaxiServiceProvider
{
    private static final int NO_OF_TAXIS = 3;

    public static void main(String args[])
    {
        long startTime = System.currentTimeMillis();
        ExecutorService taxiPool = Executors.newFixedThreadPool(NO_OF_TAXIS);

        //Creating taxi riding task based on the customer name and distance they want to travel
        taxiPool.submit(new TaxiRideTask(5, "john"));
        taxiPool.submit(new TaxiRideTask(2, "keshav"));
        taxiPool.submit(new TaxiRideTask(3, "paul"));
        taxiPool.submit(new TaxiRideTask(1, "santa"));
        taxiPool.submit(new TaxiRideTask(6, "mahalinga"));

        taxiPool.shutdown();
        try
        {
            taxiPool.awaitTermination(1, TimeUnit.DAYS); //Wait for 1 day and if tasks are not completed, terminate them.
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();

        System.out.println("Total time taken to serve 5 customers - " + (endTime - startTime));

    }
}
