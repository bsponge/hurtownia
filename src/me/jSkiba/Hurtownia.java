package me.jSkiba;

import java.util.Scanner;

public class Hurtownia {
    public static Scanner scanner = new Scanner(System.in);

    public Hurtownia() {}

    public void run() {

    }

    public void printMenu() {
        System.out.println("=====Menu=====");
        System.out.println("1.");
        System.out.println("2.");
        System.out.println("3.");
        System.out.println("0. Exit");
    }

    public int getInput() {
        String str = null;
        try {
            while (str == null) {
                System.out.print("> ");
                str = scanner.nextLine();
                try {
                    int integer = Integer.parseInt(str);
                    return integer;
                } catch (Exception e) {
                    //
                }
                str = null;
            }
        } catch (Exception e) {
            return -1;
        }
        return -1;
    }
}
