package me;

import java.io.*;

/**
 * Ulatwia zapisywanie i wczytywanie obiektow klas impelementujacych interfejs Serializable z plikow
 */
public class FileOperations {
	
	public static File hurtowniaCat = new File("hurtownia");
	public static File pracownicyCat = new File(hurtowniaCat, "pracownicy");
	public static File zamowieniaCat = new File(hurtowniaCat, "zamowienia");
	public static File platnosciCat = new File(hurtowniaCat, "platnosci");
	public static File platnosci = new File(platnosciCat, "platnosci");
	public static File koszykiCat = new File(hurtowniaCat, "koszyki");
	public static File produktyCat = new File(hurtowniaCat, "produkty");
	public static File pracownicy = new File(pracownicyCat,"pracownicy");
	public static File zamowienia = new File(zamowieniaCat,"zamowienia");
	public static File koszyki = new File(koszykiCat,"koszyki");
	public static File produkty = new File(produktyCat,"produkty");
	
	/*
	 * Metoda checkFiles() sprawdza pliki ustawione jako private
	 * I tworzy je jezeli nie sa utworzone.
	 * Jezeli nie utworzy pliku jakiegos, zwraca false
	 */
	
	public static boolean checkFiles() {
		if(!hurtowniaCat.exists()) {
			hurtowniaCat.mkdir();
		}

		if (!platnosciCat.exists()) {
			platnosciCat.mkdir();
		}

		if(!pracownicyCat.exists()) {
			pracownicyCat.mkdir();
		}
		if(!zamowieniaCat.exists()) {
			zamowieniaCat.mkdir();
		}
		if(!koszykiCat.exists()) {
			koszykiCat.mkdir();
		}
		if(!produktyCat.exists()) {
			produktyCat.mkdir();
		}

		if(!platnosci.exists()) {
			try {
				platnosci.createNewFile();
			} catch (IOException e) {
				System.out.println("Blad przy tworzeniu pliku pracownicy:");
				System.out.println(e.getMessage());
				return false;
			}
		}
		
		if(!pracownicy.exists()) {
			try {
				pracownicy.createNewFile();
			} catch (IOException e) {
				System.out.println("Blad przy tworzeniu pliku pracownicy:");
				System.out.println(e.getMessage());
				return false;
			}
		}
		
		if(!zamowienia.exists()) {
			try {
				zamowienia.createNewFile();
			}catch(IOException e) {
				System.out.println("Blad przy tworzeniu pliku zamowienia:");
				System.out.println(e.getMessage());
				return false;
			}
		}
		
		if(!koszyki.exists()) {
			try {
				koszyki.createNewFile();
			}catch(IOException e) {
				System.out.println("Blad przy tworzeniu pliku koszyki:");
				System.out.println(e.getMessage());
				return false;
			}
		}
		
		if(!produkty.exists()) {
			try {
				produkty.createNewFile();
			}catch(IOException e) {
				System.out.println("Blad przy tworzeniu pliku zamowienia:");
				System.out.println(e.getMessage());
				return false;
			}
		}
		
		return true;
		
	}
	
    /**
     * Metoda statyczna. Zapisuje obiekt w pliku o nazwie nazwaPliku
     * @param obiekt Obiekt ktory ma zostac zapisany w pliku. Musi implementowac interfejs Serializable
     * @param nazwaPliku Nazwa pliku w ktorym zapisany ma zostac obiekt
     * @param <T> Typ zapisywanego obiektu
     */
  
    public static <T> void zapiszObiekt(T obiekt, String nazwaPliku) {
        File file = new File(nazwaPliku);
        try (FileOutputStream fileOutputStream = new FileOutputStream(file);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);) {
            objectOutputStream.writeObject(obiekt);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Metoda statyczna. Odczytuje obiekt danego typu z pliku o nazwie nazwaPliku
     * @param cls Uzywany do rzutowania obiektu pobranego z pliku np. jesli pobierany jest String to argument cls powinien byc String.class
     * @param nazwaPliku Nazwa pliku, z ktorego pobrany ma zostac obiekt
     * @param <T> Typ obiektu zapisanego w pliku oraz typ zwracany przez metode
     * @return Obiekt przechowywany w pliku typu T lub null jezeli wystapi wyjatek
     */
    public static <T> T odczytajObiekt(Class<T> cls, String nazwaPliku) {
        File file = new File(nazwaPliku);
        if (file.exists()) {
        	if (file.length() != 0) {
				try (FileInputStream fileInputStream = new FileInputStream(file);
					 ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
					T t = cls.cast(objectInputStream.readObject());
					return t;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

        return null;
    }
}
