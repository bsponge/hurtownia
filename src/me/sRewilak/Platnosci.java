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


    // Metoda uzywana przy skladaniu zamowienia
    // Dodawane jest ID zamowienia ze statusem platnosci
    public void dodajStatus(UUID IdZamowienia, int typPlatnosci){
        boolean stan;
        if(!this.statusZamowien.containsKey(IdZamowienia)) {
            // Jezeli platnosc jest przelewem - czyli pole stan == 1,
            // platnosc jest niezrealizowana najpierw, wiec status platnosci == false
            if(typPlatnosci == 1)
                stan = false;

            //Gdy platnosc == 2 -> zamowienie jest "oplacone", bo platnosc przy odbiorze
            else
                stan = true;
            this.statusZamowien.put(IdZamowienia, stan);
        }

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

    // Status zostaje usuniety po realizacji zamowienia
    public void usunStatus(UUID idZamowienia){
        statusZamowien.remove(idZamowienia);
    }

    public void setStatus(UUID idZamowienia, boolean stan) { this.statusZamowien.put(idZamowienia,stan); }
}
