import me.bRosiak.Jednostka;
import me.bRosiak.Magazyn;
import me.bRosiak.Produkt;
import me.jSkiba.Koszyk;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;

public class KoszykTest {
    public Koszyk koszyk;
    public Produkt produkt;

    @Before
    public void init() {
        koszyk = new Koszyk();
        produkt = new Produkt("Nazwa", 10.0, "Producent", Jednostka.Kilogram);
    }

    @Test
    public void getProduktyPusteTest() {
        assertTrue("Koszyk ma w sobie produkty, a nie powinien", koszyk.getProdukty().isEmpty());
    }

    @Test
    public void dodajProduktTest() {
        Magazyn magazyn = Magazyn.getInstance();
        // musi zostac dodane przynajmniej 10 produktow
        magazyn.dodajProdukt("123", produkt, 10);
        koszyk.dodajProdukt(produkt, 10);
        assertTrue("Koszyk nie posiada produktu", koszyk.getProdukty().containsKey(produkt));
        assertTrue("Koszyk nie posiada odpowiedniej ilosci produktu", koszyk.getProdukty().get(produkt) == 10);
    }

    @Test
    public void usunProduktTest() {
        koszyk.dodajProdukt(produkt, 4);
        koszyk.usunProdukt(produkt);
        assertFalse("Koszyk posiada produkt po usunieciu", koszyk.getProdukty().containsKey(produkt));
    }
}
