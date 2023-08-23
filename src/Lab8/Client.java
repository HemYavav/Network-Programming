package Lab8;

import java.rmi.Naming;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first number: ");
        int a = sc.nextInt();
        System.out.println("Enter second number: ");
        int b = sc.nextInt();

        try {
            Calc calcobj = (Calc) Naming.lookup("rmi://localhost/Calc");
            System.out.println("Sum = " + calcobj.addNum(a, b));
            System.out.println("Difference = " + calcobj.subNum(a, b));
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }
}
