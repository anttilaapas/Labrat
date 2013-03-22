/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package miinaharava;

/**
 *
 * @author antti
 */
public class Peli {
    
    Kentta kentta;
    int[][] ruudukko;

    public Peli(Kentta kentta) {
        this.kentta = kentta;
        this.ruudukko = kentta.haeRuudukko();
    }
    
    // täällä kerrotaan, kuinka monta miinaa viereisessä ruudussa on
    public int vieressaMiinoja(int[][] ruudukko, int i, int j) {
        return 0;
    }
    
    // asetetaan, kuinka monta miinaa on tämän ruudun viereisissä ruuduissa
    public void viereisetRuudut() {
        for (int i = 0; i < ruudukko[0].length; i++) {
            System.out.print((i) + "");
            for (int j = 0; j < ruudukko.length; j++) {
                ruudukko[j][i] = vieressaMiinoja(ruudukko, j, i);
            }
            System.out.println("");
        }
    }

    void aloita() {
        throw new UnsupportedOperationException("Not yet implemented");
    }
    
    
}
