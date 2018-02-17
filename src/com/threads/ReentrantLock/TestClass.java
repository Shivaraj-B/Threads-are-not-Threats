package com.threads.ReentrantLock;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestClass
{
    static Account johnAccount = new Account();
    static Account janardhanAccount = new Account();

    static Lock lock1 = new ReentrantLock();
    static Lock lock2 = new ReentrantLock();


    public static void main(String args[])
    {
        Thread t1 = new Thread(new JohnTransactions(johnAccount, janardhanAccount, lock1, lock2));
        Thread t2 = new Thread(new JanardhanTransactions(janardhanAccount, johnAccount, lock1, lock2));

        t1.start();
        t2.start();

        try
        {
            t1.join();
            t2.join();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        finished();

    }

    public static void finished()
    {
        System.out.println("John account balance is: " + johnAccount.getBalance());
        System.out.println("Janardhan account balance is: " + janardhanAccount.getBalance());
        System.out.println("Total account balance is: " + (janardhanAccount.getBalance() + johnAccount.getBalance()));
    }
}
