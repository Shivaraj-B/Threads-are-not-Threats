package com.threads.CallableFuture;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/*
    Simulating food order app. Here, each order is served by respective counter and the delivery boy waits till all
    the counters are done with their part of their order.
 */
public class FoodApp
{
    public static void main(String args[])
    {
        //Items ordered by the customer.
        List<FutureTask> tasks = new ArrayList<>();
        tasks.add(new FutureTask(new ChatCounter("Samosa chat", 2)));
        tasks.add(new FutureTask(new DosaCounter("Masala dosa", 3)));
        tasks.add(new FutureTask(new DosaCounter("Plain dosa", 2)));
        tasks.add(new FutureTask(new ChatCounter("pani puri", 1)));


        ExecutorService exec = Executors.newFixedThreadPool(2);

        tasks.forEach(exec::execute);


        StringBuilder finalOrderServed = new StringBuilder();

        try
        {
            for (FutureTask task : tasks)
            {
                finalOrderServed.append(task.get());
                finalOrderServed.append(", ");
            }
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        catch (ExecutionException e)
        {
            e.printStackTrace();
        }

        exec.shutdown();

        System.out.println("All orders prepared. Delivery boy picks up the order");
        System.out.println("Final order delivered to the customer: " + finalOrderServed);
    }
}
