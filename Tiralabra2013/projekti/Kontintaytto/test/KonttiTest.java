/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import kontintaytto.sarmiot.Kontti;
import kontintaytto.sarmiot.Paketti;
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
public class KonttiTest {
    
    Kontti kontti;
    
    @Before
    public void setUp() {
        kontti = new Kontti(5, 10, 15);
    }
    
    @Test
    public void leveysOikein() {        
        assertEquals(5, kontti.getLeveys());
    }
    
    @Test
    public void pituusOikein() {        
        assertEquals(10, kontti.getPituus());
    }
    
    @Test
    public void korkeusOikein() {
        assertEquals(15, kontti.getKorkeus());
    }
    
    @Test
    public void kontinTilavuusOikein() {
        assertEquals(750, kontti.getTilavuus());
    }
    
//    @Test
//    public void pakettiListanTilavuusOikein() {
//        Kontti kontti = new Kontti(10, 10, 10);
//        ArrayList<Paketti> paketit = new ArrayList<>();
//        
//        for (int i = 0; i < 20; i++) {
//            Paketti paketti = new Paketti(1, 1, 1);
//            paketit.add(paketti);
//        }
//        
//        assertEquals(20, kontti.pakettilistanTilavuus(paketit));
//    }
//    
//    public void mahtuuKonttiin() {
//        Kontti kontti = new Kontti(10, 10, 10);
//        ArrayList<Paketti> paketit = new ArrayList<>();
//        
//        for (int i = 0; i < 20; i++) {
//            Paketti paketti = new Paketti(1, 1, 1);
//            paketit.add(paketti);
//        }
//        
//        assertEquals(true, kontti.tayta(paketit));
//    }
//    
//    public void eiMahduKonttiin() {
//        Kontti kontti = new Kontti(10, 10, 10);
//        ArrayList<Paketti> paketit = new ArrayList<>();
//        
//        for (int i = 0; i < 20; i++) {
//            Paketti paketti = new Paketti(10, 10, 10);
//            paketit.add(paketti);
//        }
//        
//        assertFalse(kontti.tayta(paketit));
//    }
    
}
