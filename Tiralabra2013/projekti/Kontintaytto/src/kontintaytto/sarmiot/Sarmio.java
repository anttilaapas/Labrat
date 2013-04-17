/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kontintaytto.sarmiot;

/**
 *
 * @author antti
 */
public class Sarmio {
    private double leveys;
    private double pituus;
    private double korkeus;
    
    public Sarmio(double leveys, double pituus, double korkeus) {
        this.leveys = leveys;
        this.pituus = pituus;
        this.korkeus = korkeus;
    }
    
    public double getKorkeus() {
        return this.korkeus;
    }
    
    public double getPituus() {
        return this.pituus;
    }
    
    public double getLeveys() {
        return this.leveys;
    }
    
    public double getTilavuus() {
        return this.korkeus * this.leveys * this.pituus;
    }
}
