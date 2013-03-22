/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import miinaharava.Kentta;
import miinaharava.Peli;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author antti
 */
public class PeliTest {
    
    public PeliTest() {
    }
    
    
    
    Kentta kentta = new Kentta(10, 10, 2);
    Peli peli = new Peli(kentta);
    int[][] ruudukko = kentta.haeRuudukko();
    
    @Before
    public void setUp() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                ruudukko[i][j] = -1;
            }
        }
        
    }
    
    @Test
    public void oikeaMaaraViereisiaMiinojaKulmassa() {
        assertEquals(3, peli.vieressaMiinoja(ruudukko, 0, 0));
    }
    
    @Test
    public void oikeaMaaraViereisiaMiinojaKeskella() {
        assertEquals(8, peli.vieressaMiinoja(ruudukko, 1, 1));
    }
    
    @Test
    public void oikeaMaaraViereisiaMiinojaReunassa() {
        assertEquals(8, peli.vieressaMiinoja(ruudukko, 0, 1));
    }
}
