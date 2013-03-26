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
    private int[] ruudukko;
    private ArrayList<Integer> miinanPaikat;
    private int miinat = 0;
    private int leveys;
    private int pituus;
        
    
    public Kentta(int leveys, int pituus, int vaikeus) {
        
        this.ruudukko = new int[leveys*pituus];
        this.leveys = leveys;
        this.pituus = pituus;
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
        asetaMiinatRuudukkoon();
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
    public void asetaMiinatRuudukkoon() {
        
        for (int i : miinanPaikat) {
            //System.out.println("Miinanpaikka: " + i);
            //System.out.println(i/leveys + ", " + i%pituus + ", " + leveys + ", " + pituus);
            ruudukko[i] = -1;
        }
    }

    
    
    
    public void tulostaRuudukko() {
        System.out.println("Leveys: " + this.leveys + ", pituus: " + this.pituus);
        for (int i = 0; i < ruudukko.length; i++) {
            if ((i+1) % this.leveys == 0) {
                if (ruudukko[i] == -1) {
                    System.out.println("[*]");
                } else {
                    System.out.println("[" + ruudukko[i] + "]");
                }
            } else {
                if (ruudukko[i] != -1) {
                    System.out.print("[" + ruudukko[i] + "]");
                } else {
                    System.out.print("[*]");
                }
            }
        }
    }
    
    public int miinojenLkm() {
        return this.miinat;
    }
    
    public int[] haeRuudukko() {
        return this.ruudukko;
    }
    
    
    public ArrayList<Integer> miinojenPaikat() {
        return this.miinanPaikat;
    }
    
    public int getLeveys() {
        return this.leveys;
    }
    
    public int getPituus() {
        return this.pituus;
    }
}
