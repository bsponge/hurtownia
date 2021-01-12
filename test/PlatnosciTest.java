import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class PlatnosciTest {
    public Platnosci platnosci;

    @Before
    public void init(){
        platnosci = platnosci.getInstance();
    }

    @Test
    public void getInstanceTest(){
        assertNotNull(platnosci);
    }

}
