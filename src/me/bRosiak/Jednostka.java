package me.bRosiak;

import java.io.Serializable;

public enum Jednostka {
	Metr("metr"), Kilogram("kilogram"), Sztuka("sztuka"), MetrKwadratowy("metr kwadratowy");

	public final String nazwa;
	private static final long serialVersionUID = 1L;

	Jednostka(String nazwa) {
	    this.nazwa = nazwa;
	}
}
