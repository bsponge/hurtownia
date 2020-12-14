package me.jSkiba;

// klasa bazowa dla klasy Klient i Pracownik
public class Osoba {
    private final String imie;
    private final String nazwisko;

    public Osoba(String imie, String nazwisko) {
        this.imie = imie;
        this.nazwisko = nazwisko;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }
}
