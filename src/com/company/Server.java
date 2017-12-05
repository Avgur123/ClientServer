package com.company;

import com.company.Client;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.server.ExportException;
import java.util.Scanner;
import java.io.DataInputStream;
import java.io.DataOutputStream;

public class Server {

    public static ServerSocket server;

    public Server() {


            Scanner input = new Scanner(System.in);
            System.out.print("Type port for server:");
            String s = input.nextLine();
            try {
                server = new ServerSocket(Integer.valueOf(s));

            } catch (Exception e) {

                System.out.print("Server creation error " + e);

            }
        }

        public static void main(String[] args) {
            // write your code here
            //Client client = new Client("localhost",1212);

            System.out.print("Creating server...");
            new Server();
            Socket client = Server.wait1();
// канал записи в сокет
            try {
                DataOutputStream out = new DataOutputStream(client.getOutputStream());
                System.out.println("DataOutputStream  created");
                DataInputStream in = new DataInputStream(client.getInputStream());
                System.out.println("DataInputStream  created");
                while (true) {
                String mess = in.readUTF();
                System.out.println("From Server:" +mess);
                out.writeChars("From Server:" +mess);

                }

            } catch (Exception e) { System.out.println("Exception:"+e);}


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
