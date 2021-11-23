package com.company;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Server {

    public static ServerSocket serverSocket;

    public static void main(String[] args) throws Exception{
        System.out.println("Opening port...");

        serverSocket = new ServerSocket(8081);
        System.out.println("Server running on port 8081\nWaiting for client...");

        Socket link = serverSocket.accept();

        Scanner input = new Scanner(link.getInputStream());
        PrintWriter output = new PrintWriter(link.getOutputStream(), true);

        String msg = "";
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");

        while(!msg.equalsIgnoreCase("close")){
            Date date = new Date();
            msg = input.nextLine();
            System.out.println("Client says: " + msg);
            output.println(msg);
            System.out.println("Server says: " + msg + "\tsent: " + dateFormat.format(date));
        }
        link.close();
    }
}