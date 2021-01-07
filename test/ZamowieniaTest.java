import me.sRewilak.Zamowienie;
import me.sRewilak.Zamowienia;
import me.jSkiba.Klient;
import org.junit.Test;

import java.util.Date;

public class ZamowieniaTest {
    @Test
    public void dodajZamowienieTest() {
        Klient klient = new Klient("Imie", "Nazwisko");
        Zamowienie zamowienie = new Zamowienie(klient, "Kraj",
                "Miejscowosc", "Ulica", "Kod", new Date());

        Zamowienia zamowienia = Zamowienia.getInstance();
        zamowienia.dodajZamowienie(zamowienie);
    }
}
