import me.jSkiba.Osoba;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class OsobaTest {
    public Osoba osoba;

    @Before
    public void init() {
        osoba = new Osoba("Imie", "Nazwisko");
    }

    @Test
    public void getImieTest() {
        assertEquals("Imie", osoba.getImie());
    }

    @Test
    public void getNazwiskoTest() {
        assertEquals("Nazwisko", osoba.getNazwisko());
    }
}
