import me.bRosiak.Jednostka;
import me.bRosiak.Produkt;
import me.jSkiba.Klient;
import org.junit.Before;
import org.junit.Test;

public class ZamowienieTest {
    public Klient klient;
    public Produkt produkt;

    @Before
    public void init(){
        klient = new Klient("Imie", "Nazwisko");
        produkt = new Produkt("Nazwa",9.99,"Producent", Jednostka.Kilogram);
    }

    @Test
    public void TworzenieZamowieniaTest(){
        // POTRZEBNA METODA DODAJ PRODUKT W KLASIE MAGAZYN
        klient.dodajProdukt(produkt,2);
        klient.zlozZamowienie();
    }
}
