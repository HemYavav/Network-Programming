package Lab6;

import java.io.*;
import java.net.*;

public class MulticastReceiver {

         @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        if (args.length < 2) {
            System.err.println("Usage: java MulticastReceiver multicast_address port");
            System.exit(1);
        }

        InetAddress group = null;
        int port = 0;

        try {
            group = InetAddress.getByName(args[0]);
            port = Integer.parseInt(args[1]);
        } catch (UnknownHostException | NumberFormatException ex) {
            System.err.println("Invalid multicast address or port");
            System.exit(1);
        }

        try {
            MulticastSocket socket = new MulticastSocket(port);
            socket.joinGroup(group);

            byte[] buffer = new byte[8192];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

            while (true) {
                socket.receive(packet);
                String message = new String(packet.getData(), 0, packet.getLength());
                System.out.println("Received: " + message);
            }
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}
