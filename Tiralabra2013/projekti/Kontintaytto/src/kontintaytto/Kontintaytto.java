/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kontintaytto;

import kontintaytto.sarmiot.Kontti;
import kontintaytto.sarmiot.Paketti;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author antti
 */
public class Kontintaytto {
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner lukija = new Scanner(System.in);
        
        System.out.print("Anna kontin leveys: ");
        int leveys = Integer.parseInt(lukija.nextLine());
        
        System.out.print("Anna kontin pituus: ");
        int pituus = Integer.parseInt(lukija.nextLine());
        
        System.out.print("Anna kontin korkeus: ");
        int korkeus = Integer.parseInt(lukija.nextLine());
        
        Kontti kontti = new Kontti(leveys, pituus, korkeus);
        
        System.out.println("Kontin tilavuus: " + kontti.getTilavuus());
        
        
        //testidataa
        ArrayList<Paketti> paketit = new ArrayList<>();
        
        for (int i = 0; i < 20; i++) {
            Paketti paketti = new Paketti(i+1, i+2, i+3);
            paketit.add(paketti);
        }
        
        //kontti.tayta(paketit);
        
    }
}
