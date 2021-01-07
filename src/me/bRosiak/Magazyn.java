package me.bRosiak;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Magazyn {
	// Singleton instance
	private static final Magazyn INSTANCE = new Magazyn();
	
	private Map<Produkt, Integer> produkty;



	// Zwraca instancje singletona
	public static Magazyn getInstance() {
		return INSTANCE;
	}
	


	// Prywatne konstruktory odkad klasa jest singletonem

	private Magazyn(){
		produkty = new ConcurrentHashMap<>();
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
		
	}

	public void usunProdukt(String idPracownika, Produkt produkt) {
		
	}
	
	public void modyfikujProdukt(String idPracownika, Produkt produkt) {
	
	}
	
	public int getIlosc(Produkt produkt) {
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
			System.out.println(p.getNazwa()+"\t\t\t"+p.getCenaJednostkowa()+"/"+p.getJednostka().toString());
			System.out.println("Producent "+p.getProducent());
		}
	}
	
//	public void usunProdZamowienie(Zamowienie zamowienie) {
//		
//	}
	
	@SuppressWarnings("unused")
	private void setIlosc(Produkt produkt, int ilosc) {
		
	}
	
	@SuppressWarnings("unused")
	private void usunProdukt(Produkt produkt) {
		
	}
	
}
