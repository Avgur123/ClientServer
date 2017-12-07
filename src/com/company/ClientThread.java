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
        String mess="";
        Server.thread_num++;
                thread_num=Server.thread_num;
        try {

        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        System.out.println("DataOutputStream" +String.valueOf(thread_num)+ "created");
        DataInputStream in = new DataInputStream(socket.getInputStream());
        System.out.println("DataInputStream  created");
        while (mess.compareTo("quit")!=0) {
            mess = in.readUTF();
            System.out.println("From Server #" + String.valueOf(thread_num)+ ": " + mess);
            out.writeUTF("From Server#" + String.valueOf(thread_num) + ": " + mess);
            if (mess=="quit") {break;}
        }
            System.out.println("Quit command detected from "  + String.valueOf(thread_num)+mess);
                        socket.close();
        }

        catch (Exception e) {System.out.println("Data I/O error"+e);}

    }
}