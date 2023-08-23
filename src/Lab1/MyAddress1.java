package Lab1;

import java.net.*;
public class MyAddress1 {
     public static void main (String[] args) {
         try {
             InetAddress me = InetAddress.getLocalHost();
             String dottedQuad = me.getHostAddress ();
            System.out.println("My address is " + dottedQuad);
         } catch (UnknownHostException ex) {
             System.out.println("I'm sorry. I dont know my own address");
         }
     }
}
