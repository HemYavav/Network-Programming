package Lab8;

import java.rmi.Naming;
import java.rmi.RemoteException;

public class Server {
    public static void main(String[] args) {
        try {
            Calc_impl localobj = new Calc_impl();
            Naming.rebind("Calc", localobj);
            System.out.println("Server is ready.");
        } catch (RemoteException re) {
            System.out.println("RemoteException: " + re);
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }
}
