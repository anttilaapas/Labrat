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

    private int leveys;
    private int pituus;
    private int korkeus;
    private int ensiLeveys;
    private int ensiPituus;
    private int ensiKorkeus;

    public Sarmio(int leveys, int pituus, int korkeus) {
        this.leveys = leveys;
        this.pituus = pituus;
        this.korkeus = korkeus;

        this.ensiLeveys = leveys;
        this.ensiPituus = pituus;
        this.ensiKorkeus = korkeus;
    }

    public void rotatoi(int j) {

        if (j == 1) {
            this.leveys = this.ensiKorkeus;
            this.korkeus = this.ensiLeveys;
        } else if (j == 2) {
            this.leveys = this.ensiKorkeus;
            this.pituus = this.ensiLeveys;
            this.korkeus = this.ensiPituus;
        } else if (j == 3) {
            this.leveys = this.ensiPituus;
            this.pituus = this.ensiLeveys;
        } else if (j == 4) {
            this.leveys = this.ensiPituus;
            this.pituus = this.ensiKorkeus;
            this.korkeus = this.ensiLeveys;
        } else if (j == 5) {
            this.pituus = this.ensiKorkeus;
            this.korkeus = this.ensiPituus;
        }

    }

    public void asetaAlkuperainenRotaatio() {
        this.leveys = this.ensiLeveys;
        this.pituus = this.ensiPituus;
        this.korkeus = this.ensiKorkeus;
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
