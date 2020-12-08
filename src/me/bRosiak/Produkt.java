package me.bRosiak;

import java.io.File;

public class Produkt {

	private String nazwa;
	private double cenaJednostkowa;
	private String producent;
	private Jednostka jednostka;
	
/*
 *Tesetowy konstruktor domyœly wy³¹czony z u¿ytku
 */
//	Produkt(){
//		this.nazwa = null;
//		this.cenaJednostkowa = 0;
//		this.producent = null;
//		this.jednostka = null;
//	}
	
/*
 * Konstuktor, który bêdzie u¿ywany najpewniej domyœlnie do tworzenia produktow
 * Zak³ada pobranie ju¿ wczeœniej danych z plików 
 */
	Produkt(String nazwa, double cenaJednostkowa, String producent, Jednostka jednostka){
		this.nazwa = nazwa;
		this.cenaJednostkowa = cenaJednostkowa;
		this.producent = producent;
		this.jednostka = jednostka;
	}
	
/*
 * Konstuktor dzia³aj¹cy na pliku.
 * Je¿eli nie chcesz mêczyæ siê z weryfikacj¹ danych z plików, u¿yj tego konstruktora.
 * Póki co jest TYLKO szkielet 
 */
	Produkt(File f){
		
	}
	
/*
 * Konstruktor kopiuj¹cy, który jest g³ównie wykorzystywany w magazynie przez jeden z konstruktorów
 * do kopiowania ju¿ istniej¹cej listy produktów.
 */
	
	Produkt(Produkt p){
		this.nazwa = p.nazwa;
		this.cenaJednostkowa = p.cenaJednostkowa;
		this.producent = p.producent;
		this.jednostka = p.jednostka;
	}

//GETTERS//
	
	public String getNazwa() {
		return nazwa;
	}

	public double getCenaJednostkowa() {
		return cenaJednostkowa;
	}

	public String getProducent() {
		return producent;
	}

	public Jednostka getJednostka() {
		return jednostka;
	}

//SETTERS//
	
	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public void setCenaJednostkowa(double cenaJednostkowa) {
		this.cenaJednostkowa = cenaJednostkowa;
	}
	
}
