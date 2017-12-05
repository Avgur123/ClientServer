package com.company;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

    Socket s;
    BufferedReader br; //
    BufferedWriter bw; //

    public Client (String host, int port){

        try {

            Socket s = new Socket(host,port);
        }
        catch (Exception e){
            System.out.print("Socket creation error");
        }

    }
    public Client (){

    }
    public static void main(String[] args) {
        // write your code here
        //Client client = new Client("localhost",1212);

        System.out.print("Main: starting server");
        Scanner input = new Scanner(System.in);

        String ss = input.nextLine();

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

    }
}
