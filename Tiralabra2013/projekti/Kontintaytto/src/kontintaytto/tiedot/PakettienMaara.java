/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kontintaytto.tiedot;

import java.util.Scanner;
import kontintaytto.sarmiot.Paketti;

/**
 *
 * @author antti
 */
public class PakettienMaara {
    
    private Scanner lukija;
    
    private int paketteja1;
    private int paketteja2;
    private int paketteja3;
    
    private Paketti paketti1;
    private Paketti paketti2;
    private Paketti paketti3;

    public PakettienMaara(Scanner lukija) {
        this.lukija = lukija;
        
        this.paketti1 = new Paketti(1, 2, 3);
        this.paketti2 = new Paketti(3, 4, 5);
        this.paketti3 = new Paketti(6, 6, 6);
    }

    public void laatikoidenKyselija() {
        System.out.print("Kuinka monta " + paketti1.getLeveys() + "x" + paketti1.getPituus() + "x" + paketti1.getKorkeus() + " -laatikkoa? ");
        this.paketteja1 = Integer.parseInt(lukija.nextLine());

        System.out.print("Kuinka monta " + paketti2.getLeveys() + "x" + paketti2.getPituus() + "x" + paketti2.getKorkeus() + " -laatikkoa? ");
        this.paketteja2 = Integer.parseInt(lukija.nextLine());

        System.out.print("Kuinka monta " + paketti3.getLeveys() + "x" + paketti3.getPituus() + "x" + paketti3.getKorkeus() + " -laatikkoa? ");
        this.paketteja3 = Integer.parseInt(lukija.nextLine());
    }
    
    public Paketti getPaketti(int i) {
        if (i == 1) {
            return paketti1;
        } else if (i == 2) {
            return paketti2;
        } else if (i == 3) {
            return paketti3;
        } else {
            return null;
        }
    }
    
    public int pakettienMaara(int i) {
        if (i == 1) {
            return paketteja1;
        } else if (i == 2) {
            return paketteja2;
        } else if (i == 3) {
            return paketteja3;
        } else {
            return 0;
        }
    }
    
    public int kaikkienPakettienMaara() {
        return paketteja1 + paketteja2 + paketteja3;
    }
    
    public double annaPakettienTilavuus(int i) {        
        return paketti1.getTilavuus() + paketti2.getTilavuus() + paketti3.getTilavuus();
    }
    
}
