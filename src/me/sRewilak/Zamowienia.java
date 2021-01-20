package me.sRewilak;

import me.FileOperations;
import me.UI;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class Zamowienia implements Serializable {
     private static final long serialVersionUID = 4L;

     //Singleton
     private static final Zamowienia INSTANCE = new Zamowienia();

     private ConcurrentHashMap<UUID,Zamowienie> zamowienia;

//     static {
//          FileOperations.checkFiles();
//          zamowienia = FileOperations.odczytajObiekt(ConcurrentHashMap.class, FileOperations.zamowienia.getAbsolutePath());
//          if (zamowienia == null) {
//               zamowienia = new ConcurrentHashMap<>();
//          }
//     }


     //Zwraca instancje singletona
     public static Zamowienia getInstance() { return INSTANCE; }


     //Singleton - konstruktor prywatny
    @SuppressWarnings("unchecked")
	private Zamowienia(){
    	 zamowienia = FileOperations.odczytajObiekt(ConcurrentHashMap.class, FileOperations.zamowienia.getAbsolutePath());
         if (zamowienia == null) {
              zamowienia = new ConcurrentHashMap<>();
         }
//          this.zamowienia = new ConcurrentHashMap<>();
     }

     public void realizujZamowienie(String idPracownika, UUID idZamowienia){

          if(!UI.checkId(idPracownika)) {
               System.out.println("Nieautoryzowany dostep. Odmowa dostepu");
               return;
          }
          if(zamowienia.containsKey(idZamowienia)) {
               /*
               obsluga zamowienia z przelewem (typ platnosci == 1) ->> zamowienie oplacone
               */
               if(zamowienia.get(idZamowienia).getTypPlatnosci()==1 && Platnosci.getInstance().getStatus(idZamowienia) == true) {
                    System.out.println("Zamowienie przelewem oplacone. Gdy zamowienie zostanie wyslane, wybierz 1.");
                    int wybor = UI.scanner.nextInt();
                    // po zakonczeniu procedury dla opcji 1 zakoncz funkcje i usun zamowienia z map
                    if (wybor == 1) {
                         usunZamowienie(idZamowienia);
                         Platnosci.getInstance().usunStatus(idZamowienia);
                         return;
                    }
               }
               /*
               Przypadek dla zamowienia przelewem, ale gdy nie jest oplacone
                */
               else if(zamowienia.get(idZamowienia).getTypPlatnosci()==1&&Platnosci.getInstance().getStatus(idZamowienia) == false){
                    System.out.println("Zamowienie nie zostalo oplacone. Nie mozna zrealizowac zamowienia.");
                    return;
               }

               /*
               Przypadek dla zamowienia z platnoscia przy odbiorze => zamowienie rownoznaczne z oplaconym
                */

               else if(zamowienia.get(idZamowienia).getTypPlatnosci()==2){
                    System.out.println("Zamowienie z platnoscia przy odbiorze. Gdy zamowienie zostanie wyslane, wybierz 1.");
                    int wybor = UI.scanner.nextInt();
                    // po zakonczeniu procedury dla opcji 1 zakoncz funkcje i usun zamowienia z map
                    if (wybor == 1) {
                         usunZamowienie(idZamowienia);
                         Platnosci.getInstance().usunStatus(idZamowienia);
                         return;
                    }
               }
          }
          // Gdy nie ma zamowienia o podanym ID zamowienia
          else {
               System.out.println("Nie mozna zrealizowac zamowienia - Brak zamowienia o podanym ID w bazie zamowien.");
               return;
          }
     }

     public void wyswietlZamowienia(String idPracownika){
          if(!UI.checkId(idPracownika)) {
               System.out.println("Nieautoryzowany dostep. Odmowa dostepu");
               return;
          }

          if(getListaZamowien().isEmpty()) {
               System.out.println("Brak dostepnych zamowien.");
               return;
          }
          // Mapa zamowien skonwertowana na liste w celu wyswietlenia zamowien
          LinkedList<Zamowienie> listaKonwert= new LinkedList<>(zamowienia.values());

          int i = 1;

          // Metoda wyswietla ostatnie 15 zamowien
          System.out.println("Ostatnie 15 zamowien:");
          for(Zamowienie zamowienie : listaKonwert){
               if(i>15)
                    break;
              System.out.println("Zamowienie "+(i)+". Klient: "+ zamowienie.getKlient().getImie()
              +", "+ zamowienie.getKlient().getNazwisko()+". Data: " + zamowienie.getData() + ". UUID: " + zamowienie.getIdZamowienia());
              i++;
          }

     }

     public void dodajZamowienie(Zamowienie zamowienie){
          zamowienia.put(zamowienie.getIdZamowienia(), zamowienie);
     }

     public void usunZamowienie(UUID idZamowienia){
          // Metoda usuwa zamowienie o podanym ID z mapy
          // jesli zamowienie o podanym ID nie ma w mapie - zglasza blad

          if(zamowienia.containsKey(idZamowienia))
               zamowienia.remove(idZamowienia);
          else{
               System.out.println("Brak zamowienia o takim id w bazie zamowien.");
               return;
          }
     }

     public Map<UUID,Zamowienie> getListaZamowien(){return this.zamowienia;}

     public void zapiszZamowienia() {
          FileOperations.checkFiles();
          FileOperations.zapiszObiekt(zamowienia, FileOperations.zamowienia.getAbsolutePath());
     }
}
