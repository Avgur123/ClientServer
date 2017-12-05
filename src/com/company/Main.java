package com.company;
import java.util.Scanner;



public class Main {

    public static void main(String[] args) {
	// write your code here
     //Client client = new Client("localhost",1212);
        System.out.print("Type: 'c' - for client; 's' for server:");
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();

     /*   if (s=="s") {
            Server server = new Server();

        }
        if (s=="c")   {

            System.out.print("Type port for client:");
            s = input.nextLine();
            Client client= new Client("localhost",Integer.valueOf(s));

        }*/
        /*Server server = new Server();
        server.wait1();*/
        System.out.print("Type port for client:");
        s = input.nextLine();
        Client client= new Client("localhost",Integer.valueOf(s));

    }
    }
