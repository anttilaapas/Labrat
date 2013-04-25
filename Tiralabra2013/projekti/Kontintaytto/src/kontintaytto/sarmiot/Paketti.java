/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kontintaytto.sarmiot;

import kontintaytto.sarmiot.Sarmio;

/**
 *
 * @author antti
 */
public class Paketti extends Sarmio {

    private Pivot pivot;
    private Pivot alaTakaVasen;
    private Pivot alaTakaOikea;
    private Pivot ylaTakaVasen;
    private Pivot ylaTakaOikea;
    private Pivot alaEtuVasen;
    private Pivot alaEtuOikea;
    private Pivot ylaEtuVasen;
    private Pivot ylaEtuOikea;


    public Paketti(int leveys, int pituus, int korkeus) {
        super(leveys, pituus, korkeus);


    }

    public void asetaPisteeseen(int x, int y, int z) {
        this.pivot = new Pivot(x, y, z);

        this.alaTakaVasen = new Pivot(x, y, z);
        this.alaTakaOikea = new Pivot(x + this.getLeveys(), y, z);
        this.ylaTakaVasen = new Pivot(x, y, z + this.getKorkeus());
        this.ylaTakaOikea = new Pivot(x + this.getLeveys(), y, z + this.getKorkeus());
        this.alaEtuVasen = new Pivot(x, y + this.getPituus(), z);
        this.alaEtuOikea = new Pivot(x + this.getLeveys(), y + this.getPituus(), z);
        this.ylaEtuVasen = new Pivot(x, y + this.getPituus(), z + this.getKorkeus());
        this.ylaEtuOikea = new Pivot(x + this.getLeveys(), y + this.getPituus(), z + this.getKorkeus());

    }

    public Pivot getAlaTakaOikea() {
        return this.alaTakaOikea;
    }
    
    public Pivot getAlaTakaVasen() {
        return this.alaTakaVasen;
    }
    
    public Pivot getAlaEtuVasen() {
        return this.alaEtuVasen;
    }

    public Pivot getYlaTakaVasen() {
        return this.ylaTakaVasen;
    }
    
    public Pivot getPivot() {
        return this.pivot;
    }




}
