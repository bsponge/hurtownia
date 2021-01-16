package me.sRewilak;
import java.util.Random;

import me.jSkiba.Osoba;

public class Pracownik extends Osoba{
	
    private String idPracownika;

    public Pracownik(String imie, String nazwisko, String id) {
        super(imie, nazwisko);
        this.idPracownika = id;
        // Pracownik zostaje dodany do mapy pracownikow
        Pracownicy.getInstance().getPracownicy().put(idPracownika, this);
    }

    // Getter uzywany do operacji na magazynie
    public String getIdPracownika() {
        return idPracownika;
    }

    public int getLosoweId() {
        Random rand = new Random();
        int toReturn;
        do {
            toReturn = 100000 + rand.nextInt(899999);
        }while(Pracownicy.getInstance().getPracownicy().containsKey(toReturn));
        return toReturn;
    }

	public static void dodajPracownika(String imie, String nazwisko, String id) {
        Pracownik pracownik = new Pracownik(imie, nazwisko, id);
        Pracownicy.getInstance().getPracownicy().put(pracownik.getIdPracownika(), pracownik);
    }
}
