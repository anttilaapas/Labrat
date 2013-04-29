/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.Collections;
import miinaharava.logiikka.Kentta;
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
    
    Kentta kentta = new Kentta(10, 10, 2);
    
    @Before
    public void setUp() {
        
    }
    
    
    @Test
    public void oikeaMaaraMiinojaHelpollaVaikeusasteella() {
        kentta = new Kentta(10, 10, 0);
        assertEquals(10, kentta.miinojenLkm());
    }
    
    @Test
    public void oikeaMaaraMiinojaKeskivaikeallaVaikeusasteella() {
        kentta = new Kentta(6, 10, 1);
        assertEquals(10, kentta.miinojenLkm());
    }
    
    @Test
    public void oikeaMaaraMiinojaVaikeallaVaikeusasteella() {
        kentta = new Kentta(6, 6, 2);
        assertEquals(12, kentta.miinojenLkm());
    }
    
}
