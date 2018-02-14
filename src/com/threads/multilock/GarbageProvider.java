package com.threads.multilock;

public class GarbageProvider
{
    //Create garbage collector for an area
    private static GarbageWasteCollector indiranagarWasteCollector = new GarbageWasteCollector("indiranagar");

    public static void main(String args[]){

        //Thread executing a task of collecting dry and wet wast from an Apartment.
        Thread t1 = new Thread(()->
        {
            {
                for(int i=0;i <3; i++)
                {
                    collectDryWaste(10);
                    collectWetWaste(2);
                }
            }
        });

        //Another Thread executing a task of collecting dry and wet wast from a different  Apartment.
        Thread t2 = new Thread(()->
        {
            {
                for(int i=0;i <3; i++)
                {
                    collectDryWaste(5);
                    collectWetWaste(4);
                }

            }
        });

        long startTime= System.currentTimeMillis();
        t1.setName("Marvel apartments");
        t2.setName("Amrutha apartments");
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
        long endTime= System.currentTimeMillis();

        System.out.println("Total time taken "+(endTime-startTime));

        System.out.println("Total Dry waste " +indiranagarWasteCollector.getTotalDryWaste());
        System.out.println("Total Wet waste " + indiranagarWasteCollector.getTotalWetWaste());

    }

    private static void collectDryWaste(int wasteInKg)
    {
        indiranagarWasteCollector.addDryWaste(wasteInKg);
        System.out.println("Currently " + Thread.currentThread().getName()
                + " is thowing away dry garbage of  " + wasteInKg + ". Total DRY waste collected as of now: "
                + indiranagarWasteCollector.getTotalDryWaste());
    }

    private static void collectWetWaste(int wasteInKg)
    {
        indiranagarWasteCollector.addWetWaste(wasteInKg);
        System.out.println("Currently " + Thread.currentThread().getName()
                + " is thowing away wet garbage of  "+wasteInKg + ". Total WET waste collected as of now: "
                +indiranagarWasteCollector.getTotalWetWaste());
    }
}
