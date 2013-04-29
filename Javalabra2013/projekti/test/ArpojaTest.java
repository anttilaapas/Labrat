/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.Collections;
import miinaharava.logiikka.Arpoja;
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
public class ArpojaTest {

    Arpoja arpoja;
    int miinat;
    ArrayList<Integer> miinanPaikat;
    int[] ruudukko;

    @Before
    public void setUp() {
        arpoja = new Arpoja();
        miinat = arpoja.luoMiinat(10, 10, 2);
        miinanPaikat = arpoja.arvoMiinojenSijainti(miinat, 10, 10);
        this.ruudukko = new int[10 * 10];
        Collections.sort(miinanPaikat);
        arpoja.asetaMiinatRuudukkoon(miinanPaikat, ruudukko);
    }

    @Test
    public void eiKahtaMiinaaSamassaPaikassa() {
        for (int i : miinanPaikat) {
            if (i < miinanPaikat.size() - 1) {
                assertFalse(miinanPaikat.get(i) == miinanPaikat.get(i + 1));
            }
        }
    }
    
    @Test
    public void miinatLoytyvatMyosRuudukosta() {
        for (int i : miinanPaikat) {
            assertEquals(-1, ruudukko[i]);
        }
    }
}
