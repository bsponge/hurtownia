package me;

import java.io.*;

public class FileOperations {
	
	private static File hurtowniaCat = new File("hurtownia");
	private static File pracownicyCat = new File(hurtowniaCat, "pracownicy");
	private static File zamowieniaCat = new File(hurtowniaCat, "zamowienia");
	private static File koszykiCat = new File(hurtowniaCat, "koszyki");
	private static File produktyCat = new File(hurtowniaCat, "produkty");
	private static File pracownicy = new File(pracownicyCat,"pracownicy.txt");
	private static File zamowienia = new File(zamowieniaCat,"zamowienia.txt");
	private static File koszyki = new File(koszykiCat,"koszyki.txt");
	private static File produkty = new File(produktyCat,"produkty.txt");
	
	/*
	 * Metoda checkFiles() sprawdza pliki ustawione jako private
	 * I tworzy je jezeli nie sa utworzone.
	 * Jezeli nie utworzy pliku jakiegos, zwraca false
	 */
	
	public static boolean checkFiles() {
		if(!hurtowniaCat.exists()) {
			hurtowniaCat.mkdir();
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
	
    public static <T> void zapiszObiekt(T obiekt, String nazwaPliku) {
        File file = new File(nazwaPliku);
        try (FileOutputStream fileOutputStream = new FileOutputStream(file);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);) {
            objectOutputStream.writeObject(obiekt);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static <T> T odczytajObiekt(Class<T> cls, String nazwaPliku) {
        File file = new File(nazwaPliku);
        try (FileInputStream fileInputStream = new FileInputStream(file);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            T t = cls.cast(objectInputStream.readObject());
            return t;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
