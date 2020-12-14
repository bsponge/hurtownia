package me.jSkiba;

import me.bRosiak.Produkt;

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
    public void zlozZamowienie() {

    }

    public void dodajProdukt(Produkt produkt) {

    }

    public void usunProdukt(Produkt produkt) {

    }
}
