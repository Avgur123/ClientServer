package com.company;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

class ClientThread extends Thread {
    private Socket socket;
    private int thread_num;

    public ClientThread(Socket socket) {
        this.socket = socket;
        this.start();

    }

    public void run() {
        Server.thread_num++;
        thread_num=Server.thread_num;
        try {


        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        System.out.println("DataOutputStream" +String.valueOf(thread_num)+ "created");
        DataInputStream in = new DataInputStream(socket.getInputStream());
        System.out.println("DataInputStream  created");
        String mess = in.readUTF();
        System.out.println("From Server #" +":"+mess);
        out.writeChars("From Server#"+ String.valueOf(thread_num)+":"+mess);}
        catch (Exception e) {System.out.println("Data I/O error"+e);}

    }
}