package me;

import java.io.*;

public class FileOperations {
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
