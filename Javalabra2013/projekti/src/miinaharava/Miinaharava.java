/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package miinaharava;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author anttilaa
 */
public class Miinaharava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner lukija = new Scanner(System.in);
        
        System.out.print("Anna ruudukon leveys: ");
        int leveys = Integer.parseInt(lukija.nextLine());
        
        System.out.print("Anna ruudukon pituus: ");
        int pituus = Integer.parseInt(lukija.nextLine());
        
        System.out.println("Kentän vaikeusaste (0: helppo, 1: keskivaikea, 2: vaikea): ");
        int vaikeus = Integer.parseInt(lukija.nextLine());
        
        // kentän luonti
        Kentta kentta = new Kentta(leveys, pituus, vaikeus);
        
        kentta.tulostaRuudukko();
        
        Peli peli = new Peli(kentta);
        peli.aloita();
    }
}
