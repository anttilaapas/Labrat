/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package miinaharava.logiikka;

import miinaharava.logiikka.Kentta;

/**
 * @author Antti Laapas
 * @version 0.8
 * @since 2013-03-15
 */
public class Peli {

    private Kentta kentta;
    private int[] ruudukko;
    private int leveys;
    private int pituus;

    public Peli(Kentta kentta) {
        this.kentta = kentta;
        this.ruudukko = kentta.haeRuudukko();
        this.leveys = kentta.getLeveys();
        this.pituus = kentta.getPituus();
    }

    /*
     * Metodi kertoo, onko ruudussa miina
     * 
     * @param   i   ruutu, jota on painettu
     * 
     */
    public boolean onMiina(int i) {
        if (ruudukko[i] == -1) {
            return true;
        }
        return false;
    }

    /*
     * Metodi kertoo, onko indeksiä osoittava ruutu alareunassa
     * 
     * @param   i   indeksi ruudukossa
     * 
     */
    public boolean onAlareuna(int i) {
        if (((i + this.leveys) / this.leveys) == this.pituus) {
            return true;
        }
        return false;
    }

    /*
     * Metodi kertoo, onko indeksiä osoittava ruutu yläreunassa
     * 
     * @param   i   indeksi ruudukossa
     * 
     */
    public boolean onYlareuna(int i) {
        if (i - this.leveys < 0) {
            return true;
        }
        return false;
    }

    /*
     * Metodi kertoo, onko indeksiä osoittava ruutu vasemmassa reunassa
     * 
     * @param   i   indeksi ruudukossa
     * 
     */
    public boolean onVasenReuna(int i) {
        if ((i + 1) % this.leveys == 1) {
            return true;
        }
        return false;
    }

    /*
     * Metodi kertoo, onko indeksiä osoittava ruutu oikeassa reunassa
     * 
     * @param   i   indeksi ruudukossa
     * 
     */
    public boolean onOikeaReuna(int i) {
        if ((i + 1) % this.leveys == 0) {
            return true;
        }
        return false;
    }

    /*
     * Metodi kertoo, onko indeksiä osoittava ruutu vasemmassa yläkulmassa
     * 
     * @param   i   indeksi ruudukossa
     * 
     */
    public boolean onVasenYlakulma(int i) {
        if (i == 0) {
            return true;
        }
        return false;
    }

    /*
     * Metodi kertoo, onko indeksiä osoittava ruutu vasemmassa alakulmassa
     * 
     * @param   i   indeksi ruudukossa
     * 
     */
    public boolean onVasenAlakulma(int i) {
        if ((i + 1) % leveys == 1 && (i + leveys) / leveys == pituus) {
            return true;
        }
        return false;
    }

    /*
     * Metodi kertoo, onko indeksiä osoittava ruutu oikeassa yläkulmassa
     * 
     * @param   i   indeksi ruudukossa
     * 
     */
    public boolean onOikeaYlakulma(int i) {
        if ((i + 1) % leveys == 0 && (i - leveys) < 0) {
            return true;
        }
        return false;
    }

    /*
     * Metodi kertoo, onko indeksiä osoittava ruutu oikeassa alakulmassa
     * 
     * @param   i   indeksi ruudukossa
     * 
     */
    public boolean onOikeaAlakulma(int i) {
        if ((i + 1) % leveys == 0 && (i + leveys) / leveys == pituus) {
            return true;
        }
        return false;
    }

    /*
     * Kertoo, kuinka monta miinaa viereisessä ruudussa on
     * 
     * @param   i   indeksi ruudukossa
     * 
     */
    public int vieressaMiinoja(int i) {
        return ruudukko[i];
    }

    /*
     * Kertoo, onko indeksin osoittama ruutu keskellä (ei reunoilla)
     * 
     * @param   i   indeksi ruudukossa
     * 
     */
    public boolean onKeskella(int i) {
        if (!onAlareuna(i) && !onYlareuna(i) && !onVasenReuna(i) && !onOikeaReuna(i)) {
            return true;
        }
        return false;
    }

