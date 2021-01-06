package me.jSkiba;

import me.bRosiak.Magazyn;
import me.bRosiak.Produkt;
import me.sRewilak.Zamowienia;
import me.sRewilak.Zamowienie;

import java.util.Date;
import java.util.Scanner;

public class Klient extends Osoba {
    private Koszyk koszyk;

    public Klient(String imie, String nazwisko) {
        super(imie, nazwisko);
        this.koszyk = new Koszyk();
    }

    public Koszyk getKoszyk() {
        return koszyk;
    }

    /*
    Korzysta z metod klasy Koszyk
     */

    // zakladam ze klasa Zamowienia jest singletonem oraz nalezy zmienic dobieranie id zamowienia

    public boolean zlozZamowienie() {
        Magazyn magazyn = Magazyn.getInstance();
        if (magazyn != null) {
            for (Produkt produkt : koszyk.getProdukty().keySet()) {
                if (koszyk.getProdukty().get(produkt) > magazyn.getIlosc(produkt)) {
                    return false;
                }
            }
        }
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Podaj kraj: ");
            String kraj = scanner.nextLine();
            System.out.print("Podaj miejscowosc: ");
            String miejscowosc = scanner.nextLine();
            System.out.print("Podaj ulice: ");
            String ulica = scanner.nextLine();
            System.out.print("Podaj kod pocztowy: ");
            String kodPocztowy = scanner.nextLine();
            Zamowienie zamowienie = new Zamowienie(this, kraj, miejscowosc, ulica, kodPocztowy, new Date());
            Zamowienia zamowienia = Zamowienia.getInstance();
            zamowienia.dodajZamowienie(zamowienie);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public void dodajProdukt(Produkt produkt, int ilosc) {
        koszyk.dodajProdukt(produkt, ilosc);
    }

    public void usunProdukt(Produkt produkt) {
        koszyk.usunProdukt(produkt);
    }
}
