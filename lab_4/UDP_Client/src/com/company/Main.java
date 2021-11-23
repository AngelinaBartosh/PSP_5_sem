package com.company;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        String str = "";
        byte buf[] = new byte[256];
        try(Scanner scanner = new Scanner(System.in);
            DatagramSocket socket = new DatagramSocket();
        ){
            System.out.println("Enter x: ");
            str += "" + scanner.nextInt() + " ";
            System.out.println("Enter y: ");
            str += "" + scanner.nextInt() + " ";
            System.out.println("Enter z: ");
            str += "" + scanner.nextInt() + " ";

            InetAddress address = InetAddress.getByName("localhost");
            buf = str.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(buf, buf.length, address, 8189);
            socket.send(sendPacket);

            byte[] buff = new byte[100];
            DatagramPacket recvPacket = new DatagramPacket(buff, buff.length);
            socket.receive(recvPacket);
            String received = new String(recvPacket.getData(), 0, recvPacket.getLength());
            System.out.println("Answer:"+received);
        }
    }
}
