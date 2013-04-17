/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kontintaytto.sarmiot;

import kontintaytto.sarmiot.Paketti;
import kontintaytto.sarmiot.Sarmio;
import java.util.ArrayList;

/**
 *
 * @author antti
 */
public class Kontti extends Sarmio {
    
    public Kontti(double leveys, double pituus, double korkeus) {
        super(leveys, pituus, korkeus);
    }
    
    
//    public boolean tayta(ArrayList<Paketti> paketit) {
//        System.out.println(this.pakettilistanTilavuus(paketit));
//        if (this.pakettilistanTilavuus(paketit) > this.getTilavuus()) {
//            System.out.println("Pakettilista ei mahdu yhteen konttiin.");
//            return false;
//        }
//        return true;
//    }
    
//    public int pakettilistanTilavuus(ArrayList<Paketti> paketit) {
//        
//        int tilavuus = 0;
//        for (Paketti p : paketit) {
//            tilavuus += p.getTilavuus();
//        }
//        return tilavuus;
//    }
    
}
