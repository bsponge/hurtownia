package me;

import java.util.Scanner;
import java.util.UUID;

import me.bRosiak.Jednostka;
import me.bRosiak.Magazyn;
import me.bRosiak.Produkt;
import me.jSkiba.Klient;
import me.sRewilak.Platnosci;
import me.sRewilak.Pracownicy;
import me.sRewilak.Zamowienia;

/**
 * Klasa odpowiedzialna za logike dzialania programu
 */
public class UI {
    public static Scanner scanner = new Scanner(System.in);
    private final Magazyn magazyn;
    private final Pracownicy pracownicy;
    private final Zamowienia zamowienia;
    private final Platnosci platnosci;
    private Klient klient;
//    private Pracownik pracownik;
//    private Pracownik system;

    /**
     * Konstruktor klasy Hurtownia
     */
    public UI() {
    	FileOperations.checkFiles();
//        this.system = new Pracownik("HURTOWNIA", "SYSTEM", String.valueOf(98765));
        this.magazyn = Magazyn.getInstance();
        this.pracownicy = Pracownicy.getInstance();
        this.zamowienia = Zamowienia.getInstance();
        this.platnosci = Platnosci.getInstance();
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
                    magazyn.zapiszProdukty();
                    zamowienia.zapiszZamowienia();
                    pracownicy.zapiszPracownikow();
                    platnosci.zapiszPlatnosci();
                    return;
                case 2:
                    wyswietlajMenuPracownika();
                    magazyn.zapiszProdukty();
                    zamowienia.zapiszZamowienia();
                    pracownicy.zapiszPracownikow();
                    platnosci.zapiszPlatnosci();
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
        System.out.println("2. Dodaj produkt do koszyka");
        System.out.println("3. Przeglądaj koszyk");
        System.out.println("4. Zloz zamowienie");
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
        System.out.println("4. Przegladaj zamowienia");
        System.out.println("5. Realizuj zamowienie");
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
                    System.out.println("Podaj nazwe produktu: ");
                    System.out.print("> ");
                    String nazwa = scanner.nextLine();
                    System.out.println("Podaj producenta: ");
                    System.out.print("> ");
                    String producent = scanner.nextLine();
                    Produkt produkt = magazyn.znajdzProdukt(nazwa, producent);
                    if (produkt != null) {
                        System.out.println("Podaj ilosc produktu: ");
                        System.out.print("> ");
                        int ilosc = Integer.parseInt(scanner.nextLine());
                        klient.dodajProdukt(produkt, ilosc);
                    } else {
                        System.out.println("Nie znaleziono takiego produktu");
                    }
                    break;
                case 3:
                    klient.wyswietlKoszyk();
                    break;
                case 4:
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
        String nazwa;
        String producent;
        while (true) {
            System.out.print("\033[H\033[2J");
            wyswietlMenuPracownika();
            switch (getInput()) {
                case 1:
                    System.out.println("Podaj nazwe: ");
                    System.out.print("> ");
                    nazwa = scanner.nextLine();
                    System.out.println("Podaj cene: ");
                    System.out.print("> ");
                    double cena = Double.valueOf(scanner.nextLine());
                    System.out.println("Podaj producenta: ");
                    System.out.print("> ");
                    producent = scanner.nextLine();
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
                    System.out.print("> ");
                    int ilosc = Integer.parseInt(scanner.nextLine());
                    Produkt produkt = new Produkt(nazwa, cena, producent, jednostka);
                    magazyn.dodajProdukt(id, produkt, ilosc);
                    break;
                case 2:
                    System.out.println("Podaj nazwe: ");
                    System.out.print("> ");
                    nazwa = scanner.nextLine();
                    System.out.println("Podaj producenta: ");
                    System.out.print("> ");
                    producent = scanner.nextLine();
                    Produkt p = magazyn.znajdzProdukt(nazwa, producent);
                    if (p != null) {
                        magazyn.usunProdukt(id, p);
                    } else {
                        System.out.println("Nie znaleziono takiego produktu");
                    }
                    break;
                case 3:
                    System.out.println("Podaj nazwe: ");
                    System.out.print("> ");
                    nazwa = scanner.nextLine();
                    System.out.println("Podaj producenta: ");
                    System.out.print("> ");
                    producent = scanner.nextLine();
                    Produkt p1 = magazyn.znajdzProdukt(nazwa, producent);
                    if (p1 != null) {
                        magazyn.modyfikujProdukt(id, p1);
                    } else {
                        System.out.println("Nie znaleziono takiego produktu");
                    }
                    break;
                case 4:
                    zamowienia.wyswietlZamowienia(id);
                    break;
                case 5:
                    System.out.println("Podaj ID zamowienia: ");
                    System.out.print("> ");
                    try {
                        UUID uuid = UUID.fromString(scanner.nextLine());
                        System.out.println(uuid);
                        zamowienia.realizujZamowienie(id, uuid);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Niepoprawne id");
                    }
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
