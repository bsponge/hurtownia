package me.jSkiba;

import java.util.Scanner;

import me.bRosiak.Jednostka;
import me.bRosiak.Magazyn;
import me.bRosiak.Produkt;
import me.sRewilak.Pracownicy;
import me.sRewilak.Pracownik;

/**
 * Klasa odpowiedzialna za logike dzialania programu
 */
public class UI {
    public static Scanner scanner = new Scanner(System.in);
    private final Magazyn magazyn;
    private Klient klient;
    private Pracownik pracownik;
    private Pracownik system;

    /**
     * Konstruktor klasy Hurtownia
     */
    public UI() {
        this.system = new Pracownik("HURTOWNIA", "SYSTEM", String.valueOf(98765));
        this.magazyn = Magazyn.getInstance();
    }

    /**
     * Metoda odpowiedzialna za dzialania programu i odbieranie danych od uzytkownika
     */
    public void run() {
        while (true) {
            System.out.println("Kontynuuj jako:\n1. Klient\n2. Pracownik");
            switch (getInput()) {
                case 1:
                    wyswietlajMenuKlienta();
                    
                    return;
                case 2:
                    wyswietlajMenuPracownika();
                    return;
                default:
                    System.out.println("Niepoprawny wybor!");
                    System.out.println("");
            }
        }

    }

    /**
     * Wyswietla menu klienta
     */
    public void wyswietlMenuKlienta() {
        System.out.println("=====Menu=====");
        System.out.println("1. Przegladaj asortyment");
        System.out.println("2. Przeglądaj koszyk");
        System.out.println("3. Zloz zamowienie");
        System.out.println("0. Wyjdz");
    }

    /**
     * Wyswietl menu pracownika
     */
    public void wyswietlMenuPracownika() {
        System.out.println("=====Menu=====");
        System.out.println("1. Dodaj produkty");
        System.out.println("2. Usun produkty");
        System.out.println("3. Modyfikuj produkty");
        System.out.println("4. Realizuj zamowienie");
        System.out.println("0. Wyjdz");
    }
    


    public void wyswietlajMenuKlienta() {
        klient = new Klient();
        while (true) {
            System.out.print("\033[H\033[2J");
            wyswietlMenuKlienta();
            switch (getInput()) {
                case 1:
                    magazyn.wyswietlAsortyment();
                    break;
                case 2:
                    klient.wyswietlKoszyk();
                    break;
                case 3:
                    klient.zlozZamowienie();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Niepoprawny wybor!");
            }
        }
    }

    public void wyswietlajMenuPracownika() {
        String id;
        do {
            System.out.println("Podaj id pracownika lub wpisz -1 aby wyjsc");
            id = String.valueOf(getInput());
            if (id.equals("-1")) {
                return;
            }
        } while (!Pracownicy.getInstance().getPracownicy().containsKey(id));
        while (true) {
            System.out.print("\033[H\033[2J");
            wyswietlMenuPracownika();
            switch (getInput()) {
                case 1:
                    System.out.println("Podaj nazwe: ");
                    String nazwa = scanner.nextLine();
                    System.out.println("Podaj cene: ");
                    double cena = Double.valueOf(scanner.nextLine());
                    System.out.println("Podaj producenta: ");
                    String producent = scanner.nextLine();
                    System.out.println("Wybierz jednostke: ");
                    System.out.println("1. Metr\n2. Kilogram\n3. Sztuka\n4. Metr Kwadratowy");
                    Jednostka jednostka = null;
                    while (jednostka == null) {
                        switch (getInput()) {
                            case 1:
                                jednostka = Jednostka.Metr;
                                break;
                            case 2:
                                jednostka = Jednostka.Kilogram;
                                break;
                            case 3:
                                jednostka = Jednostka.Sztuka;
                                break;
                            case 4:
                                jednostka = Jednostka.MetrKwadratowy;
                                break;
                            default:
                                System.out.println("Niepoprawny wybor!");
                        }
                    }
                    System.out.println("Podaj ilosc produktu:");
                    int ilosc = Integer.parseInt(scanner.nextLine());
                    Produkt produkt = new Produkt(nazwa, cena, producent, jednostka);
                    magazyn.dodajProdukt(id, produkt, ilosc);
                    break;
                case 2:
                    magazyn.wyswietlAsortyment();
                    break;
                case 3:

                    break;
                case 4:
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Niepoprawny wybor!");
            }
        }
    }

    /*
     * Sprawdza czy podane ID (String) to ID pracownika
     */
    
    public static boolean checkId(String id) {
    	if(Pracownicy.getInstance().getPracownicy()==null || Pracownicy.getInstance().getPracownicy().isEmpty()) return false;
    	return Pracownicy.getInstance().getPracownicy().containsKey(id);
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
