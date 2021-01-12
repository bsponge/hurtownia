package me.jSkiba;

import me.bRosiak.Magazyn;
import me.bRosiak.Produkt;
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
        Magazyn magazyn = Magazyn.getInstance();
        if (magazyn != null) {
            // sprawdzanie czy w magazynie jest wystarczajaca ilosc produktow
            for (Produkt produkt : koszyk.getProdukty().keySet()) {
                if (koszyk.getProdukty().get(produkt) > magazyn.getIlosc(produkt)) {
                    return false;
                }
            }
        }
        try (Scanner scanner = new Scanner(System.in)) {
            // pobieranie danych do zamowienia
            System.out.print("Podaj kraj: ");
            String kraj = Hurtownia.scanner.nextLine();
            System.out.print("Podaj miejscowosc: ");
            String miejscowosc = Hurtownia.scanner.nextLine();
            System.out.print("Podaj ulice: ");
            String ulica = Hurtownia.scanner.nextLine();
            System.out.print("Podaj kod pocztowy: ");
            String kodPocztowy = Hurtownia.scanner.nextLine();

            // tworzenie obiektu klasy Zamowienie i dodawanie go do Zamowienia
            Zamowienie zamowienie = new Zamowienie(this, kraj, miejscowosc, ulica, kodPocztowy, new Date(), koszyk);

            Zamowienia zamowienia = Zamowienia.getInstance();
            zamowienia.dodajZamowienie(zamowienie);
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
}
