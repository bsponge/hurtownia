import me.jSkiba.Koszyk;
import me.sRewilak.Platnosci;
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
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import static org.junit.Assert.*;

public class ZamowieniaTest {
    public Zamowienie zamowienie;
    public Klient klient, klient2;
    public Koszyk koszyk;
    public Pracownik pracownik;
    public Zamowienia zamowienia;
    public Platnosci platnosci;
    private final PrintStream wyjscie = System.out;
    private final ByteArrayOutputStream wyjscieZapis = new ByteArrayOutputStream();


    @Before
    public void init(){
        pracownik = new Pracownik("Imie", "Nazwisko","123");
        koszyk = new Koszyk();
        klient = new Klient("Imie", "Nazwisko");
        klient2 = new Klient("Szymon", "Rewilak");
        zamowienie = new Zamowienie(klient, "Kraj",
                "Miejscowosc", "Ulica", "Kod", new Date(), koszyk,1);
        zamowienia = Zamowienia.getInstance();
        platnosci = Platnosci.getInstance();
        System.setOut(new PrintStream(wyjscieZapis));

    }


    @Test
    public void dodajZamowienieTest() {
        Zamowienia zamowienia = Zamowienia.getInstance();
        zamowienia.dodajZamowienie(zamowienie);
        assertTrue(zamowienia.getListaZamowien().containsKey(zamowienie.getIdZamowienia()));
    }


    @Test
    public void niepoprawneIdTestWyswietl(){
        // Test sprawdza odmowe dostepu w przypadku blednego ID
        zamowienia.dodajZamowienie(zamowienie);
        zamowienia.wyswietlZamowienia("blad");
        assertEquals("Nieautoryzowany dostep. Odmowa dostepu"+"\r\n",wyjscieZapis.toString());
        assertNotEquals("Zamowienie 1. Klient: Imie, Nazwisko. Data: 2020.01.01",wyjscieZapis.toString());
        zamowienia.usunZamowienie(zamowienie.getIdZamowienia());
    }

    @Test
    public void niepoprawneIdRealizujZamowienie(){
        // Test sprawdza odmowe dostepu w przypadku blednego ID
        zamowienia.realizujZamowienie("blad",zamowienie.getIdZamowienia());
        assertEquals("Nieautoryzowany dostep. Odmowa dostepu"+"\r\n",wyjscieZapis.toString());
    }


    @Test
    public void getListaZamowienTest(){
        // Test sprawdza liste zamowien po dodaniu 2 zamowien
        zamowienia.dodajZamowienie(zamowienie);
        Map<UUID,Zamowienie> mapa = new ConcurrentHashMap<>();
        mapa.put(zamowienie.getIdZamowienia(),zamowienie);
        Zamowienie zamowienie2 = new Zamowienie(klient, "K", "M","U","K",new Date(),koszyk,1);
        zamowienia.dodajZamowienie(zamowienie2);
        mapa.put(zamowienie2.getIdZamowienia(),zamowienie2);
        assertEquals(mapa,zamowienia.getListaZamowien());

        // Lista zamowien czyszczona na potrzeby dalszych testow
        zamowienia.usunZamowienie(zamowienie2.getIdZamowienia());
        zamowienia.usunZamowienie(zamowienie.getIdZamowienia());
    }

    @Test
    public void usunZamowienieTest(){
        zamowienia.dodajZamowienie(zamowienie);
        zamowienia.usunZamowienie(zamowienie.getIdZamowienia());
        assertFalse(zamowienia.getListaZamowien().containsKey(zamowienie.getIdZamowienia()));
    }

    @Test
    public void usunZamowienieBledneId(){
        UUID bledneId = new UUID(5,5);
        zamowienia.usunZamowienie(bledneId);
        assertEquals("Brak zamowienia o takim id w bazie zamowien."+"\r\n",wyjscieZapis.toString());
    }

    @Test
    public void getInstanceTest(){
        //zamowienia.getInstance() jest wyzej, w @Before
        assertNotNull(zamowienia);
    }

    @Test
    public void wyswietlZamowieniaTest(){
        zamowienia.dodajZamowienie(zamowienie);
        Zamowienie zamowienie2 = new Zamowienie(klient2,"k","m","u","11-111",
                new Date(),koszyk,2);
        zamowienia.dodajZamowienie(zamowienie2);
        zamowienia.wyswietlZamowienia("123");
        assertTrue(zamowienia.getListaZamowien().containsKey(zamowienie2.getIdZamowienia()));
        assertEquals("Ostatnie 15 zamowien:" + "\r\n"+
                "Zamowienie 1. Klient: Szymon, Rewilak. Data: "+zamowienie.getData()+"\r\n"+
                "Zamowienie 2. Klient: Imie, Nazwisko. Data: " +zamowienie2.getData()+"\r\n", wyjscieZapis.toString());

    }

