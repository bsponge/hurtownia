package me.sRewilak;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class Zamowienia {

     //Singleton
     private static final Zamowienia INSTANCE = new Zamowienia();

     private LinkedList<Zamowienie> listaZamowien;


     //Zwraca instancje singletona
     public static Zamowienia getInstance() {
          return INSTANCE;
     }


     //Singleton - konstruktor prywatny
     private Zamowienia(){
          this.listaZamowien = new LinkedList<Zamowienie>();
     }

     public void realizujZamowienie(String idPracownika, String idZamowienia){

     }

     public void wyswietlZamowienia(String idPracownika){

     }

     public void dodajZamowienie(Zamowienie zamowienie){
          listaZamowien.add(zamowienie);
     }

     public void usunZamowienie(UUID idZamowienia){
         
     }

     public LinkedList<Zamowienie> getListaZamowien(){return INSTANCE.listaZamowien;}

}
