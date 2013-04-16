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
    Kentta kentta = new Kentta(5, 5, 2);
    Peli peli = new Peli(kentta);
    int[] ruudukko;
    

    @Before
    public void setUp() {
        for (int i = 0; i < 25; i++) {
            if (i == 0 || i == 5 || i == 6) {
                ruudukko[i] = 0;
            }
            else {
                ruudukko[i] = -1;
            }
        }

    }

    @Test
    public void oikeaMaaraViereisiaMiinojaKulmassa() {
        
        assertEquals(3, peli.vieressaMiinoja(0));
    }

    @Test
    public void oikeaMaaraViereisiaMiinojaKeskella() {
        assertEquals(8, peli.vieressaMiinoja(6));
    }

    @Test
    public void oikeaMaaraViereisiaMiinojaReunassa() {
        assertEquals(8, peli.vieressaMiinoja(5));
    }
}
