package com.threads.semaphore;

//Simulates an Agent who gets the permit for the tourists
public class Agent1 implements Runnable
{
    private NathulaPass nathulaPass;

    public Agent1(NathulaPass nathulaPass)
    {
        this.nathulaPass = nathulaPass;
    }

    @Override
    public void run()
    {
        nathulaPass.getPermitToNathula(3);

       /* nathulaPass.getSinglePermitToNathula("Anusha");
        nathulaPass.getSinglePermitToNathula("Sammu");
        nathulaPass.getSinglePermitToNathula("Prema");*/
    }
}
