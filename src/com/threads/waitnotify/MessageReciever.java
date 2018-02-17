package com.threads.waitnotify;

import com.threads.utils.ThreadUtils;

/*
    Simulation for message receiver
 */
public class MessageReciever implements Runnable
{

    private MessageQueue messageQ;

    public MessageReciever(MessageQueue messageQ)
    {
        this.messageQ = messageQ;
    }

    @Override
    public void run()
    {

        ThreadUtils.sleepForTime(10000); // Sleeping for 10sec to simulate phone switch off
        System.out.println("Reciever switched ON his phone..");

        // receive and print the messages
        System.out.println("Message received is - " + messageQ.removeMessagesFromList());
        ThreadUtils.sleepForTime(1000);
        System.out.println("Message received is - " + messageQ.removeMessagesFromList());
        ThreadUtils.sleepForTime(1000);
        System.out.println("Message received is - " + messageQ.removeMessagesFromList());
        ThreadUtils.sleepForTime(1000);
        System.out.println("Message received is - " + messageQ.removeMessagesFromList());
        ThreadUtils.sleepForTime(1000);
        System.out.println("Message received is - " + messageQ.removeMessagesFromList());
        ThreadUtils.sleepForTime(1000);


    }
}
