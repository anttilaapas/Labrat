/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kontintaytto;

/**
 *
 * @author antti
 */
public class Sarmio {
    private int leveys;
    private int pituus;
    private int korkeus;
    
    public Sarmio(int leveys, int pituus, int korkeus) {
        this.leveys = leveys;
        this.pituus = pituus;
        this.korkeus = korkeus;
    }
    
    public int getKorkeus() {
        return this.korkeus;
    }
    
    public int getPituus() {
        return this.pituus;
    }
    
    public int getLeveys() {
        return this.leveys;
    }
    
    public int getTilavuus() {
        return this.korkeus * this.leveys * this.pituus;
    }
}
