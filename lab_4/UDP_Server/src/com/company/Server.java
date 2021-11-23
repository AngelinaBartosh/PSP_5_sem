package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Server {
        public static double determinate(double x, double y, double z){
            double n = 0;
            n=(Math.sqrt(10*(Math.sqrt(x)+Math.pow(x,z*y))*(Math.pow(Math.sin(z),2)-Math.abs(x+y)))*Math.exp(z));
            System.out.println("Result:" + n);

            return n;
        }

    public static void toFile(double x, double y, double z, double n){
        try{
            File file = new File ("file.txt");
            if(!file.exists()){
                file.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(file,true);

            fileWriter.append("x = " + x + " y = " + y + " z = " + x + " Answer: " + n + "\n");
            fileWriter.flush();
            fileWriter.close();
            System.out.println("Data written to file: " + file.getName());
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Server connected, waiting for the client...");
        double x,y,z,n;

        DatagramSocket socket=new DatagramSocket(8189);
        byte[]buf = new byte[256];

        while (true){
            DatagramPacket recvPacket=new DatagramPacket(buf, buf.length);
            socket.receive(recvPacket);
            String received = new String(recvPacket.getData(), 0, recvPacket.getLength());
            System.out.println("Come: "+ received);

            String str[] = received.split(" ");
            InetAddress address = recvPacket.getAddress();
            int port = recvPacket.getPort();

            x=Double.parseDouble(str[0]);
            y=Double.parseDouble(str[1]);
            z=Double.parseDouble(str[2]);

            n = determinate(x,y,z);
            buf=("" + n).getBytes();

            DatagramPacket sendPacket = new DatagramPacket(buf, buf.length, address, port);
            socket.send(sendPacket);
            toFile(x,y,z,n);
        }
    }
}
