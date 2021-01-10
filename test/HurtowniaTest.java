import me.jSkiba.Hurtownia;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.Assert.*;

public class HurtowniaTest {
    private Hurtownia hurtownia;

    @Before
    public void init() {
        hurtownia = new Hurtownia();
    }

    @Test
    public void getInputTest() {
        Scanner scannerBackup = Hurtownia.scanner;
        ByteArrayInputStream in = new ByteArrayInputStream(("fjdlsk"
                + System.lineSeparator()
                + "jfdklsfjsdkl"
                + System.lineSeparator()
                + "321"
                + System.lineSeparator()
                + "123").getBytes());
        Hurtownia.scanner = new Scanner(in);

        int input = hurtownia.getInput();
        assertEquals(321, input);

        Hurtownia.scanner = scannerBackup;
    }

    @Test
    public void runTest() {

    }
}
