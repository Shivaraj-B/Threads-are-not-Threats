package com.threads.waitnotify;

import com.threads.utils.ThreadUtils;

//Simulation for message sender
public class MessageSender implements Runnable
{

    private MessageQueue messageQ;

    public MessageSender(MessageQueue messageQ)
    {
        this.messageQ = messageQ;
    }

    @Override
    public void run()
    {
        messageQ.addMessagesToList("Hi buddy");
        ThreadUtils.sleepForTime(1000);

        messageQ.addMessagesToList("How are you");
        ThreadUtils.sleepForTime(1000);

        messageQ.addMessagesToList("HOw is life");
        ThreadUtils.sleepForTime(1000);

        messageQ.addMessagesToList("I had to say a thing...");
        ThreadUtils.sleepForTime(7000);

        messageQ.addMessagesToList("I broke your car !!");

    }
}
