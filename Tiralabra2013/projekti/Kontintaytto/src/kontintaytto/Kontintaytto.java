/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kontintaytto;

import kontintaytto.sarmiot.Pivot;
import kontintaytto.tiedot.KonttienTiedot;
import kontintaytto.tiedot.PakettienMaara;
import kontintaytto.sarmiot.Kontti;
import kontintaytto.sarmiot.Paketti;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author antti
 */
public class Kontintaytto {

    private ArrayList<Kontti> konttiLista = new ArrayList<Kontti>();
    private KonttienTiedot kontit;
    private PakettienMaara paketit;

    private ArrayList<Paketti> pakkaamattomat = new ArrayList<Paketti>();
    private ArrayList<Paketti> pakattavat = new ArrayList<Paketti>();

    /**
     * @param args the command line arguments
     */

    public Kontintaytto(KonttienTiedot kontit, PakettienMaara paketit) {
        this.kontit = kontit;
        this.paketit = paketit;
    }

    public void pakettilistanTeko() {
        int kaikkienPakettienMaara = paketit.kaikkienPakettienMaara();
//        pakkaamattomat = new Paketti[kaikkienPakettienMaara];
        //System.out.println("kaikkien pakettien määrä: " + kaikkienPakettienMaara);

        int paketteja1 = paketit.pakettienMaara(1);
        int paketteja2 = paketit.pakettienMaara(2);
        int paketteja3 = paketit.pakettienMaara(3);

        Paketti paketti1 = paketit.getPaketti(1);
        Paketti paketti2 = paketit.getPaketti(2);
        Paketti paketti3 = paketit.getPaketti(3);

        //for (int i = 0; i < kaikkienPakettienMaara; i++) {

//            int indx = 0;
        for (int j = 0; j < paketteja1; j++) {
            pakkaamattomat.add(new Paketti(paketti1.getLeveys(), paketti1.getPituus(), paketti1.getKorkeus()));
//                pakkaamattomat[indx] = new Paketti(paketti1.getLeveys(), paketti1.getPituus(), paketti1.getKorkeus());
//                indx++;
        }

        for (int k = 0; k < paketteja2; k++) {
            pakkaamattomat.add(new Paketti(paketti2.getLeveys(), paketti2.getPituus(), paketti2.getKorkeus()));
//                pakkaamattomat[indx] = new Paketti(paketti2.getLeveys(), paketti2.getPituus(), paketti2.getKorkeus());
//                indx++;
        }

        for (int l = 0; l < paketteja3; l++) {
            pakkaamattomat.add(new Paketti(paketti3.getLeveys(), paketti3.getPituus(), paketti3.getKorkeus()));
//                pakkaamattomat[indx] = new Paketti(paketti3.getLeveys(), paketti3.getPituus(), paketti3.getKorkeus());
//                indx++;
        }

        //System.out.println("pakkaamattomien koko: " + this.pakkaamattomat.size());
        //}
    }

    public int getKonttiListanKoko() {
        return this.konttiLista.size();
    }

    public void tayta() {

        this.pakettilistanTeko();
        
        do {
            
            Pivot pivot = new Pivot(0, 0, 0);
            this.pakattavat = this.pakkaamattomat;
            this.pakkaamattomat = new ArrayList<Paketti>();

            Kontti currKontti = new Kontti(kontit.getKontti().getLeveys(), kontit.getKontti().getPituus(), kontit.getKontti().getKorkeus());
            this.konttiLista.add(currKontti);

            currKontti.lisaaKonttiin(pivot, this.pakattavat.get(0));

            for (int i = 1; i < pakattavat.size(); i++) {
                
                Paketti pakattava = this.pakattavat.get(i);
                boolean mahtui = false;

                for (int p = 0; p < 3; p++) {

                    int k = 0;

                    while (k < currKontti.sisalto().size() && !mahtui) {
                        Paketti konttiTavara = currKontti.sisalto().get(k);

                        pivot = laskePivot(p, konttiTavara);
                        //System.out.println("pivot: " + pivot.toString());
                        // System.out.println("konttitavara " + konttiTavara.getAlaEtuVasen().getX());
                        //System.out.println("Pivot:");
                        //System.out.println("Pivot:" + pivot.getX());

                        if (currKontti.mahtuu(pivot, pakattava)) {
                            currKontti.lisaaKonttiin(pivot, pakattava);
                            mahtui = true;
                        } else {
                            for (int j = 0; j < 6; j++) {
                                pakattava.rotatoi(j);

                                if (currKontti.mahtuu(pivot, pakattava)) {
                                    currKontti.lisaaKonttiin(pivot, pakattava);
                                    mahtui = true;
                                    break;
                                }
                            }
                        }
                        k++;
                    }

                }
                if (!mahtui) {
                    pakattava.asetaAlkuperainenRotaatio();
                    this.pakkaamattomat.add(pakattava);
                }
            }
        } while (!this.pakkaamattomat.isEmpty());

//        System.out.println("pakkaamattomat " + pakkaamattomat.size());
//        System.out.println("pakatut " + pakattavat.size());

    }

    public Pivot laskePivot(int p, Paketti curr) {

        Pivot pivot = new Pivot();
        //System.out.println("pivotin äksä " + pivot.getX());

        if (p == 0) {
            pivot = curr.getAlaTakaOikea();
        } else if (p == 1) {
            pivot = curr.getAlaEtuVasen();
        } else if (p == 2) {
            pivot = curr.getYlaTakaVasen();
        }

        return pivot;
    }
    
    public void konttienInformaatio() {
        for (Kontti k : this.konttiLista) {
            int pakettienTilavuus = 0;
            int pakettienMaara = k.sisalto().size();
            
            int i = 0;
            for (Paketti p : k.sisalto()) {
                pakettienTilavuus += p.getTilavuus();
                System.out.println(i + ": " + p.getAlaTakaVasen());
                i++;
            }
            System.out.println("Kontin koko: " + k.getTilavuus() + ", pakettien tilavuus: " + pakettienTilavuus + ", pakettien määrä: " + pakettienMaara);
        }
    }
}