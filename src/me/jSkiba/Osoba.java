package me.jSkiba;

// klasa bazowa dla klasy Klient i Pracownik

import java.io.Serializable;

/**
 * Reprezentuej osobe
 * @author Jakub Skiba
 */
public class Osoba implements Serializable {
    private final String imie;
    private final String nazwisko;

    /**
     * Tworzy osobe z podanym imieniem i nazwiskiem
     * @param imie Imie osoby
     * @param nazwisko Nazwisko osoby
     */
    public Osoba(String imie, String nazwisko) {
        this.imie = imie;
        this.nazwisko = nazwisko;
    }

    /**
     * Zwraca imie osoby
     * @return String reprezentujacy imie osoby
     */
    public String getImie() {
        return imie;
    }

    /**
     * Zwraca nazwisko osoby
     * @return String reprezentujacy nazwisko osoby
     */
    public String getNazwisko() {
        return nazwisko;
    }

}
