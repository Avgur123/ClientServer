package com.company;

import com.company.Client;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.server.ExportException;
import java.util.Scanner;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import com.company.ClientThread;


public class Server {

    public static ServerSocket server;
    public static int thread_num=0;

    public Server(String s) {


            try {
                server = new ServerSocket(Integer.valueOf(s));

            } catch (Exception e) {

                System.out.print("Server creation error " + e);

            }
        }


        public static void main(String[] args) {
            // write your code here
            //Client client = new Client("localhost",1212);
            Socket client=null;

            System.out.print("Creating server...\n");
            Scanner input = new Scanner(System.in);
            System.out.print("Type port for server:\n");
            String s = input.nextLine();

            new Server(s);

// канал записи в сокет
            try {
            while (true) {
                      //Server.wait1();

                    client = server.accept();
                    new ClientThread(client);

            } }             catch (Exception e) {
                    System.out.println("Exception:" + e);
                }


            }
        /*Server server = new Server();
        server.wait1();*/



        public static Socket wait1 () {
            Socket s = new Socket();
            System.out.print("Waiting for a client...");
            try {
                s = server.accept();
                System.out.println("Client connected");
                return s;
            } catch (Exception e) {
                System.out.println("Can't accept");
                System.exit(-1);

            }


            return s; } }
