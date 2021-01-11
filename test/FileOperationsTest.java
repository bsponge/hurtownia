import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import me.FileOperations;

public class FileOperationsTest {
    public File file;
    @Before
    public void init() throws IOException {
        file = File.createTempFile("test", "");
    }

    @After
    public void after() {
        file.delete();
    }

    @Test
    public void checkFilesTest() {
    	assertTrue(FileOperations.checkFiles());
    }
    
    @Test
    public void zapiszObiektTest() {
        String str = "TEST";
        FileOperations.zapiszObiekt(str, file.getName());
        String input = FileOperations.odczytajObiekt(String.class, file.getName());
        assertEquals(str, input);
    }

    @Test
    public void odczytajObiektTest() {
        String str = "TEST";
        FileOperations.zapiszObiekt(str, file.getPath());
        String input = FileOperations.odczytajObiekt(String.class, file.getPath());
        assertEquals(str, input);
    }
}
