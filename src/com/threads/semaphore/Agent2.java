package com.threads.semaphore;

//Simulates an Agent who gets the permit for the tourists
public class Agent2 implements Runnable
{
    private NathulaPass nathulaPass;

    public Agent2(NathulaPass nathulaPass)
    {
        this.nathulaPass = nathulaPass;
    }

    @Override
    public void run()

    {
        nathulaPass.getPermitToNathula(4);
        /*nathulaPass.getSinglePermitToNathula("Shiva");
        nathulaPass.getSinglePermitToNathula("Harsha");
        nathulaPass.getSinglePermitToNathula("Raj");*/
    }
}
