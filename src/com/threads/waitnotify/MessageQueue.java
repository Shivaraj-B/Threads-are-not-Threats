package com.threads.waitnotify;

import java.util.LinkedList;
import java.util.List;

/*
    Simulates the Message Queue. THe methods for adding and removing from Q are synchronized.
 */

public class MessageQueue
{
    private List<String> messagesList = new LinkedList<>();
    private int limit;

    public MessageQueue(int limit)
    {
        this.limit = limit;
    }

    public synchronized void addMessagesToList(String message)
    {
        while (messagesList.size() == limit)
        {
            try
            {
                System.out.println("Reciever  is offline. Not recieving any messages.");
                wait();// go to wait state until some one takes  messages from  list and notify me
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }

        if (messagesList.size() == 0)
        {
            notifyAll();// notify all waiting threads that i added an entry to the list, so there is
            // enough s messages for you to pick and read. This makes, waiting threads become runnable not running
        }
        System.out.println("Message sent to receiver - ." + message);
        messagesList.add(message);


    }

    public synchronized String removeMessagesFromList()
    {
        while (messagesList.size() == 0)
        {
            try
            {
                System.out.println("Waiting for  messages from sender to read..");
                wait(); // go to wait state until some one puts messages into list and notify me.
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }

        if (messagesList.size() == limit)
        {
            notifyAll(); // notify all waiting threads that i have removed an entry from the list, so there is
            // enough space for you to add messages. This makes, waiting threads become runnable not running
        }

        return messagesList.remove(0);
    }

}
