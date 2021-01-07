import org.junit.Assert;
import org.junit.jupiter.api.Test;
import me.bRosiak.Produkt;
import me.bRosiak.Jednostka;
import me.bRosiak.Magazyn;

class MagazynTest {

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
		Assert.assertEquals(-1, store.getIlosc(p));
		store.dodajProdukt("12345", p);
		Assert.assertEquals(1, p);
	}

}
