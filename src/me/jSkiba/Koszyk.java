package me.jSkiba;

import me.bRosiak.Magazyn;
import me.bRosiak.Produkt;

import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Reprezentuje koszyk klienta
 * @author Jakub Skiba
 */
public class Koszyk implements Serializable {
    private static final long serialVersionUID = 3L;
    private ConcurrentHashMap<Produkt, Integer> produkty;

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

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (object == this) {
            return true;
        }
        if (!(object instanceof Koszyk)) {
            return false;
        }
        Koszyk koszyk = (Koszyk) object;
        return produkty.equals(koszyk.produkty);
    }

    public void wyswietlProdukty() {
        if (produkty.isEmpty()) {
            System.out.println("Twoj koszyk jest pusty.");
        } else {
            System.out.println("====Koszyk====");
            int licznik = 1;
            for (Produkt produkt : produkty.keySet()) {
                System.out.println(licznik);
                System.out.println("\t\tNazwa: " + produkt.getNazwa());
                System.out.println("\t\tProducent: " + produkt.getProducent());
                System.out.println("\t\tIlosc: " + produkty.get(produkt));
                System.out.println("\t\tJednostka: " + produkt.getJednostka());
                System.out.println();
            }
        }
    }
}
