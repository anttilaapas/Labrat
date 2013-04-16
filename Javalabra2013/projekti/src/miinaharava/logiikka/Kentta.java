/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package miinaharava.logiikka;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * @author      Antti Laapas
 * @version     0.8
 * @since       2013-03-15
 */
public class Kentta {
    
    private Random random = new Random();
    private int[] ruudukko;
    private ArrayList<Integer> miinanPaikat = new ArrayList<Integer>();
    private int miinat = 0;
    private int leveys;
    private int pituus;
        
    /*
     * Luo pelikentän, joka on ensin tyhjä, ja tämän jälkeen
     * kutsuu luoMiinat-metodia, joka luo miinat kenttään
     * 
     * @param   leveys  pelikentän leveys
     * @param   pituus  pelikentän pituus
     * @param   pelikentän vaikeus (0: helppo, 1: keskivaikea, 2: vaikea)
     * 
     * 
     */
    
    
    public Kentta(int leveys, int pituus, int vaikeus) {
        
        this.ruudukko = new int[leveys*pituus];
        this.leveys = leveys;
        this.pituus = pituus;
        
        
        Arpoja arpoja = new Arpoja();
        
        this.miinat = arpoja.luoMiinat(leveys, pituus, vaikeus);
        this.miinanPaikat = arpoja.arvoMiinojenSijainti(miinat, leveys, pituus);
        this.ruudukko = arpoja.asetaMiinatRuudukkoon(miinanPaikat, ruudukko);
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
