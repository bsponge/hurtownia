package me.sRewilak;

import me.jSkiba.Hurtownia;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.UUID;

public class Zamowienia implements Serializable {

     //Singleton
     private static final Zamowienia INSTANCE = new Zamowienia();

     private LinkedList<Zamowienie> listaZamowien;


     //Zwraca instancje singletona
     public static Zamowienia getInstance() { return INSTANCE; }


     //Singleton - konstruktor prywatny
     private Zamowienia(){
          this.listaZamowien = new LinkedList<Zamowienie>();
     }

     public void realizujZamowienie(String idPracownika, UUID idZamowienia){
          if(!Hurtownia.checkId(idPracownika)) {
               System.out.println("Nieautoryzowany dostep. Odmowa dostepu");
               return;
          }
     }

     public void wyswietlZamowienia(String idPracownika){
          if(!Hurtownia.checkId(idPracownika)) {
               System.out.println("Nieautoryzowany dostep. Odmowa dostepu");
               return;
          }
          for(int i = 0; i<this.listaZamowien.size(); i++){
              System.out.println("Zamowienie "+(i+1)+". Klient: "+this.listaZamowien.get(i).getKlient().getImie()
              +", "+this.listaZamowien.get(i).getKlient().getNazwisko()+". Data: " + "2020.01.01");
          }

     }

     public void dodajZamowienie(Zamowienie zamowienie){
          listaZamowien.add(zamowienie);
     }

     public void usunZamowienie(UUID idZamowienia){
          // Metoda szuka elementu o podanym iD zamowienia
          // index - zmienna przechowuje index zamowienia o podanym id
          int index = -1;
          for(int i = 0;i<listaZamowien.size();i++){
               if(listaZamowien.get(i).getIdZamowienia()==idZamowienia){
                    index = i;
               }
          }
          if(index!=-1)
               listaZamowien.remove(index);
          else{
               System.out.println("Brak zamowienia o takim id w bazie zamowien.");
               return;
          }
     }

     public LinkedList<Zamowienie> getListaZamowien(){return INSTANCE.listaZamowien;}

}
