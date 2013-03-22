/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import kontintaytto.Kontti;
import kontintaytto.Paketti;
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
public class KontintayttoTest {
    
    public KontintayttoTest() {
    }
    
    
    @Before
    public void setUp() {
    }
    
    @Test
    public void leveysOikein() {
        Kontti kontti = new Kontti(5, 10, 15);
        assertEquals(5, kontti.getLeveys());
    }
    
    @Test
    public void pituusOikein() {
        Kontti kontti = new Kontti(5, 10, 15);
        assertEquals(10, kontti.getPituus());
    }
    
    @Test
    public void korkeusOikein() {
        Kontti kontti = new Kontti(5, 10, 15);
        assertEquals(15, kontti.getKorkeus());
    }
    
    @Test
    public void kontinTilavuusOikein() {
        Kontti kontti = new Kontti(5, 10, 15);
        assertEquals(750, kontti.getTilavuus());
    }
    
    @Test
    public void pakettiListanTilavuusOikein() {
        Kontti kontti = new Kontti(10, 10, 10);
        ArrayList<Paketti> paketit = new ArrayList<>();
        
        for (int i = 0; i < 20; i++) {
            Paketti paketti = new Paketti(1, 1, 1);
            paketit.add(paketti);
        }
        
        assertEquals(20, kontti.pakettilistanTilavuus(paketit));
    }
    
    public void mahtuuKonttiin() {
        Kontti kontti = new Kontti(10, 10, 10);
        ArrayList<Paketti> paketit = new ArrayList<>();
        
        for (int i = 0; i < 20; i++) {
            Paketti paketti = new Paketti(1, 1, 1);
            paketit.add(paketti);
        }
        
        assertEquals(true, kontti.tayta(paketit));
    }
    
    public void eiMahduKonttiin() {
        Kontti kontti = new Kontti(10, 10, 10);
        ArrayList<Paketti> paketit = new ArrayList<>();
        
        for (int i = 0; i < 20; i++) {
            Paketti paketti = new Paketti(10, 10, 10);
            paketit.add(paketti);
        }
        
        assertFalse(kontti.tayta(paketit));
    }
    
}
