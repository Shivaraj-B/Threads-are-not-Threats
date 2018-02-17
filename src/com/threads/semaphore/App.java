package com.threads.semaphore;


public class App
{
    private static NathulaPass nathulaPass = new NathulaPass();

    public static void main(String args[])
    {
        Thread t1 = new Thread(new Agent1(nathulaPass));
        Thread t2 = new Thread(new Agent2(nathulaPass));

        t1.start();
        t2.start();
    }
}
