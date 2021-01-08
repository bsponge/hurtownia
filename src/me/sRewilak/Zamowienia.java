package me.sRewilak;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class Zamowienia {

     //Singleton
     private static final Zamowienia INSTANCE = new Zamowienia();

     private LinkedList<Zamowienie> listaZamowien;


     //Zwraca instancje singletona
     public static Zamowienia getInstance() { return INSTANCE; }


     //Singleton - konstruktor prywatny
     private Zamowienia(){
          this.listaZamowien = new LinkedList<Zamowienie>();
     }

     public void realizujZamowienie(String idPracownika, String idZamowienia){

     }

     public void wyswietlZamowienia(String idPracownika){
          for(int i = 0; i<this.listaZamowien.size(); i++){
              System.out.print("Zamowienie "+(i+1)+". Klient: "+this.listaZamowien.get(i).getKlient().getImie()
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