    /*
     * Asetetaan viereisten miinojen määrä kullekin ruudulle, missä miinaa
     * ei ole.
     * 
     */
    public void viereisetRuudut() {
        for (int i = 0; i < ruudukko.length; i++) {
            if (!onMiina(i)) {
                if (onVasenReuna(i)) {
                    if (onYlareuna(i)) {
                        if (ruudukko[i + 1] == -1) {
                            ruudukko[i]++;
                        }
                        if (ruudukko[i + leveys] == -1) {
                            ruudukko[i]++;
                        }
                        if (ruudukko[i + leveys + 1] == -1) {
                            ruudukko[i]++;
                        }
                    } else if (onAlareuna(i)) {
                        if (ruudukko[i - leveys] == -1) {
                            ruudukko[i]++;
                        }
                        if (ruudukko[i - leveys + 1] == -1) {
                            ruudukko[i]++;
                        }
                        if (ruudukko[i + 1] == -1) {
                            ruudukko[i]++;
                        }
                    } else {
                        if (ruudukko[i - leveys] == -1) {
                            ruudukko[i]++;
                        }
                        if (ruudukko[i - leveys + 1] == -1) {
                            ruudukko[i]++;
                        }
                        if (ruudukko[i + 1] == -1) {
                            ruudukko[i]++;
                        }
                        if (ruudukko[i + leveys] == -1) {
                            ruudukko[i]++;
                        }
                        if (ruudukko[i + leveys + 1] == -1) {
                            ruudukko[i]++;
                        }
                    }
                } else if (onOikeaReuna(i)) {
                    if (onYlareuna(i)) {
                        if (ruudukko[i - 1] == -1) {
                            ruudukko[i]++;
                        }
                        if (ruudukko[i + leveys - 1] == -1) {
                            ruudukko[i]++;
                        }
                        if (ruudukko[i + leveys] == -1) {
                            ruudukko[i]++;
                        }
                    } else if (onAlareuna(i)) {
                        if (ruudukko[i - 1] == -1) {
                            ruudukko[i]++;
                        }
                        if (ruudukko[i - leveys - 1] == -1) {
                            ruudukko[i]++;
                        }
                        if (ruudukko[i - leveys] == -1) {
                            ruudukko[i]++;
                        }
                    } else {
                        if (ruudukko[i - leveys] == -1) {
                            ruudukko[i]++;
                        }
                        if (ruudukko[i - leveys - 1] == -1) {
                            ruudukko[i]++;
                        }
                        if (ruudukko[i - 1] == -1) {
                            ruudukko[i]++;
                        }
                        if (ruudukko[i + leveys - 1] == -1) {
                            ruudukko[i]++;
                        }
                        if (ruudukko[i + leveys] == -1) {
                            ruudukko[i]++;
                        }
                    }
                } else if (onKeskella(i)) {
                    if (ruudukko[i - 1] == -1) {
                        ruudukko[i]++;
                    }
                    if (ruudukko[i - leveys - 1] == -1) {
                        ruudukko[i]++;
                    }
                    if (ruudukko[i - leveys] == -1) {
                        ruudukko[i]++;
                    }
                    if (ruudukko[i - leveys + 1] == -1) {
                        ruudukko[i]++;
                    }
                    if (ruudukko[i + 1] == -1) {
                        ruudukko[i]++;
                    }
                    if (ruudukko[i + leveys + 1] == -1) {
                        ruudukko[i]++;
                    }
                    if (ruudukko[i + leveys] == -1) {
                        ruudukko[i]++;
                    }
                    if (ruudukko[i + leveys - 1] == -1) {
                        ruudukko[i]++;
                    }
                } else if (onAlareuna(i) && !onVasenReuna(i) && !onOikeaReuna(i)) {
                    if (ruudukko[i - 1] == -1) {
                        ruudukko[i]++;
                    }
                    if (ruudukko[i - leveys - 1] == -1) {
                        ruudukko[i]++;
                    }
                    if (ruudukko[i - leveys] == -1) {
                        ruudukko[i]++;
                    }
                    if (ruudukko[i - leveys + 1] == -1) {
                        ruudukko[i]++;
                    }
                    if (ruudukko[i + 1] == -1) {
                        ruudukko[i]++;
                    }
                } else if (onYlareuna(i) && !onVasenReuna(i) && !onOikeaReuna(i)) {
                    if (ruudukko[i - 1] == -1) {
                        ruudukko[i]++;
                    }
                    if (ruudukko[i + leveys - 1] == -1) {
                        ruudukko[i]++;
                    }
                    if (ruudukko[i + leveys] == -1) {
                        ruudukko[i]++;
                    }
                    if (ruudukko[i + leveys + 1] == -1) {
                        ruudukko[i]++;
                    }
                    if (ruudukko[i + 1] == -1) {
                        ruudukko[i]++;
                    }
                }
            }
        }
    }

    /*
     * Alustetaan pelitaulukkoon viereiset ruudut
     * 
     */
    public void aloita() {
        this.viereisetRuudut();
    }
}
