package com.threads.ReentrantLock;

/*
    Simulating banck Account representation
 */

public class Account
{
    private int balance = 10000;

    //Transfer amount from - fromAcc to toAcc.
    public static void transfer(Account fromAcc, Account toAcc, int amount)
    {
        fromAcc.withdrawal(amount);
        toAcc.deposit(amount);
    }

    public void deposit(int amount)
    {
        balance = balance + amount;
    }

    public void withdrawal(int amount)
    {
        balance = balance - amount;
    }

    public int getBalance()
    {
        return balance;
    }

}
