package com.threads.synchronization;

/**
 * Created by IntelliJ IDEA.
 * User: sbasavegowd
 * Date: 2/12/2018
 * Time: 12:57 PM
 */
public class BankAccount
{
    private String name;
    private int balance;
    private String accountType;



    private String transactionTYpe;

    public BankAccount(String name, String accountType)
    {
        this.name = name;
        this.balance = 0;
        this.accountType = accountType;
    }

    public  int getBalance()
    {
        return balance;
    }

    public void setBalance(int balance)
    {
        this.balance = balance;
    }

    public String getAccountType()
    {
        return accountType;
    }

    public void setAccountType(String accountType)
    {
        this.accountType = accountType;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public  int deposit(int amount)
    {
        return balance+=amount;
    }

    public  int withdraw(int amount) throws Exception
    {
        if(amount<balance)
        {
            String err = "Your account doesn't have the amount- "+amount +" Your actual balance is "+balance;
            throw new Exception(err);
        }

        return  balance-=amount;
    }

    public String getTransactionTYpe()
    {
        return transactionTYpe;
    }

    public void setTransactionTYpe(String transactionTYpe)
    {
        this.transactionTYpe = transactionTYpe;
    }

    // This is the block of code which is shared by many threads and it is in danger
    //If this is not synchronize, Suppose, Thread A pitches in and makes transactionType as deposit and goes to sleep.
    //In this gap, Thread B pitches in and makes the transactionType as withdraw and goes to sleep.
    // Now if the Thread A wakes up, then it is going to do withdrawal and not the deposit.
    // This leads to inconsistancy in the output
    public void doTransaction(String transactionTYpe, int amount) throws Exception
    {
        synchronized(this)
        {
            this.transactionTYpe = transactionTYpe;
            System.out.println("Transaction type is - " + this.transactionTYpe);
            sleepForTime(2000);

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
            sleepForTime(1000);
            System.out.println("Current balance after - " + this.transactionTYpe + " is " + balance);
        }
    }

    private void sleepForTime(int timeInMs)
    {
        try
        {
            Thread.sleep(timeInMs);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }


}
