package com.threads.semaphore;

import com.threads.utils.ThreadUtils;

import java.util.concurrent.Semaphore;

// Simulating behavior of Nathula pass permits.

public class NathulaPass
{
    public static int NUM_OF_PERMITS = 4;

    Semaphore permits = new Semaphore(NUM_OF_PERMITS);

    public void getPermitToNathula(int numOfPermitsNeeded)
    {
        try
        {
            permits.acquire(numOfPermitsNeeded);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        try
        {
            enjoyNathulaVisit(numOfPermitsNeeded);
        }
        finally
        {
            permits.release(numOfPermitsNeeded);

        }

    }

    public void getSinglePermitToNathula(String name)
    {
        try
        {
            permits.acquire();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        try
        {
            enjoyNathulaVisit(name);
        }
        finally
        {
            permits.release();

        }

    }

    /*
        Shared resource which is accessed by Number of resources specified by- NUM_OF_PERMITS
     */
    private void enjoyNathulaVisit(String name)
    {
        System.out.println("Hi " + name + " :Welcome to Nathula pass- The India China border");
        ThreadUtils.sleepForTime(4000);
    }


    private void enjoyNathulaVisit(int numOfPermitsNeeded)
    {
        System.out.println("Welcome to Nathula pass- The India China border");
        System.out.println("Number of people enjoying: " + numOfPermitsNeeded);
        ThreadUtils.sleepForTime(numOfPermitsNeeded * 1000);
    }
}
