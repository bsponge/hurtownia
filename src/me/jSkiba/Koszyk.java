package me.jSkiba;

import me.bRosiak.Magazyn;
import me.bRosiak.Produkt;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Reprezentuje koszyk klienta
 * @author Jakub Skiba
 */
public class Koszyk {
    private Map<Produkt, Integer> produkty;

    /**
     * Tworzy pusty koszyk
     */
    public Koszyk() {
        produkty = new ConcurrentHashMap<>();
    }

    /**
     * Zwraca mape produktow
     * KLUCZ : Produkt
     * WARTOSC : Ilosc produktow
     * @return Mapa z kluczem klasy Produkt i wartoscia klasy Integer reprezentujaca koszyk klienta
     */
    public Map<Produkt, Integer> getProdukty() {
        return produkty;
    }

    /*
    Metoda dodaj i usun produkt musza sprawdzac dostepnosc produktow
    w magazynie i zmieniac stan mapy produktow w koszyku
     */

    /**
     * Dodaje produkt do koszyka w podanej liczbie jednostek
     * @param produkt Produkt, ktory ma zostac dodany do koszyka
     * @param ilosc Ilosc jednostek produktu
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

    /**
     * Usuwa produkt z koszyka
     * @param produkt Produkt, ktory ma zostac usuniety z koszyka
     */
    public void usunProdukt(Produkt produkt) {
        produkty.remove(produkt);
    }
}
