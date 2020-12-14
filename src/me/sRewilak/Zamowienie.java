package me.sRewilak;

import me.jSkiba.Klient;

import java.util.Date;

public class Zamowienie {
    private String idZamowienia;
    private Klient klient;
    private String kraj;
    private String miejscowosc;
    private String ulica;
    private String kodPocztowy;
    private Date data;

    // Konstruktor niezgodny z konstruktorem w diagramie
    Zamowienie(String idZamowienia, Klient klient, String kraj, String miejscowosc,
              String ulica, String kodPocztowy, Date data){
        this.idZamowienia = idZamowienia;
        this.klient = klient;
        this.kraj = kraj;
        this.miejscowosc = miejscowosc;
        this.ulica = ulica;
        this.kodPocztowy = kodPocztowy;
        this.data = data;
    }

    // GETTERY
    public String getIdZamowienia() {
        return idZamowienia;
    }

    public Klient getKlient(){ return klient; }

    public String getKraj() {
        return kraj;
    }

    public String getMiejscowosc() {
        return miejscowosc;
    }

    public String getUlica() {
        return ulica;
    }

    public String getKodPocztowy() {
        return kodPocztowy;
    }

    public Date getData() {
        return data;
    }

}
