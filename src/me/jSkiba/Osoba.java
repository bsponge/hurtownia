package me.jSkiba;

// klasa bazowa dla klasy Klient i Pracownik

import java.io.Serializable;

/**
 * Reprezentuej osobe
 * @author Jakub Skiba
 */
public class Osoba implements Serializable {

	private static final long serialVersionUID = -2738270539038195943L;
	private String imie;
    private String nazwisko;

    /**
     * Tworzy osobe z podanym imieniem i nazwiskiem
     * @param imie Imie osoby
     * @param nazwisko Nazwisko osoby
     */
    public Osoba(String imie, String nazwisko) {
        this.imie = imie;
        this.nazwisko = nazwisko;
    }

    public Osoba() {

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

    public void setImie(String imie) {
        this.imie = imie;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }
}
