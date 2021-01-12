package me.sRewilak;

import java.io.Serializable;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class Platnosci implements Serializable {

    //Singleton
    private static final Platnosci INSTANCE = new Platnosci();

    private Map<UUID, Boolean> statusZamowien;


    // Zwraca instancje singletona
    public static Platnosci getInstance() { return INSTANCE; }

    // Singleton - prywatny konstruktor

    private Platnosci() { statusZamowien = new ConcurrentHashMap<>(); }


    // getter - zwraca status zamowienia, o ile znajduje sie w mapie
    public boolean getStatus(UUID IdZamowienia){
        try{
        return this.statusZamowien.get(IdZamowienia);
        }

        catch (NullPointerException e) {
            System.out.println("Blad. Brak zamowienia o podanym ID");
        }
    }
}
