package Lab8;

import java.rmi.*;

public interface Calc extends Remote {
    int addNum(int a, int b) throws RemoteException;
    int subNum(int a, int b) throws RemoteException;
}
