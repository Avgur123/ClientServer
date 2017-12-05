package com.company;

import com.company.Client;

import java.net.ServerSocket;
import java.util.Scanner;

public class Server {

    ServerSocket server;

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
            Server server = new Server();
            server.wait1();

        }

        /*Server server = new Server();
        server.wait1();*/



        public void wait1 () {
            System.out.print("Waiting for a client...");
            try {
                server.accept();
                System.out.println("Client connected");
            } catch (Exception e) {
                System.out.println("Can't accept");
                System.exit(-1);

            }


        } }
