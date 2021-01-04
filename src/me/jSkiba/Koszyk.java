package me.jSkiba;

import me.bRosiak.Magazyn;
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
    public void dodajProdukt(Produkt produkt, int ilosc) {
        Magazyn magazyn = Magazyn.getInstance();
        if (magazyn != null) {
            if (produkt != null) {
                if (magazyn.getIlosc(produkt) >= ilosc) {
                    produkty.put(produkt, ilosc);
                }
            }
        }
    }

    public void zmienIloscProduktow(Produkt produkt, int ilosc) {
        Magazyn magazyn = Magazyn.getInstance();
        if (magazyn != null) {
            if (produkt != null) {
                if (magazyn.getIlosc(produkt) >= ilosc) {
                    produkty.replace(produkt, ilosc);
                }
            }
        }
    }

    public void usunProdukt(Produkt produkt) {
        produkty.remove(produkt);
    }
}
