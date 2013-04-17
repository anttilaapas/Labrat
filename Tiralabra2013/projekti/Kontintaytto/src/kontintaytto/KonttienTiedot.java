/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kontintaytto;

import java.util.Scanner;
import kontintaytto.sarmiot.Kontti;

/**
 *
 * @author antti
 */
public class KonttienTiedot {
    private Kontti kontti;
    private Scanner lukija;
    
    
    public KonttienTiedot(Scanner lukija) {
        this.lukija = lukija;
    }

    public void konttienKyselija() {
        System.out.println("\nAnna konttien mitat (kaikki kontit samanmittaisia)");
        
        System.out.print("Kontin leveys (m): ");
        double leveys = Double.parseDouble(lukija.nextLine());

        System.out.print("Kontin pituus (m): ");
        double pituus = Double.parseDouble(lukija.nextLine());

        System.out.print("Kontin korkeus (m): ");
        double korkeus = Double.parseDouble(lukija.nextLine());
        
        this.kontti = new Kontti(leveys, pituus, korkeus);
    }
    
    public double kontinTilavuus() {
        return this.kontti.getTilavuus();
    }
    
}
