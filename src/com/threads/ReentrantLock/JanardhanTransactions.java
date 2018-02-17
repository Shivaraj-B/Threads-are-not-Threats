package com.threads.ReentrantLock;


import com.threads.utils.ThreadUtils;

import java.util.Random;
import java.util.concurrent.locks.Lock;

//Simulating a person's transaction
public class JanardhanTransactions implements Runnable
{
    Account myAcc;
    Account johnAcc;
    Lock lock1;
    Lock lock2;

    public JanardhanTransactions(Account myAcc, Account johnAcc, Lock lock1, Lock lock2)
    {
        this.myAcc = myAcc;
        this.johnAcc = johnAcc;
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    @Override
    public void run()
    {
        Random rand = new Random();
        for (int i = 0; i < 10000; i++)
        {
            /*lock2.lock();
            lock1.lock();*/
            ThreadUtils.acquireLocks(lock2, lock1);

            try
            {
                Account.transfer(myAcc, johnAcc, rand.nextInt(100));
            }
            finally
            {
                lock1.unlock();
                lock2.unlock();
            }
        }
    }
}
