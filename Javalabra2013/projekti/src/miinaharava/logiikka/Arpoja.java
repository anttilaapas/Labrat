/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package miinaharava.logiikka;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 *
 * @author antti
 */
public class Arpoja {

    private Random random = new Random();

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

    public int luoMiinat(int leveys, int pituus, int vaikeus) {
        
        int miinat = 0;
        
        if (vaikeus == 0) {
            miinat = leveys * pituus / 10;
        } else if (vaikeus == 1) {
            miinat = leveys * pituus / 6;
        } else if (vaikeus == 2) {
            miinat = leveys * pituus / 3;
        } else if (vaikeus == 3) {
            miinat = leveys * pituus;
        }
        //System.out.println(miinat);
        return miinat;
    }

    /*
     * Arpoo niin monta miinaa pelikenttään, kuin tarvitaan
     * 
     * @param   miinat  miinojen lukumäärä
     * @param   leveys  pelikentän leveys
     * @param   pituus  pelikentän pituus
     * 
     */
    public ArrayList<Integer> arvoMiinojenSijainti(int miinat, int leveys, int pituus) {
        ArrayList<Integer> miinanPaikat = new ArrayList<Integer>();

        for (int i = 0; i < miinat; i++) {
            while (true) {
                int paikka = random.nextInt(leveys * pituus);
                if (!miinanPaikat.contains(paikka)) {
                    miinanPaikat.add(paikka);
                    break;
                }
            }
        }
        Collections.sort(miinanPaikat);
        
        return miinanPaikat;
    }

    /*
     * Asettaa miinat peliruudukkoon. Miinojen paikat saadaan miinanPaikat-listasta
     * ja vastaaville kohdille ruudukko-taulukossa asetetaan arvo -1 osoittamaan miinaa
     * 
     * @param   miinanPaikat    miinojen paikat ruudukossa
     * @param   ruudukko        ruudukko, johon miinat asetetaan
     * 
     */
    public int[] asetaMiinatRuudukkoon(ArrayList<Integer> miinanPaikat, int[] ruudukko) {

        for (int i : miinanPaikat) {
            ruudukko[i] = -1;
        }
        
        return ruudukko;
    }

   
}
