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

    private ArrayList<Paketti> paketit = new ArrayList<Paketti>();
    private Pivot pivot;
    private int[][][] koordinaatit;
    private int lkm = 0;
    private long tayttamisenVievaAika;

    public Kontti(int leveys, int pituus, int korkeus) {
        super(leveys, pituus, korkeus);
        this.pivot = new Pivot();
        this.tayttamisenVievaAika = 0;
        this.koordinaatit = new int[leveys+1][pituus+1][korkeus+1];
    }

    public boolean mahtuu(Pivot piste, Paketti paketti) {

        if ((piste.getX() + paketti.getLeveys() > this.getLeveys()) || (piste.getY() + paketti.getPituus() > this.getPituus()) || (piste.getZ() + paketti.getKorkeus() > this.getKorkeus())) {
            return false;
        }

        for (int i = piste.getX(); i < piste.getX() + paketti.getLeveys(); i++) {
            for (int j = piste.getY(); j < piste.getY() + paketti.getPituus(); j++) {
                for (int k = piste.getZ(); k < piste.getZ() + paketti.getKorkeus(); k++) {

                    if (this.koordinaatit[i][j][k] == -1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public void lisaaKonttiin(Pivot piste, Paketti paketti) {
        this.paketit.add(paketti);
        paketti.asetaPisteeseen(piste.getX(), piste.getY(), piste.getZ());
        tayta(piste, paketti);
    }

    public void tayta(Pivot piste, Paketti paketti) {
//        long alku = System.nanoTime();
        for (int i = piste.getX(); i < piste.getX() + paketti.getLeveys(); i++) {
            for (int j = piste.getY(); j < piste.getY() + paketti.getPituus(); j++) {
                for (int k = piste.getZ(); k < piste.getZ() + paketti.getKorkeus(); k++) {
                    this.koordinaatit[i][j][k] = -1;
                }
            }
        }
//        long loppu = System.nanoTime();
//        this.tayttamisenVievaAika = this.tayttamisenVievaAika + (loppu - alku) / 1000000000;
    }

    public ArrayList<Paketti> sisalto() {
        return this.paketit;
    }
    
    public long tayttamiseenMeni() {
        return this.tayttamisenVievaAika;
    }
}
//        int maxLev = piste.getX() + paketti.getLeveys();
//        int maxPit = piste.getY() + paketti.getPituus();
//        int maxKor = piste.getZ() + paketti.getKorkeus();
//        //System.out.println("mahtuu(): " + maxLev + ", " + maxPit + ", " + maxKor);
//        //System.out.println("mitat: " + this.getLeveys() + ", " + this.getPituus() + ", " + this.getKorkeus());
//        lkm++;                   //System.out.println("i: " + i + ", j: " + j + ", k: " + k);
//        int maxLev = piste.getX() + paketti.getLeveys();
//        int maxPit = piste.getY() + paketti.getPituus();
//        int maxKor = piste.getZ() + paketti.getKorkeus();
//        //System.out.println(lkm + "tayta(): " + maxLev + ", " + maxPit + ", " + maxKor);
                    //System.out.println("i: " + i + ", j: " + j + ", k: " + k);
//        if (this.getLeveys() < this.getKorkeus() && this.getLeveys() < this.getPituus()) {
//            this.orderByWidth = true;
//            this.orderByLength = false;
//            this.orderByHeight = false;
//            
//        } else if (this.getPituus() < this.getKorkeus() && this.getPituus() < this.getLeveys()) {
//            this.orderByWidth = false;
//            this.orderByLength = true;
//            this.orderByHeight = false;
//            
//        } else if (this.getKorkeus() < this.getLeveys() && this.getKorkeus() < this.getPituus()) {
//            this.orderByWidth = false;
//            this.orderByLength = false;
//            this.orderByHeight = true;
//            
//        }
//   if (binWidth is smaller than binHeight
//and binDepth) then
//    {
//    packByWidth=true
//    packByHeight=false;
//    }
//else if (binDepth is smaller than
//binHeight and binWidth) then
//    {
//    packByWidth=false
//    packByHeight=false //both false
//    implies pack by depth
//    }
//else if (binHeight is smaller than
//binWidth and binDepth) then
//
//    {
//    packByWidth=false
//    packByHeight=true
//    }
//        if (this.orderByWidth == true) {
//            this.pivot.setPivot(pivot.getX() + p.getLeveys(), pivot.getY(), pivot.getZ());
//        } else if (this.orderByLength == true) {
//            this.pivot.setPivot(pivot.getX(), pivot.getY() + p.getPituus(), pivot.getZ());
//        } else if (this.orderByHeight == true) {
//            this.pivot.setPivot(pivot.getX(), pivot.getY(), pivot.getZ() + p.getKorkeus());
//        }