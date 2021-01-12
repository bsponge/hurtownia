import me.bRosiak.Jednostka;
import me.bRosiak.Produkt;
import me.jSkiba.Klient;
import me.sRewilak.Zamowienie;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class ZamowienieTest {
    public Klient klient;
    public Produkt produkt;
    public Zamowienie zamowienie;

    @Before
    public void init(){
        klient = new Klient("Imie", "Nazwisko");
        produkt = new Produkt("Nazwa",9.99,"Producent", Jednostka.Kilogram);
        zamowienie = new Zamowienie(klient,"Kraj","Miejscowosc","Ulica",
                "11-111",new Date(2020,01,01), klient.getKoszyk(),1);
    }

    @Test
    public void TworzenieZamowieniaTest() {
        //POTRZEBNA METODA DODAJ PRODUKT W KLASIE MAGAZYN
    }
    @Test
    public void getIDZamowieniaTest(){
        assertNotNull(zamowienie.getIdZamowienia());
    }

    @Test
    public void getDataTest(){
        Date data = new Date(2020,01,01);
        assertEquals(data,zamowienie.getData());
    }

    @Test
    public void testGetMiejscowosc(){
        assertEquals("Miejscowosc", zamowienie.getMiejscowosc());
    }

    @Test
    public void getKodPocztowy(){
        assertEquals("11-111",zamowienie.getKodPocztowy());
    }

    @Test
    public void getUlicaTest(){
        assertEquals("Ulica",zamowienie.getUlica());
    }

    @Test
    public void getKlientData(){
        assertEquals(klient, zamowienie.getKlient());
    }
}
