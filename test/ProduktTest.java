import org.junit.Assert;
import org.junit.jupiter.api.Test;

import me.bRosiak.Jednostka;
import me.bRosiak.Produkt;

class ProduktTest {

	Produkt p = new Produkt("Test", 12.59, "bRosiak", Jednostka.Sztuka);
	
	@Test
	void testGetNazwa() {
//		fail("Not yet implemented");
		Assert.assertEquals("Test", p.getNazwa());
	}

	@Test
	void testGetCenaJednostkowa() {
//		fail("Not yet implemented");
		Assert.assertEquals(12.59, p.getCenaJednostkowa(), 0.01);;
	}

	@Test
	void testGetProducent() {
//		fail("Not yet implemented");
		Assert.assertEquals("bRosiak", p.getProducent());
	}

	@Test
	void testGetJednostka() {
//		fail("Not yet implemented");
		Assert.assertEquals(Jednostka.Sztuka, p.getJednostka());
	}

}
