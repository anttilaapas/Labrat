
import miinaharava.Kello;
import java.util.ArrayList;
import java.util.Collections;
import miinaharava.Kentta;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author antti
 */
public class KelloTest {
    //
    Kello kello = new Kello();
    
    @Test
    public void oikeaAikaNollassa() {
        assertEquals("00:00", kello.getAika(0));
    }
    
    @Test
    public void oikeaAikaAlleKymmenessaSekunnissa() {     
        assertEquals("00:07", kello.getAika(7));
    }
    
    @Test
    public void oikeaAikaKymmenessaSekunnissa() {     
        assertEquals("00:10", kello.getAika(10));
    }
    
    @Test
    public void oikeaAikaYliMinuutissa() {     
        assertEquals("03:01", kello.getAika(181));
    }
    
    @Test
    public void oikeaAikaYliKymmenessaMinuutissa() {     
        assertEquals("10:01", kello.getAika(601));
    }
}
