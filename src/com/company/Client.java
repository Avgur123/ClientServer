package com.company;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.io.DataInputStream;
import java.io.DataOutputStream;


public class Client {

    public static Socket s;
    BufferedReader br; //
    BufferedWriter bw; //

    public Client (String host, int port){

        try {

            s = new Socket(host,port);

        }
        catch (Exception e){
            System.out.print("Socket creation error");
        }


    }
    public Client (){

    }
    public static void main(String[] args) {
        // write your code here
        //

        System.out.print("Main: starting client...");
        Scanner input = new Scanner(System.in);

        String ss = input.nextLine();
        try {


        new Client("localhost",Integer.valueOf(ss));
        DataOutputStream out = new DataOutputStream(s.getOutputStream());
        System.out.println("DataOutputStream  created");
        DataInputStream in = new DataInputStream(s.getInputStream());
        System.out.println("DataInputStream  created");
        } catch (Exception e ) {System.out.print("Exception:"+e);}

        while (true) {
            System.out.print("Type something:");
        }

    }
}
