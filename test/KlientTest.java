import me.bRosiak.Jednostka;
import me.bRosiak.Magazyn;
import me.bRosiak.Produkt;
import me.jSkiba.Klient;
import me.jSkiba.Koszyk;
import me.sRewilak.Zamowienia;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.*;

public class KlientTest {
    public Klient klient;
    public Produkt produkt;
    public Magazyn magazyn;
    public Zamowienia zamowienia;

    @Before
    public void init() {
        klient = new Klient("Imie", "Nazwisko");
        produkt = new Produkt("Nazwa", 10.0, "Producent", Jednostka.Kilogram);
        magazyn = Magazyn.getInstance();
        zamowienia = Zamowienia.getInstance();
    }

    @Test
    public void getKoszykTest() {
        assertEquals(klient.getKoszyk(), new Koszyk());
    }


    // test wymaga poprawnego dzialania metody dodajProdukt klasy Klient
    @Test
    public void zlozPoprawneZamowienieTest() {
        InputStream sysInBackup = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream(("Kraj"
                + System.lineSeparator()
                + "Miejscowosc"
                + System.lineSeparator()
                + "Ulica"
                + System.lineSeparator()
                + "Kod"
                + System.lineSeparator()).getBytes());
        System.setIn(in);

        magazyn.dodajProdukt("ID", produkt, 10);
        klient.dodajProdukt(produkt, 5);
        assertTrue(klient.zlozZamowienie());

        System.setIn(sysInBackup);
    }

    @Test
    public void zlozNiepoprawneZamowienieTest() {
        InputStream sysInBackup = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream(("Kraj"
                + System.lineSeparator()
                + "Miejscowosc"
                + System.lineSeparator()
                + "Ulica"
                + System.lineSeparator()
                + "Kod"
                + System.lineSeparator()).getBytes());
        System.setIn(in);

        magazyn.dodajProdukt("ID", produkt, 10);
        klient.dodajProdukt(produkt, 10);
        magazyn.modyfikujProdukt("ID", produkt);
        assertFalse(klient.zlozZamowienie());

        System.setIn(sysInBackup);
    }

    @Test
    public void dodajProduktTest() {
        // nalezy dodac ile produktow ma zostac dodane do magazynu
        magazyn.dodajProdukt("123", produkt, 5);
        klient.dodajProdukt(produkt, 5);
        assertTrue("Koszyk klienta nie zawiera produktu",
                klient.getKoszyk().getProdukty().containsKey(produkt));
        assertTrue("Koszyk nie zawiera odpowiedniej ilosci produktu",
                klient.getKoszyk().getProdukty().get(produkt) == 5);
    }

    @Test
    public void usunProduktTest() {
        // nalezy dodac ile produtkow ma zostac dodane do magazynu
        magazyn.dodajProdukt("123", produkt);
        klient.dodajProdukt(produkt, 10);
        klient.usunProdukt(produkt);
        assertFalse("Koszyk klienta posiada produkt pomimo usuniecia go",
                klient.getKoszyk().getProdukty().containsKey(produkt));
    }
}
