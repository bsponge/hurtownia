package me.sRewilak;

import me.bRosiak.Produkt;
import me.jSkiba.Klient;
import me.jSkiba.Koszyk;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

public class Zamowienie {
    private UUID idZamowienia;
    private Klient klient;
    private String kraj;
    private String miejscowosc;
    private String ulica;
    private String kodPocztowy;
    private Date data;
    private Map<Produkt, Integer> produkty;


    public Zamowienie(Klient klient, String kraj, String miejscowosc,
                      String ulica, String kodPocztowy, Date data, Koszyk koszyk){
        this.idZamowienia = UUID.randomUUID();
        this.klient = klient;
        this.kraj = kraj;
        this.miejscowosc = miejscowosc;
        this.ulica = ulica;
        this.kodPocztowy = kodPocztowy;
        this.data = data;
        /*
        Konstruktor kopiuje mape przekazana w konstruktorze
        Zamowienie kopiuje wszystkie produkty dodane przez klienta do koszyka
        */

        this.produkty = koszyk.getProdukty();
    }

    // GETTERY
    public UUID getIdZamowienia() {
        return idZamowienia;
    }

    public Klient getKlient(){
        return klient;
    }

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
