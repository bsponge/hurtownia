package me.jSkiba;

import java.util.Scanner;

/**
 * Klasa odpowiedzialna za logike dzialania programu
 */
public class Hurtownia {
    public static Scanner scanner = new Scanner(System.in);

    /**
     * Konstruktor klasy Hurtownia
     */
    public Hurtownia() {}

    /**
     * Metoda odpowiedzialna za dzialania programu i odbieranie danych od uzytkownika
     */
    public void run() {

    }

    /**
     * Wyswietla menu uzytkownika
     */
    public void wyswietlMenu() {
        System.out.println("=====Menu=====");
        System.out.println("1.");
        System.out.println("2.");
        System.out.println("3.");
        System.out.println("0. Exit");
    }

    /**
     * Pobiera dane z wejscia tak dlugo az bedzie to integer
     * @return Zwraca podany integer z wejscia lub -1 jezeli dane z wejscia nie moga byc przekonwertowane na integera
     */
    public static int getInput() {
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
