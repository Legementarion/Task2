package com.company.ClientServer;

/**
 * Created by lego on 18.02.16.
 */
public class MainControlConnection implements Runnable{

    public void go(){
        Thread thread = new Thread();
        thread.start();

        Client client = new Client();
        client.init_connect();
        client.setBuff("ololo");

    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        Server server = new Server();
        server.Connection();
    }
}
