package Lab6;

import java.io.*;
import java.net.*;

public class MulticastSender {

    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        InetAddress ia = null;
        int port = 0;
        byte ttl = (byte) 1;
        try {
            ia = InetAddress.getByName(args[0]);
            port = Integer.parseInt(args[1]);
            if (args.length > 2) {
                ttl = (byte) Integer.parseInt(args[2]);
            }
        } catch (NumberFormatException | IndexOutOfBoundsException
                | UnknownHostException ex) {
            System.err.println(ex);
            System.err.println(
                    "Usage: java MulticastSender multicast_address port ttl");
            System.exit(1);
        }
        byte[] data = "Hell othis is Hem Message\r\n".getBytes();
        DatagramPacket dp = new DatagramPacket(data, data.length, ia, port);
        try (MulticastSocket ms = new MulticastSocket()) {
            ms.setTimeToLive(ttl);
            ms.joinGroup(ia);
            for (int i = 1; i < 10; i++) {
                ms.send(dp);
            }
            ms.leaveGroup(ia);
        } catch (SocketException ex) {
            System.err.println(ex);
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}
