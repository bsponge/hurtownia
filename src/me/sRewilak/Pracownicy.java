package me.sRewilak;

import me.FileOperations;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public class Pracownicy {
    private static Map<String, Pracownik> pracownicy = new ConcurrentHashMap<>();
    private static final Pracownicy INSTANCE = new Pracownicy();

    static {
        FileOperations.checkFiles();
        pracownicy = FileOperations.odczytajObiekt(ConcurrentHashMap.class, FileOperations.pracownicy.getAbsolutePath());
        if (pracownicy == null) {
            pracownicy = new ConcurrentHashMap<>();
        }
    }

    private Pracownicy() {
        pracownicy = new ConcurrentHashMap<>();
    }

    public static Pracownicy getInstance() {
        return INSTANCE;
    }

    public Map<String, Pracownik> getPracownicy() {
        return pracownicy;
    }

    public void zapiszPracownikow() {
        FileOperations.checkFiles();
        FileOperations.zapiszObiekt(pracownicy, FileOperations.pracownicy.getAbsolutePath());
    }
}
