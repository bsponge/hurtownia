import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import me.bRosiak.Jednostka;
import me.bRosiak.Magazyn;
import me.bRosiak.Produkt;
import me.sRewilak.Pracownik;

class MagazynTest {
	
	Pracownik p;
	
	@Before
	public void init() {
		p = new Pracownik("Blazej", "Rosiak", "12345");
	}
	
	@Test
	void testGetInstance() {
		Magazyn store = Magazyn.getInstance();
		Assert.assertNotNull(store);
	}

	@Test
	void testGetIlosc() {
//		fail("Not yet implemented");
		Magazyn store = Magazyn.getInstance();
		Produkt p = new Produkt("Testowy produkt", 12.0, "bRosiak", Jednostka.Kilogram);
		Assert.assertEquals(-1, store.getIlosc(p),0.001);
		store.dodajProdukt("12345", p);
		Assert.assertEquals(1, store.getIlosc(p), 0.001);
	}

	@Test
	void testDodajProduktInt() {
		Magazyn store = Magazyn.getInstance();
		Produkt p = new Produkt("Testowy produkt", 12.0, "bRosiak", Jednostka.Sztuka);
		Assert.assertEquals(-1, store.getIlosc(p),0);
		store.dodajProdukt("12345", p);
		Assert.assertEquals(1, store.getIlosc(p), 0);
	}

	@Test
	void testDodajProduktDouble() {
		Magazyn store = Magazyn.getInstance();
		Produkt p = new Produkt("Testowy produkt", 12.0, "bRosiak", Jednostka.Metr);
		Assert.assertEquals(-1, store.getIlosc(p),0.001);
		store.dodajProdukt("12345", p);
		Assert.assertEquals(1, store.getIlosc(p), 0.001);
	}

	@Test
	void testDodajProduktInt2() {
		Magazyn store = Magazyn.getInstance();
		Produkt p = new Produkt("Testowy produkt", 12.0, "bRosiak", Jednostka.Sztuka);
		Assert.assertEquals(-1, store.getIlosc(p),0);
		store.dodajProdukt("12345", p, 20);
		Assert.assertEquals(20, store.getIlosc(p), 0);
	}

	@Test
	void testDodajProduktDouble2() {
		Magazyn store = Magazyn.getInstance();
		Produkt p = new Produkt("Testowy produkt", 12.0, "bRosiak", Jednostka.Metr);
		Assert.assertEquals(-1, store.getIlosc(p),0.001);
		store.dodajProdukt("12345", p, 12.34);
		Assert.assertEquals(12.34, store.getIlosc(p), 0.001);
	}
	
	@Test
	void testUsunProdukt() {
		Magazyn store = Magazyn.getInstance();
		Produkt p = new Produkt("Testowy produkt", 12.0, "bRosiak", Jednostka.Metr);
		store.dodajProdukt("12345", p, 12.5);
		Assert.assertNotEquals(-1, store.getIlosc(p),0.001);
		store.usunProdukt("12345", p);
		Assert.assertEquals(-1, store.getIlosc(p), 0.001);
	}
	
	@Test
	void testUsunProdukt2() {
		Magazyn store = Magazyn.getInstance();
		Produkt p = new Produkt("Testowy produkt", 12.0, "bRosiak", Jednostka.Metr);
		store.dodajProdukt("12345", p, 12.5);
		Assert.assertNotEquals(-1, store.getIlosc(p),0.001);
		store.usunProdukt("12345", p, 6.25);
		Assert.assertEquals(6.25, store.getIlosc(p), 0.001);
	}
	
}
