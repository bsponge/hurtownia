import me.FileOperations;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.*;

public class FileOperationsTest {
    public File file;

    @Before
    public void init() throws IOException {
        file = Files.createFile(Paths.get("test_file")).toFile();
    }

    @After
    public void after() {
        file.delete();
    }

    @Test
    public void zapiszObiektTest() {
        String str = "TEST1";
        FileOperations.zapiszObiekt(str, file.getName());
        String input = FileOperations.odczytajObiekt(String.class, file.getName());
        assertEquals(str, input);
    }

    @Test
    public void odczytajObiektTest() {
        String str = "TEST2";
        FileOperations.zapiszObiekt(str, file.getPath());
        String input = FileOperations.odczytajObiekt(String.class, file.getPath());
        assertEquals(str, input);
    }
}
