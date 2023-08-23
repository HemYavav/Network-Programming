package Lab1;

import java.net.*;
public class AddressTests {
    public static void main(String[] args) {
        try{
        InetAddress ia = InetAddress.getByName("28.49.69.74");
        byte[] address = ia.getAddress();
        if(address.length == 4){
            System.out.println("4");
        }
        else if(address.length == 16){
            System.out.println("6");
        }
        else{
            System.out.println("-1");
        }  
        }
        catch(UnknownHostException ex){
            System.out.println("could not find");
        }
    }
}
