package Lab8;

import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;

public class Calc_impl extends UnicastRemoteObject implements Calc {

    public Calc_impl() throws RemoteException {
    }

    public int addNum(int a, int b) {
        return a + b;
    }

    public int subNum(int a, int b) {
        return a - b;
    }
}
