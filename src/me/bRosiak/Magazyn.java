package me.bRosiak;

import java.io.Serializable;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

import me.FileOperations;
import me.UI;

public class Magazyn implements Serializable {

	private static final long serialVersionUID = -5448347033961279543L;

	// Singleton instance
	private static final Magazyn INSTANCE = new Magazyn();
	
	private Map<Produkt, Double> produkty;

//	static {
//		FileOperations.checkFiles();
//		produkty = FileOperations.odczytajObiekt(ConcurrentHashMap.class, FileOperations.produkty.getAbsolutePath());
//		if (produkty == null) {
//			produkty = new ConcurrentHashMap<>();
//		}
//	}


	// Zwraca instancje singletona
	public static Magazyn getInstance() {
		return INSTANCE;
	}
	


	// Prywatne konstruktory odkad klasa jest singletonem

	@SuppressWarnings("unchecked")
	private Magazyn(){
		produkty = FileOperations.odczytajObiekt(ConcurrentHashMap.class, FileOperations.produkty.getAbsolutePath());
		if (produkty == null) {
			produkty = new ConcurrentHashMap<>();
		}
	}

	/*
  <<<<<<< bRosiakTest
	 * Jezeli mamy juz gotowa liste produktow, to mozemy od razu juz dodadac do magazynu za pomoca tego konstruktora.
	 * !WAZNE!
	 * Konstruktor kopiuje liste produktdow a nie zapisuje jej orginalow.
   =======
	 * Jezeli mamy juz gotowa liste produktow, to mozemy od razu ja dodac do magazynu za pomoca tego konstruktora.
	 * WAZNE *
	 * Konstruktor kopiuje liste produktow a nie zapisuje jej oryginal.
  >>>>>>> main
	 */

//	private Magazyn(Map<Produkt, Integer> produkty){
//		this.produkty = new ConcurrentHashMap<>();
//		for(Produkt p : produkty.keySet())
//			this.produkty.put(new Produkt(p), produkty.get(p));
//	}
	
	/*
	 * Metody dodajProdukt(), usunProdukt(), modyfikujProdukt()
	 * sluza do zarzadzania magazynem przez pracownikow.
	 * Gotowy tylko szkielet.
	 */
	
	public void dodajProdukt(String idPracownika, Produkt produkt) {
		dodajProdukt(idPracownika, produkt, 1);
//		if(!checkId(idPracownika)) {
//			System.out.println("Nieautoryzowany dostep. Odmowa dostepu");
//			return;
//		}
//		if(produkty.containsKey(produkt)) produkty.put(produkt, produkty.get(produkt)+1);
//		else produkty.put(produkt, 1.);
	}
	
	public void dodajProdukt(String idPracownika, Produkt produkt, double ilosc) {
		if(!UI.checkId(idPracownika)) {
			System.out.println("Nieautoryzowany dostep. Odmowa dostepu");
			return;
		}
		if(produkty.containsKey(produkt)) produkty.put(produkt, produkty.get(produkt)+ilosc);
		else produkty.put(produkt, ilosc);
	}

	public void usunProdukt(String idPracownika, Produkt produkt) {
		if(!UI.checkId(idPracownika)) {
			System.out.println("Nieautoryzowany dostep. Odmowa dostepu");
			return;
		}
		if(!produkty.containsKey(produkt))
			throw new NullPointerException("Wskazanego produktu nie ma na liscie");
		produkty.remove(produkt);
	}
	
	public void usunProdukt(String idPracownika, Produkt produkt, double ilosc) {
		if(!UI.checkId(idPracownika)) {
			System.out.println("Nieautoryzowany dostep. Odmowa dostepu");
			return;
		}
		
		if(!produkty.containsKey(produkt))
			throw new NullPointerException("Wskazanego produktu nie ma na liscie");
		if(ilosc >= produkty.get(produkt)) {
			usunProdukt(idPracownika, produkt);
			return;
		}
		
		produkty.put(produkt, produkty.get(produkt)-ilosc);
	}
	
	public void modyfikujProdukt(String idPracownika, Produkt produkt) {
		if(!UI.checkId(idPracownika)) {
			System.out.println("Nieautoryzowany dostep. Odmowa dostepu");
			return;
		}
		
		if(!produkty.containsKey(produkt))
			throw new NullPointerException("Wskazanego produktu nie ma na liscie");
		
		int option;
		double ilosc = produkty.get(produkt);
		usunProdukt(produkt);
		Scanner s = UI.scanner;
		do {
			System.out.println(produkt.getNazwa()+"\t\t\t"+produkt.getCenaJednostkowa()+"/"+produkt.getJednostka().toString());
			System.out.println("Producent "+produkt.getProducent());
			System.out.println("Ilosc: "+ilosc);
			System.out.println("====================");
			System.out.println("1. Zmien nazwe");
			System.out.println("2. Zmien cene jednostkowa");
			System.out.println("3. Zmien ilosc");
			System.out.println("4. Zakoncz edycje");
			option = UI.getInput();
			switch(option) {
				case 1:
					produkt.setNazwa(s.nextLine());
					break;
				case 2:
					try {
						produkt.setCenaJednostkowa(Double.parseDouble(s.nextLine()));
					}catch(NumberFormatException e) {
						
					}
					break;
				case 3:
					try {
						ilosc = Double.parseDouble(s.nextLine());
					}catch(NumberFormatException e) {
						
					}
					break;
				case 4:
					produkty.put(produkt, ilosc);
					return;
			}
		}while(true);
		
	}
	
//	private boolean checkId(String id) {
//		return true;
//	}
	
	public double getIlosc(Produkt produkt) {
		if(!this.produkty.containsKey(produkt)) return -1;
		return this.produkty.get(produkt);
	}
	
	/*
	 * Prototyp metody s﷿u﷿﷿cej do wy﷿wietlania asortymentu.
	 * Du﷿e prawdopodobie﷿stwo na zmiany kosmetyczne.
	 */
	
	public void wyswietlAsortyment() {
		for(Produkt p : this.produkty.keySet()) {
			System.out.println("====================");
			System.out.println(p.getNazwa()+"\t\t\t"+p.getCenaJednostkowa()+"/"+p.getJednostka().nazwa);
			System.out.println("Producent "+p.getProducent());
		}
	}
	
//	public void usunProdZamowienie(Zamowienie zamowienie) {
//		
//	}
	
	@SuppressWarnings("unused")
	private void setIlosc(Produkt produkt, double ilosc) {
		
	}
	
	private void usunProdukt(Produkt produkt) {
		produkty.remove(produkt);
	}

	public void zapiszProdukty() {
		FileOperations.checkFiles();
		FileOperations.zapiszObiekt(produkty, FileOperations.produkty.getAbsolutePath());
	}

	public Produkt znajdzProdukt(String nazwa, String producent) {
		for (Produkt produkt : produkty.keySet()) {
			if (produkt.getNazwa().equalsIgnoreCase(nazwa) && produkt.getProducent().equalsIgnoreCase(producent)) {
				return produkt;
			}
		}
		return null;
	}
}
