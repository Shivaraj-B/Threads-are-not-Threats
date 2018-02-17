package com.threads.ReentrantLock;


import com.threads.utils.ThreadUtils;

import java.util.Random;
import java.util.concurrent.locks.Lock;

//Simulating a person's transaction

public class JohnTransactions implements Runnable
{
    Account myAcc;
    Account janardhanAcc;

    Lock lock1;
    Lock lock2;

    public JohnTransactions(Account myAcc, Account janardhanAcc, Lock lock1, Lock lock2)
    {
        this.myAcc = myAcc;
        this.janardhanAcc = janardhanAcc;
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    @Override
    public void run()
    {
        Random rand = new Random();
        for (int i = 0; i < 10000; i++)
        {
            //Below code causes deadlock, if the other thread calls the locking in different order
           /* lock1.lock();
            lock2.lock();*/
            ThreadUtils.acquireLocks(lock1, lock2);
            try
            {
                Account.transfer(myAcc, janardhanAcc, rand.nextInt(100));
            }
            finally
            {
                lock1.unlock();
                lock2.unlock();
            }

        }
    }
}
