package com.company;

import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws Exception {
	    System.out.println("Connecting to server...\n");

        Socket link = new Socket(InetAddress.getLocalHost(), 8081);

        System.out.println("Send message to server");

        Scanner input = new Scanner(link.getInputStream());
        PrintWriter output = new PrintWriter(link.getOutputStream(), true);
        Scanner cmdInput = new Scanner(System.in);

        String msg = "";
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
        while(!msg.equalsIgnoreCase("close")){
            Date date = new Date();
            msg = cmdInput.nextLine();
            output.println(msg);
            msg = input.nextLine();
            System.out.println("Server says: " + msg + "\tsent: " + dateFormat.format(date));
        }
        link.close();
    }
}
