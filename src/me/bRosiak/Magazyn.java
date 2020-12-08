package me.bRosiak;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Magazyn {
	
	private Map<Produkt, Integer> produkty;
	
	/*
	 * Podstawowy konstruktor tworzenia magazynu.
	 * S�u�y w�a�ciwie tylko do stworzenia mapy produkt�w.
	 */
	
	Magazyn(){
		this.produkty = new ConcurrentHashMap<>();
	}
	
	/*
	 * Je�eli mamy ju� gotowa list� produkt�w, to mo�emy od razu j� doda� do magazynu za pomoc� tego konstruktora.
	 * !WA�NE!
	 * Konstruktor kopiuje list� produkt�w a nie zapisuje jej orgina�.
	 */
	
	Magazyn(Map<Produkt, Integer> produkty){
		this.produkty = new ConcurrentHashMap<>();
		for(Produkt p : produkty.keySet())
			this.produkty.put(new Produkt(p), produkty.get(p));
	}
	
	/*
	 * Metody dodajProdukt(), usunProdukt(), modyfikujProdukt()
	 * s�u�� do zarz�dzania magazynem przez pracownik�w.
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
	 * Prototyp metody s�u��cej do wy�wietlania asortymentu.
	 * Du�e prawdopodobie�stwo na zmiany kosmetyczne.
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
