package me;

import java.io.*;

/**
 * Ulatwia zapisywanie i wczytywanie obiektow klas impelementujacych interfejs Serializable z plikow
 */
public class FileOperations {
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
