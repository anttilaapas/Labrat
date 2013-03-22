/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.Collections;
import miinaharava.Kentta;
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
public class KenttaTest {
    
    public KenttaTest() {
    }
    
    
    @Before
    public void setUp() {
        

    }
    
    @Test
    public void eiKahtaMiinaaSamassaRuudussa() {
        Kentta kentta = new Kentta(5, 5, 2);
        ArrayList<Integer> paikat = kentta.miinojenPaikat();
       
        Collections.sort(paikat);
        
        int edel = paikat.get(0);
        int seur = paikat.get(1);

        int i = 1;
        for (int p : paikat) {
            assertFalse(edel == seur);
            
            if ((i+1) != paikat.size()) {
                edel = seur;
                seur = paikat.get(i+1);
            }
            i++;
        }
    }
    
    
    @Test
    public void oikeaMaaraMiinojaHelpollaVaikeusasteella() {
        Kentta kentta = new Kentta(10, 10, 0);
        assertEquals(10, kentta.miinojenLkm());
    }
    
    @Test
    public void oikeaMaaraMiinojaKeskivaikeallaVaikeusasteella() {
        Kentta kentta = new Kentta(6, 10, 1);
        assertEquals(10, kentta.miinojenLkm());
    }
    
    @Test
    public void oikeaMaaraMiinojaVaikeallaVaikeusasteella() {
        Kentta kentta = new Kentta(6, 6, 2);
        assertEquals(12, kentta.miinojenLkm());
    }
    
}
