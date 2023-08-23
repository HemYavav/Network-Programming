package Lab2;
import Lab6.*;
import java.io.*;
import java.net.*;

public class MulticastSniffer {

    public static void main(String[] args) {
        if (args.length < 2) {
            System.err.println("Usage: java MulticastSniffer multicast_address port");
            System.exit(1);
        }

        InetAddress group = null;
        int port = 0;

        try {
            group = InetAddress.getByName("224.0.0.1");
            port = Integer.parseInt("8888");
        } catch (UnknownHostException | NumberFormatException ex) {
            System.err.println("Invalid multicast address or port");
            System.exit(1);
        }

        MulticastSocket ms = null;

        try {
            ms = new MulticastSocket(port);
            ms.joinGroup(group);

            byte[] buffer = new byte[8192];
            while (true) {
                DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
                ms.receive(dp);

                String receivedData = new String(dp.getData(), "UTF-8");
                System.out.println("Received: " + receivedData);
            }
        } catch (IOException ex) {
            System.err.println("Error during data reception: " + ex.getMessage());
        } finally {
            if (ms != null) {
                try {
                    ms.leaveGroup(group);
                    ms.close();
                } catch (IOException ex) {
                    System.err.println("Error while closing the MulticastSocket: " + ex.getMessage());
                }
            }
        }
    }
}
