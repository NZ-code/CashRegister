package org.example;

public class Main {
    public static void main(String[] args) {
        CashRegister cashRegister = new CashRegister();

        cashRegister.giveChangeBack(1.3);
        System.out.println("---------------------------------");
        cashRegister.giveChangeBack(11.70);
        System.out.println("---------------------------------");
        cashRegister.giveChangeBack(6.70);
        System.out.println("---------------------------------");
        cashRegister.giveChangeBack(4.30);
        System.out.println("---------------------------------");

        cashRegister.giveChangeBack(10000000000000000000000000.0);
    }
}