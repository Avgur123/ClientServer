package com.company;
import com.sun.org.apache.xml.internal.resolver.readers.ExtendedXMLCatalogReader;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.io.DataInputStream;
import java.io.DataOutputStream;
//import lombok.Data;

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
    public static void ServerListener(Socket servsocket,DataInputStream in1) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Socket ssocket;
                DataInputStream in;
                in=in1;
                String inputstr="";
                while (inputstr.compareTo("quit")!=0) {
                    try {
                        inputstr = in.readUTF();
                    } catch(Exception e) { System.out.print("ServerListener read error"+e);}

                    System.out.print("ServerListener:" + inputstr);

                }

            }

        }).start();
    }

        public static void main(String[] args) {
        // write your code here
        //
        DataOutputStream out = null;
        DataInputStream in= null;

        System.out.print("Main: starting client...Type port:");
        Scanner input = new Scanner(System.in);

        String ss = input.nextLine();
        try {


        new Client("localhost",Integer.valueOf(ss));
        out = new DataOutputStream(s.getOutputStream());
        System.out.println("DataOutputStream  created");
        in = new DataInputStream(s.getInputStream());
        System.out.println("DataInputStream  created");
        } catch (Exception e ) {System.out.print("Exception:"+e);}

        ServerListener (s,in);

        while (true) {
            System.out.print("Type something:\n");
            ss = input.nextLine();
           try {
               out.writeUTF(ss);
               ss="";
               //ss=in.readUTF();
               //System.out.print("Message from server:" + ss);
           } catch (Exception e) {    System.out.print("Write to server error"+e);}


        }

    }
}
