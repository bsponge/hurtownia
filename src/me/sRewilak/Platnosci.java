package me.sRewilak;

import java.io.Serializable;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class Platnosci implements Serializable {

    //Singleton
    private static final Platnosci INSTANCE = new Platnosci();

    private Map<UUID, Boolean> statusZamowien;


    // Zwraca instancje singletona
    public static Platnosci getInstance() { return INSTANCE; }

    // Singleton - prywatny konstruktor

    private Platnosci() { statusZamowien = new ConcurrentHashMap<>(); }

}
