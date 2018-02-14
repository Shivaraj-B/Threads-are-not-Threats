package com.threads.multilock;

import com.threads.utils.ThreadUtils;

/**
 * This is  a class representing the Garbage waste collector. Each Object of this is specific to the area specified.
 * There are 2 types of waste that can be collected - Dry waste and Wet waste
 */
public class GarbageWasteCollector
{
    private String area;
    private int totalWetWaste;
    private int totalDryWaste;
    private int dryWasteInKg;
    private int wetWasteInKg;

    //Providing 2 seperate locks for entering into the code block for Dry and Wet waste
    final Object lockForDryWaste = new Object();
    final Object lockForWetWaste = new Object();


    public GarbageWasteCollector(String area)
    {
        this.area = area;
        this.totalDryWaste=0;
        this.totalWetWaste=0;
    }


    /* This method adds the dry waste provided and sums up to the total Dry waste.
       Here we use block synchronization using  a separate lock
     */

    public  void addDryWaste(int wasteInKg)
    {
        synchronized (lockForDryWaste)
        {
            this.dryWasteInKg = wasteInKg;
            ThreadUtils.sleepForTime(2000);
            totalDryWaste += this.dryWasteInKg;
        }
    }

    /* This method adds the Wet waste provided and sums up to the total Wet waste.
       Here we use block synchronization using  a separate lock
     */
    public synchronized  void addWetWaste(int wasteInKg)
    {
        synchronized (lockForWetWaste)
        {
            this.wetWasteInKg = wasteInKg;
            ThreadUtils.sleepForTime(2000);
            totalWetWaste += this.wetWasteInKg;
        }
    }

    /*
        * This is the code block alternative to the above addDryWaste and addWetWaste.
        * This code uses synchronization at method level and the problem here is that we have only 1 lock.
        * When a thread A enters the addDryWaste() code block, it acquires the lock for the object.
        * At this point, thread B cannot enter the addWetWaste() code block even though both code blocks are independent of each other.
        * This doesn't have the impact on the output, but the impact is on the time.
        * This takes double the time, the above  approach takes.

     */
    /*public synchronized void addDryWaste(int wasteInKg)
    {
        this.wasteInKg = wasteInKg;
        ThreadUtils.sleepForTime(2000);
        totalDryWaste +=this.wasteInKg;
    }

    public synchronized  void addWetWaste(int wasteInKg)
    {
        this.wasteInKg = wasteInKg;
        ThreadUtils.sleepForTime(2000);
        totalWetWaste +=this.wasteInKg;
    }*/

    public int totalWasteInArea()
    {
        return  totalDryWaste+totalWetWaste;
    }

    public String getArea()
    {
        return area;
    }

    public void setArea(String area)
    {
        this.area = area;
    }

    public int getTotalWetWaste()
    {
        return totalWetWaste;
    }

    public void setTotalWetWaste(int totalWetWaste)
    {
        this.totalWetWaste = totalWetWaste;
    }

    public int getTotalDryWaste()
    {
        return totalDryWaste;
    }

    public void setTotalDryWaste(int totalDryWaste)
    {
        this.totalDryWaste = totalDryWaste;
    }

    public int getDryWasteInKg()
    {
        return dryWasteInKg;
    }

    public void setDryWasteInKg(int dryWasteInKg)
    {
        this.dryWasteInKg = dryWasteInKg;
    }

    public int getWetWasteInKg()
    {
        return wetWasteInKg;
    }

    public void setWetWasteInKg(int wetWasteInKg)
    {
        this.wetWasteInKg = wetWasteInKg;
    }
}
