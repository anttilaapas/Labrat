/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package miinaharava;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 *
 * @author antti
 */
public class Kentta {
    
    private Random random = new Random();
    private int[][] ruudukko;
    private ArrayList<Integer> miinanPaikat;
    private int miinat = 0;
        
    
    public Kentta(int leveys, int pituus, int vaikeus) {
        
        this.ruudukko = new int[leveys][pituus];
        luoMiinat(leveys, pituus, vaikeus);
       
    }
    
    
    public void luoMiinat(int leveys, int pituus, int vaikeus) {
        
        if (vaikeus == 0) {
            miinat = leveys*pituus / 10;
        } else if (vaikeus == 1) {
            miinat = leveys*pituus / 6;
        } else if (vaikeus == 2) {
            miinat = leveys*pituus / 3;
        }
        
        arvoMiinojenSijainti(miinat, leveys, pituus);
        asetaMiinatRuudukkoon(leveys);
    }
    
    
    // tässä arvotaan miinojen sijainti ruudukkoon
    public void arvoMiinojenSijainti(int miinat, int leveys, int pituus) {
        miinanPaikat = new ArrayList<Integer>();
        
        for (int i = 0; i < miinat; i++) {
            while (true) {
                int paikka = random.nextInt(leveys*pituus);
                if (!miinanPaikat.contains(paikka)) {
                    miinanPaikat.add(random.nextInt(leveys*pituus));
                    break;
                }
            }
        }
        Collections.sort(miinanPaikat);
    }
    
    // miinojen asetus ruudukkoon
    public void asetaMiinatRuudukkoon(int leveys) {
        
        for (int i : miinanPaikat) {
            //System.out.println("Miinanpaikka: " + i);
            //System.out.println(i/leveys + ", " + i%pituus + ", " + leveys + ", " + pituus);
            ruudukko[i%leveys][i/leveys] = -1;
        }
    }

    
    
    
    public void tulostaRuudukko() {
        for (int i = 0; i < ruudukko[0].length; i++) {
            System.out.print((i) + "");
            for (int j = 0; j < ruudukko.length; j++) {
                System.out.print("["+ruudukko[j][i]+"]");
            }
            System.out.println("");
        }
    }
    
    public int miinojenLkm() {
        return this.miinat;
    }
    
    public int[][] haeRuudukko() {
        return this.ruudukko;
    }
    
    
    public ArrayList<Integer> miinojenPaikat() {
        return this.miinanPaikat;
    }
    
}
