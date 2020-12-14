package me.sRewilak;
import me.jSkiba.Koszyk;
import me.jSkiba.Osoba;

public class Pracownik extends Osoba{
    private String idPracownika;


    public Pracownik(String imie, String nazwisko, String id) {
        super(imie, nazwisko);
        this.idPracownika = id;
    }

    // Getter uzywany do operacji na magazynie
    public String getIdPracownika() {
        return idPracownika;
    }
}
