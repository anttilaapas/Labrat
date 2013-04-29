/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import miinaharava.logiikka.Kentta;
import miinaharava.logiikka.Peli;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author antti
 */
public class PeliTest {

    public PeliTest() {
    }
    Kentta kentta;
    Peli peli;
    

    @Before
    public void setUp() {
        kentta = new Kentta(5, 5, 2);
        peli = new Peli(kentta);
    }

    @Test
    public void onAlaReunaToimii() {       
        assertTrue(peli.onAlareuna(23));
    }

    @Test
    public void onYlaReunaToimii() {        
        assertTrue(peli.onYlareuna(3));
    }
    
    @Test
    public void onVasenReunaToimii() {
        assertTrue(peli.onVasenReuna(5));
    }

    @Test
    public void onOikeaReunaToimii() {    
        assertTrue(peli.onOikeaReuna(9));
    }
    
    @Test
    public void onKeskellaToimii() {    
        assertTrue(peli.onKeskella(8));
    }
    
    @Test
    public void onVasenYlakulmaToimii() {    
        assertTrue(peli.onVasenYlakulma(0));
    }
    
    @Test
    public void onOikeaYlakulmaToimii() {    
        assertTrue(peli.onOikeaYlakulma(4));
    }
    
    @Test
    public void onOikeaAlakulmaToimii() {    
        assertTrue(peli.onOikeaAlakulma(24));
    }
    
    @Test
    public void onVasenAlakulmaToimii() {    
        assertTrue(peli.onVasenAlakulma(20));
    }
}
