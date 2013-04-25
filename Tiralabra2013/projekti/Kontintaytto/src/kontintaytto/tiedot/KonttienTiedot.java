/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kontintaytto.tiedot;

import java.util.Scanner;
import kontintaytto.sarmiot.Kontti;

/**
 *
 * @author antti
 */
public class KonttienTiedot {
    private Kontti kontti;
    private Scanner lukija;
    
    public KonttienTiedot() {

    }
    
    public KonttienTiedot(Scanner lukija) {
        this.lukija = lukija;
    }

    public void konttienKyselija() {
        System.out.println("\nAnna konttien mitat (kaikki kontit samanmittaisia)");
        
        System.out.print("Kontin leveys (cm): ");
        int leveys = Integer.parseInt(lukija.nextLine());

        System.out.print("Kontin pituus (cm): ");
        int pituus = Integer.parseInt(lukija.nextLine());

        System.out.print("Kontin korkeus (cm): ");
        int korkeus = Integer.parseInt(lukija.nextLine());
        
        this.kontti = new Kontti(leveys, pituus, korkeus);
    }
    
    public Kontti getKontti() {
        return this.kontti;
    }
    
    public int kontinTilavuus() {
        return this.kontti.getTilavuus();
    }

    Kontti taysin() {
        throw new UnsupportedOperationException("Not yet implemented");
    }
    
}
