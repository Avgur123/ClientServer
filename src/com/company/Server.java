package com.company;

import java.util.Scanner;
import java.net.ServerSocket;

public class Server {
    ServerSocket server;
    public Server() {
//create the Scanner
        Scanner input = new Scanner(System.in);
        System.out.print("Type port for server:");
        String s = input.nextLine();
        try {
         server = new ServerSocket(Integer.valueOf(s));
        } catch (Exception e) {

            System.out.print("Server creation error " + e);

        }
    }
    public void wait1 ()
    {
        System.out.print("Waiting for a client...");
        try {
            server.accept();
            System.out.println("Client connected");
        }
            catch (Exception e) {
                System.out.println("Can't accept");
                System.exit(-1);

            }


    }
}