    @Test
    public void realizujZamowieniePrzelewTest(){
        // Test dla przypadku z platnoscia przy przelewie ale jeszcze nieoplaconym
        zamowienia.dodajZamowienie(zamowienie);
        platnosci.dodajStatus(zamowienie.getIdZamowienia(),zamowienie.getTypPlatnosci());

        zamowienia.realizujZamowienie("123",zamowienie.getIdZamowienia());

        // zamowienie ma typ platnosci 1 -> przelew
        assertEquals("Zamowienie nie zostalo oplacone. Nie mozna zrealizowac zamowienia."+"\r\n",wyjscieZapis.toString());

        // sprawdz czy zamowienie nadal jest w bazie zamowien
        assertTrue(zamowienia.getListaZamowien().containsKey(zamowienie.getIdZamowienia()));

    }

    /*UWAGA!!!
    Ponizsze test (dla platnosci przelewem oplaconej i platnosc przy odbiorze) musza byc uruchamiane pojedynczo
     - niezgodnosc w symulowaniu wejscia z innymi testami
     */

    /*
    @Test
    public void realizujZamowieniePlatnoscOdbior(){
        // Test dla zamowienia z platnoscia przy odbiorze
        InputStream backup = System.in;

        // Symulacja wyboru wartosci 1 przez uzytkownika
        ByteArrayInputStream wejscie = new ByteArrayInputStream("1".getBytes());
        System.setIn(wejscie);
        Zamowienie zamowienie2 = new Zamowienie(klient,"k","m","u","11-111",
                new Date(),koszyk,2);
        zamowienia.dodajZamowienie(zamowienie2);
        platnosci.dodajStatus(zamowienie2.getIdZamowienia(),zamowienie2.getTypPlatnosci());
        zamowienia.realizujZamowienie("123",zamowienie2.getIdZamowienia());
        assertEquals("Zamowienie z platnoscia przy odbiorze. Gdy zamowienie zostanie wyslane, wybierz 1."+"\r\n",wyjscieZapis.toString());

        // Sprawdzenie czy zamowienie zostalo usuniete z listy zamowien po realizacji
        assertFalse(zamowienia.getListaZamowien().containsKey(zamowienie2.getIdZamowienia()));
    }




    @Test
    public void realizujZamowieniePlatnoscOplacona(){
        // Test dla zamowienia z platnoscia przelewem, ale gdy jest oplacona
        InputStream backup = System.in;

        // Symulacja wyboru wartosci 1 przez uzytkownika
        ByteArrayInputStream wejscie = new ByteArrayInputStream("1".getBytes());
        System.setIn(wejscie);
        // Tworzone zamowienie z typem platnosci 1 -> przelew
        Zamowienie zamowienie2 = new Zamowienie(klient,"k","m","u","11-111",
                new Date(),koszyk,1);
        zamowienia.dodajZamowienie(zamowienie2);
        platnosci.dodajStatus(zamowienie2.getIdZamowienia(),zamowienie2.getTypPlatnosci());

        // Stan zamowienia ustawiany na true -> tak jak w przypadku oplacenia zamowienia
        platnosci.setStatus(zamowienie2.getIdZamowienia(),true);
        zamowienia.realizujZamowienie("123",zamowienie2.getIdZamowienia());

        assertEquals("Zamowienie przelewem oplacone. Gdy zamowienie zostanie wyslane, wybierz 1."+"\r\n",wyjscieZapis.toString());

        // Sprawdzenie czy zamowienie zostalo usuniete z listy zamowien po realizacji
        assertFalse(zamowienia.getListaZamowien().containsKey(zamowienie2.getIdZamowienia()));
    }
    */


    @Test
    public void realizujZamowienieBledneIdPracownika(){
        //zamowienie z blednym ID Pracownika
        Zamowienia.getInstance().realizujZamowienie("blad",zamowienie.getIdZamowienia());
        assertEquals("Nieautoryzowany dostep. Odmowa dostepu"+"\r\n",wyjscieZapis.toString());

    }

    @Test
    public void realizujZamowienieBledneIdZamowienia(){
        Zamowienia.getInstance().realizujZamowienie("123",new UUID(1,1));
        //zamowienie z blednym ID zamowienia

        assertEquals("Nie mozna zrealizowac zamowienia - Brak zamowienia o podanym ID w bazie zamowien."+"\r\n",wyjscieZapis.toString());

    }



    @After
    // Przywrocenie standardowego wyjscia po zakonczeniu testow
    public void zakonczenie() {
        System.setOut(wyjscie);
    }

}
