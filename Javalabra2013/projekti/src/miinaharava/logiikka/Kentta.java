/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package miinaharava.logiikka;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * @author Antti Laapas
 * @version 0.8
 * @since 2013-03-15
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
     * kutsuu arpojan miinanluomisfunktioita
     * 
     * @param   leveys  pelikentän leveys
     * @param   pituus  pelikentän pituus
     * @param   vaikeus pelikentän vaikeus (0: helppo, 1: keskivaikea, 2: vaikea)
     * 
     * 
     */
    public Kentta(int leveys, int pituus, int vaikeus) {

        this.ruudukko = new int[leveys * pituus];
        this.leveys = leveys;
        this.pituus = pituus;


        Arpoja arpoja = new Arpoja();

        this.miinat = arpoja.luoMiinat(leveys, pituus, vaikeus);
        this.miinanPaikat = arpoja.arvoMiinojenSijainti(miinat, leveys, pituus);
        this.ruudukko = arpoja.asetaMiinatRuudukkoon(miinanPaikat, ruudukko);
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
