package me.jSkiba;

import me.bRosiak.Magazyn;
import me.bRosiak.Produkt;
import me.sRewilak.Platnosci;
import me.sRewilak.Zamowienia;
import me.sRewilak.Zamowienie;

import java.util.Date;
import java.util.Scanner;

/**
 * Reprezentuje klienta sklepu
 * @author Jakub Skiba
 */
public class Klient extends Osoba {
    private Koszyk koszyk;

    /**
     * Tworzy klienta z podanym imieniem i nazwiskiem
     * @param imie Imie klienta
     * @param nazwisko Nazwisko klienta
     */
    public Klient(String imie, String nazwisko) {
        super(imie, nazwisko);
        this.koszyk = new Koszyk();
    }

    public Klient() {
        this.koszyk = new Koszyk();
    }

    /**
     * Zwraca koszyk klienta
     * @return Koszyk klienta
     */
    public Koszyk getKoszyk() {
        return koszyk;
    }

    /*
    Korzysta z metod klasy Koszyk
     */

    // metoda zwraca true jezeli zamowienie moze zostac zlozone w przeciwnym razie zwraca false

    /**
     * Tworzy obiekt klasy Zamowienie oraz dodaje go do klasy Zamowienia
     * bedacej singletonem jezeli zamowienie jest mozliwe do wykonania
     * @return  true jezeli zamowienie zostalo zlozone poprawnie, w przeciwnym razie zwraca false
     */
    public boolean zlozZamowienie() {
        if (koszyk.getProdukty().isEmpty()) {
            System.out.println("Twoj koszyk jest pusty.");
            return false;
        }
        Magazyn magazyn = Magazyn.getInstance();
        if (magazyn != null) {
            // sprawdzanie czy w magazynie jest wystarczajaca ilosc produktow
            for (Produkt produkt : koszyk.getProdukty().keySet()) {
                if (koszyk.getProdukty().get(produkt) > magazyn.getIlosc(produkt)) {
                    return false;
                }
            }
        }
        try {
            // pobieranie danych do zamowienia
            System.out.println("Podaj imie: ");
            setImie(UI.scanner.nextLine());
            System.out.println("Podaj nazwisko: ");
            setNazwisko(UI.scanner.nextLine());
            System.out.print("Podaj kraj: ");
            String kraj = UI.scanner.nextLine();
            System.out.print("Podaj miejscowosc: ");
            String miejscowosc = UI.scanner.nextLine();
            System.out.print("Podaj ulice: ");
            String ulica = UI.scanner.nextLine();
            System.out.print("Podaj kod pocztowy: ");
            String kodPocztowy = UI.scanner.nextLine();
            System.out.print("Podaj typ platnosci:\n1. Platnosc przelewem.\n2. Platnosc przy odbiorze.");
            int platnosc = UI.scanner.nextInt();

            // tworzenie obiektu klasy Zamowienie i dodawanie go do Zamowienia
            Zamowienie zamowienie = new Zamowienie(this, kraj, miejscowosc, ulica, kodPocztowy, new Date(), koszyk, platnosc);
            koszyk = new Koszyk();

            Zamowienia zamowienia = Zamowienia.getInstance();
            zamowienia.dodajZamowienie(zamowienie);

            // do klasy platnosci dodane jest id zamowienia i typ platnosci
            Platnosci.getInstance().dodajStatus(zamowienie.getIdZamowienia(), platnosc);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    /**
     * Dodaje produkt do koszyka klienta
     * @param produkt Produkt, ktory ma zostac dodany do koszyka
     * @param ilosc Ilosc jednostek produktu
     */
    public void dodajProdukt(Produkt produkt, int ilosc) {
        koszyk.dodajProdukt(produkt, ilosc);
    }

    /**
     * Usuwa produkt z koszyka klienta
     * @param produkt Produkt, ktory ma zostac usuniety z koszyka klienta
     */
    public void usunProdukt(Produkt produkt) {
        koszyk.usunProdukt(produkt);
    }

    public void wyswietlKoszyk() {
        koszyk.wyswietlProdukty();
    }
}
