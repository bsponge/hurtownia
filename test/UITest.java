import me.jSkiba.UI;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.junit.Assert.*;

public class UITest {
    private UI UI;

    @Before
    public void init() {
        UI = new UI();
    }

    @Test
    public void getInputTest() {
        Scanner scannerBackup = me.jSkiba.UI.scanner;
        ByteArrayInputStream in = new ByteArrayInputStream(("fjdlsk"
                + System.lineSeparator()
                + "jfdklsfjsdkl"
                + System.lineSeparator()
                + "321"
                + System.lineSeparator()
                + "123").getBytes());
        UI.scanner = new Scanner(in);

        int input = UI.getInput();
        assertEquals(321, input);

        UI.scanner = scannerBackup;
    }

    @Test
    public void runTest() {

    }
}
