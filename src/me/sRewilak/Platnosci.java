package me.sRewilak;

import java.io.Serializable;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class Platnosci implements Serializable {

    //Singleton
    private static final Platnosci INSTANCE = new Platnosci();

    /*
    <<<<<<<
     Mapa platnosci. Zamowienie jest reprezentowane przez ID zamowienia.
     Jesli zamowienie jest oplacone przelewem lub przy odbiorze - klucz = true
     w przypadku niezaplaconego zamowienia z przelewem - false
     Iformacje o typie platnosci przechowuje zamowienie
    <<<<<<
    */

    private Map<UUID, Boolean> statusZamowien;


    // Zwraca instancje singletona
    public static Platnosci getInstance() { return INSTANCE; }

    // Singleton - prywatny konstruktor

    private Platnosci() { statusZamowien = new ConcurrentHashMap<>(); }


    public void dodajStatus(UUID IdZamowienia, boolean stan){
        if(!this.statusZamowien.containsKey(IdZamowienia))
            this.statusZamowien.put(IdZamowienia, stan);
        else
            System.out.println("Zamowienie o podanym ID juz dodano do listy platnosci.");
    }
    // getter - zwraca status zamowienia, o ile znajduje sie w mapie
    public boolean getStatus(UUID IdZamowienia){
        try{
        return this.statusZamowien.get(IdZamowienia);
        }

        catch (NullPointerException e) {
            System.out.println("Blad. Brak zamowienia o podanym ID");
            return false;
        }
    }

    public void usunStatus(UUID idZamowienia){
        statusZamowien.remove(idZamowienia);
    }
}
