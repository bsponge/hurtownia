package me.jSkiba;

import java.util.Scanner;

import me.sRewilak.Pracownik;

/**
 * Klasa odpowiedzialna za logike dzialania programu
 */
public class UI {
    public static Scanner scanner = new Scanner(System.in);

    /**
     * Konstruktor klasy Hurtownia
     */
    public UI() {}

    /**
     * Metoda odpowiedzialna za dzialania programu i odbieranie danych od uzytkownika
     */
    public void run() {

        while (true) {
            wyswietlMenu();
            switch (getInput()) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Wybrano niepoprawna opcje");
            }
        }
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

    /*
     * Sprawdza czy podane ID (String) to ID pracownika
     */
    
    public static boolean checkId(String id) {
    	if(Pracownik.getPracownicy()==null || Pracownik.getPracownicy().isEmpty()) return false;
    	return Pracownik.getPracownicy().containsKey(id);
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
