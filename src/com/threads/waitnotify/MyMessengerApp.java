package com.threads.waitnotify;

public class MyMessengerApp
{
    static MessageQueue messageQ = new MessageQueue(3);

    public static void main(String args[])
    {
        Thread t1 = new Thread(new MessageSender(messageQ));
        Thread t2 = new Thread(new MessageReciever(messageQ));

        t1.start();
        t2.start();


    }
}
