package me.sRewilak;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public class Pracownicy {
    private static Map<String, Pracownik> pracownicy = new ConcurrentHashMap<>();
    private static final Pracownicy INSTANCE = new Pracownicy();

    private Pracownicy() {
        pracownicy = new ConcurrentHashMap<>();
    }

    public static Pracownicy getInstance() {
        return INSTANCE;
    }

    public Map<String, Pracownik> getPracownicy() {
        return pracownicy;
    }
}
