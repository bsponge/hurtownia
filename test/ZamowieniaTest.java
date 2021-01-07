import me.jSkiba.Koszyk;
import me.sRewilak.Zamowienie;
import me.sRewilak.Zamowienia;
import me.jSkiba.Klient;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class ZamowieniaTest {
    @Test
    public void dodajZamowienieTest() {
        Koszyk koszyk = new Koszyk();
        Klient klient = new Klient("Imie", "Nazwisko");
        Zamowienie zamowienie = new Zamowienie(klient, "Kraj",
                "Miejscowosc", "Ulica", "Kod", new Date(), koszyk);

        Zamowienia zamowienia = Zamowienia.getInstance();
        zamowienia.dodajZamowienie(zamowienie);
        assertTrue(zamowienia.getListaZamowien().contains(zamowienie));
    }

    @Test
    public void usunZamowienieTest(){
        Koszyk koszyk = new Koszyk();
        Klient klient = new Klient("Imie", "Nazwisko");
        Zamowienie zamowienie = new Zamowienie(klient, "Kraj",
                "Miejscowosc", "Ulica", "Kod", new Date(), koszyk);

        Zamowienia zamowienia = Zamowienia.getInstance();
        zamowienia.dodajZamowienie(zamowienie);
        zamowienia.usunZamowienie(zamowienie.getIdZamowienia());
        assertFalse(zamowienia.getListaZamowien().contains(zamowienie));
    }

}
