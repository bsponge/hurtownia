import me.jSkiba.Koszyk;
import me.sRewilak.Pracownik;
import me.sRewilak.Zamowienie;
import me.sRewilak.Zamowienia;
import me.jSkiba.Klient;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Date;
import java.util.LinkedList;

import static org.junit.Assert.*;

public class ZamowieniaTest {
    public Zamowienie zamowienie;
    public Klient klient;
    public Koszyk koszyk;
    public Pracownik pracownik;
    public Zamowienia zamowienia;
    private final PrintStream wyjscie = System.out;
    private final ByteArrayOutputStream wyjscieZapis = new ByteArrayOutputStream();


    @Before
    public void init(){
        pracownik = new Pracownik("Imie", "Nazwisko","123");
        koszyk = new Koszyk();
        klient = new Klient("Imie", "Nazwisko");
        zamowienie = new Zamowienie(klient, "Kraj",
                "Miejscowosc", "Ulica", "Kod", new Date(2020,01,01), koszyk);
        zamowienia = Zamowienia.getInstance();
        System.setOut(new PrintStream(wyjscieZapis));

    }


    @Test
    public void dodajZamowienieTest() {
        Zamowienia zamowienia = Zamowienia.getInstance();
        zamowienia.dodajZamowienie(zamowienie);
        assertTrue(zamowienia.getListaZamowien().contains(zamowienie));
    }


    @Test
    public void niepoprawneIdTestWyswietl(){
        // Test sprawdza odmowe dostepu w przypadku blednego ID
        zamowienia.dodajZamowienie(zamowienie);
        zamowienia.wyswietlZamowienia("wrong");
        assertEquals("Nieautoryzowany dostep. Odmowa dostepu"+"\r\n",wyjscieZapis.toString());
        assertNotEquals("Zamowienie 1. Klient: Imie, Nazwisko. Data: 2020.01.01",wyjscieZapis.toString());
        zamowienia.usunZamowienie(zamowienie.getIdZamowienia());
    }

    @Test
    public void getListaZamowienTest(){
        // Test sprawdza liste zamowien po dodaniu 2 zamowien
        zamowienia.dodajZamowienie(zamowienie);
        LinkedList<Zamowienie> lista = new LinkedList<Zamowienie>();
        lista.add(zamowienie);
        Zamowienie zamowienie2 = new Zamowienie(klient, "K", "M","U","K",new Date(),koszyk);
        zamowienia.dodajZamowienie(zamowienie2);
        lista.add(zamowienie2);
        assertEquals(lista,zamowienia.getListaZamowien());

        // Lista zamowien czyszczona na potrzeby dalszych testow
        zamowienia.usunZamowienie(zamowienie2.getIdZamowienia());
        zamowienia.usunZamowienie(zamowienie.getIdZamowienia());
    }

    @Test
    public void usunZamowienieTest(){
        zamowienia.dodajZamowienie(zamowienie);
        zamowienia.usunZamowienie(zamowienie.getIdZamowienia());
        assertFalse(zamowienia.getListaZamowien().contains(zamowienie));
    }

    @Test
    public void getInstanceTest(){
        //zamowienia.getInstance() jest wyzej, w @Before
        assertNotNull(zamowienia);
    }

    @Test
    public void wyswietlZamowieniaTest(){
        zamowienia.dodajZamowienie(zamowienie);
        zamowienia.wyswietlZamowienia("123");
        assertEquals("Zamowienie 1. Klient: Imie, Nazwisko. Data: 2020.01.01"+"\r\n" ,wyjscieZapis.toString());
    }

    @After
    // Przywrocenie standardowego wyjscia po zakonczeniu testow
    public void zakonczenie() {
        System.setOut(wyjscie);
    }

}
