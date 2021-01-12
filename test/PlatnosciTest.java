import me.jSkiba.Klient;
import me.jSkiba.Koszyk;
import me.sRewilak.Platnosci;
import me.sRewilak.Zamowienie;
import org.junit.Before;
import org.junit.Test;
import me.sRewilak.Platnosci;

import java.util.Date;

import static org.junit.Assert.*;


public class PlatnosciTest {
    public Platnosci platnosci;
    public Zamowienie zamowienie;
    public Klient klient;
    public Koszyk koszyk;

    @Before
    public void init(){
        klient = new Klient("Imie", "Nazwisko");
        koszyk = new Koszyk();
        platnosci = platnosci.getInstance();
        zamowienie = new Zamowienie(klient, "Kraj", "Miejscowosc", "Ulica", "Kod",
                new Date(2020,01,01), koszyk);
    }

    @Test
    public void getInstanceTest(){
        assertNotNull(platnosci);
    }

    @Test
    public void dodajStatusTest(){
        platnosci.dodajStatus(zamowienie.getIdZamowienia(), false);
        assertEquals(false, platnosci.getStatus(zamowienie.getIdZamowienia()));
    }
}
