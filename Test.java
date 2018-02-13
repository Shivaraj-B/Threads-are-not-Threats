package com.threads.synchronization;

/**
 * Created by IntelliJ IDEA.
 * User: sbasavegowd
 * Date: 2/12/2018
 * Time: 2:01 PM
 */
public class Test
{
    static BankAccount husbandAcc= new BankAccount("John", "Savings");

    public static  void  main(String args[])
    {
        Thread t1 = new Thread(new Husband());
        Thread t2 = new Thread(new Wife());
        t1.setName("John");
        t2.setName("LIsa");

        t1.start();
        t2.start();

    }
//Thread accessing the critical part to do the deposit transaction.
    public static class Husband implements Runnable
    {

        @Override
        public void run()
        {
            for(int i=0;i<3;i++)
            {
                try
                {
                    husbandAcc.doTransaction("deposit", 2000);
                }
                catch (Exception e)
                {
                    System.out.println("error while withdrawal. Balance is "+husbandAcc.getBalance());
                }
            }

        }
    }

//Thread accessing the critical part to do the Withdrawal transaction.
    public static class Wife implements Runnable
    {

        @Override
        public void run()
        {
            for(int i=0;i<3;i++)
            {
                try
                {
                    husbandAcc.doTransaction("withdraw", 250);
                    System.out.println(Thread.holdsLock(husbandAcc));

                }
                catch (Exception e)
                {
                    System.out.println("error while withdrawal. Balance is " + husbandAcc.getBalance());
                }
            }
        }
    }


}
