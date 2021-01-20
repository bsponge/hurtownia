package me.bRosiak;

import java.io.Serializable;

public class Produkt implements Serializable {
	private static final long serialVersionUID = 2L;

	private String nazwa;
	private double cenaJednostkowa;
	private String producent;
	private Jednostka jednostka;
	
/*
 *Tesetowy konstruktor domy�ly wy��czony z u�ytku
 */
//	Produkt(){
//		this.nazwa = null;
//		this.cenaJednostkowa = 0;
//		this.producent = null;
//		this.jednostka = null;
//	}
	
/*
 * Konstuktor, kt�ry b�dzie u�ywany najpewniej domy�lnie do tworzenia produktow
 * Zak�ada pobranie ju� wcze�niej danych z plik�w 
 */
	public Produkt(String nazwa, double cenaJednostkowa, String producent, Jednostka jednostka){
		this.nazwa = nazwa;
		this.cenaJednostkowa = cenaJednostkowa;
		this.producent = producent;
		this.jednostka = jednostka;
	}
	
/*
 * Konstuktor dzia�aj�cy na pliku.
 * Je�eli nie chcesz m�czy� si� z weryfikacj� danych z plik�w, u�yj tego konstruktora.
 * P�ki co jest TYLKO szkielet 
 * Obecnie wylaczonyn z uzytku
 */
//	public Produkt(File f){
//		
//	}
	
/*
 * Konstruktor kopiuj�cy, kt�ry jest g��wnie wykorzystywany w magazynie przez jeden z konstruktor�w
 * do kopiowania ju� istniej�cej listy produkt�w.
 */
	
	public Produkt(Produkt p){
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
