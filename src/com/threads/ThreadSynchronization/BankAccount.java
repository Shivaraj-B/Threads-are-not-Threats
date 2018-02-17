package com.threads.ThreadSynchronization;

import com.threads.utils.ThreadUtils;

public class BankAccount
{
    private int balance;

    private String transactionTYpe;

    public BankAccount()
    {
        this.balance = 0;
    }

    public int getBalance()
    {
        return balance;
    }


    // This is the block of code which is shared by many threads and it is in danger
    //If this is not synchronize, Suppose, Thread A pitches in and makes transactionType as deposit and goes to sleep.
    //In this gap, Thread B pitches in and makes the transactionType as withdraw and goes to sleep.
    // Now if the Thread A wakes up, then it is going to do withdrawal and not the deposit.
    // This leads to inconsistancy in the output
    public void doTransaction(String transactionTYpe, int amount) throws Exception
    {
        synchronized (this)
        {
            this.transactionTYpe = transactionTYpe;
            System.out.println("Transaction type is - " + this.transactionTYpe + " for amount: " + amount);
            ThreadUtils.sleepForTime(2000);

            if (transactionTYpe.equals("withdraw"))
            {
                if (amount > balance)
                {
                    throw new Exception("NOt enough balance");
                }
                balance -= amount;
            }
            else if (transactionTYpe.equals("deposit"))
            {
                balance += amount;
            }
            ThreadUtils.sleepForTime(1000);
            System.out.println("Current balance after - " + this.transactionTYpe + " is " + balance);
        }
    }


}
