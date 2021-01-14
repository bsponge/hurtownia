package me.sRewilak;

import me.jSkiba.Hurtownia;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class Zamowienia implements Serializable {

     //Singleton
     private static final Zamowienia INSTANCE = new Zamowienia();

     private Map<UUID,Zamowienie> listaZamowien;


     //Zwraca instancje singletona
     public static Zamowienia getInstance() { return INSTANCE; }


     //Singleton - konstruktor prywatny
     private Zamowienia(){
          this.listaZamowien = new ConcurrentHashMap<>();
     }

     public void realizujZamowienie(String idPracownika, UUID idZamowienia){
          if(!Hurtownia.checkId(idPracownika)) {
               System.out.println("Nieautoryzowany dostep. Odmowa dostepu");
               return;
          }
          usunZamowienie(idZamowienia);
     }

     public void wyswietlZamowienia(String idPracownika){
          if(!Hurtownia.checkId(idPracownika)) {
               System.out.println("Nieautoryzowany dostep. Odmowa dostepu");
               return;
          }

          int i = 0;

          for(Map.Entry<UUID, Zamowienie> entry: listaZamowien.entrySet()){
              System.out.println("Zamowienie "+(i+1)+". Klient: "+ entry.getValue().getKlient().getImie()
              +", "+ entry.getValue().getKlient().getNazwisko()+". Data: " + "2020.01.01");
          }

     }

     public void dodajZamowienie(Zamowienie zamowienie){
          listaZamowien.put(zamowienie.getIdZamowienia(),zamowienie);
     }

     public void usunZamowienie(UUID idZamowienia){
          // Metoda usuwa zamowienie o podanym ID z mapy
          // jesli zamowienie o podanym ID nie ma w mapie - zglasza blad

          if(listaZamowien.containsKey(idZamowienia))
               listaZamowien.remove(idZamowienia);
          else{
               System.out.println("Brak zamowienia o takim id w bazie zamowien.");
               return;
          }
     }

     public Map<UUID,Zamowienie> getListaZamowien(){return INSTANCE.listaZamowien;}

}
