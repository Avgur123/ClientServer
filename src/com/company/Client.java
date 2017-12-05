package com.company;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

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

}
