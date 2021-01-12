package me.sRewilak;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import me.jSkiba.Osoba;

public class Pracownik extends Osoba{
	
	private static Map<String, Pracownik> pracownicy = new ConcurrentHashMap<>();
    private String idPracownika;

    public Pracownik(String imie, String nazwisko, String id) {
        super(imie, nazwisko);
        this.idPracownika = id;
        // Pracownik zostaje dodany do mapy pracownikow
        pracownicy.put(idPracownika, this);
    }

    // Getter uzywany do operacji na magazynie
    public String getIdPracownika() {
        return idPracownika;
    }

	public static Map<String, Pracownik> getPracownicy() {
		return pracownicy;
	}

	// metoda pomocnicza do testow
	public static void dodajPracownika(String imie, String nazwisko, String id) {
        Pracownik pracownik = new Pracownik(imie, nazwisko, id);
        pracownicy.put(pracownik.getIdPracownika(), pracownik);
    }
}
