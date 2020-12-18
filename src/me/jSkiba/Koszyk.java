package me.jSkiba;

import me.bRosiak.Produkt;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Koszyk {
    private Map<Produkt, Integer> produkty;

    public Koszyk() {
        produkty = new ConcurrentHashMap<>();
    }

    public Map<Produkt, Integer> getProdukty() {
        return produkty;
    }

    /*
    Metoda dodaj i usun produkt musza sprawdzac dostepnosc produktow
    w magazynie i zmieniac stan mapy produktow w koszyku
     */
    public void dodaj(Produkt produkt, int ilosc) {

    }

    public void usun(Produkt produkt) {

    }
}
