package Lab1;

import java.net.*;
public class ReverseTest {
    public static void main (String[] args) throws UnknownHostException {
        InetAddress ia = InetAddress.getByName("23.49.69.74");
        System.out.println(ia.getCanonicalHostName());
    }    
}
