/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package miinaharava;

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
    private ArrayList<Integer> miinanPaikat;
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
        luoMiinat(leveys, pituus, vaikeus);
       
    }
    
    
    /*
     * Määrittelee miinojen lukumäärän pelin vaikeusasteen mukaan, ja sen jälkeen
     * kutsuu arvoMiinojenSijainti-funktiota arpoen miinojen sijainnin ja sen jälkeen
     * kutsuu asetaMiinatRuudukkoon-metodia asettaen arvotut miinat ruudukkoon
     * 
     * @param   leveys  pelikentän leveys
     * @param   pituus  pelikentän pituus
     * @param   pelikentän vaikeus (0: helppo, 1: keskivaikea, 2: vaikea)
     * 
     */
    
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
    
    /*
     * Arpoo niin monta miinaa pelikenttään, kuin tarvitaan
     * 
     * @param   miinat  miinojen lukumäärä
     * @param   leveys  pelikentän leveys
     * @param   pituus  pelikentän pituus
     * 
     */
    
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
    
    /*
     * Asettaa miinat peliruudukkoon. Miinojen paikat saadaan miinanPaikat-listasta
     * ja vastaaville kohdille ruudukko-taulukossa asetetaan arvo -1 osoittamaan miinaa
     * 
     */
    public void asetaMiinatRuudukkoon() {
        
        for (int i : miinanPaikat) {
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
