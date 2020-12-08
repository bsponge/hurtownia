package me.bRosiak;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Magazyn {
	
	private Map<Produkt, Integer> produkty;
	
	/*
	 * Podstawowy konstruktor tworzenia magazynu.
	 * S³u¿y w³aœciwie tylko do stworzenia mapy produktów.
	 */
	
	Magazyn(){
		this.produkty = new ConcurrentHashMap<>();
	}
	
	/*
	 * Je¿eli mamy ju¿ gotowa listê produktów, to mo¿emy od razu j¹ dodaæ do magazynu za pomoc¹ tego konstruktora.
	 * !WA¯NE!
	 * Konstruktor kopiuje listê produktów a nie zapisuje jej orgina³.
	 */
	
	Magazyn(Map<Produkt, Integer> produkty){
		this.produkty = new ConcurrentHashMap<>();
		for(Produkt p : produkty.keySet())
			this.produkty.put(new Produkt(p), produkty.get(p));
	}
	
	/*
	 * Metody dodajProdukt(), usunProdukt(), modyfikujProdukt()
	 * s³u¿¹ do zarz¹dzania magazynem przez pracowników.
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
	 * Prototyp metody s³u¿¹cej do wyœwietlania asortymentu.
	 * Du¿e prawdopodobieñstwo na zmiany kosmetyczne.
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
