/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package miinaharava.logiikka;

import miinaharava.logiikka.Kentta;

/**
 * @author      Antti Laapas
 * @version     0.8
 * @since       2013-03-15
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
 * Metodi kertoo, onko 
 * 
 */
                    
    public boolean onMiina(int i) {
        if (ruudukko[i] == -1) {
            return true;
        }
        return false;
    }

    public boolean onAlareuna(int i) {
        if (((i + this.leveys) / this.leveys) == this.pituus) {
            return true;
        }
        return false;
    }

    public boolean onYlareuna(int i) {
        if (i - this.leveys < 0) {
            return true;
        }
        return false;
    }

    public boolean onVasenReuna(int i) {
        if ((i + 1) % this.leveys == 1) {
            return true;
        }
        return false;
    }
    
    public boolean onOikeaReuna(int i) {
        if ((i + 1) % this.leveys == 0) {
            return true;
        }
        return false;
    }

    public boolean onVasenYlakulma(int i) {
        if (i == 0) {
            return true;
        }
        return false;
    }

    public boolean onVasenAlakulma(int i) {
        if ((i + 1) % leveys == 1 && (i+leveys) / leveys == pituus) {
            return true;
        }
        return false;
    }

    public boolean onOikeaYlakulma(int i) {
        if ((i + 1) % leveys == 0 && (i - leveys) < 0) {
            return true;
        }
        return false;
    }
    
    public boolean onOikeaAlakulma(int i) {
        if ((i + 1) % leveys == 0 && (i+leveys) / leveys == pituus) {
            return true;
        }
        return false;
    }

    // täällä kerrotaan, kuinka monta miinaa viereisessä ruudussa on
    public int vieressaMiinoja(int i) {
        return ruudukko[i];
    }

    // asetetaan, kuinka monta miinaa on tämän ruudun viereisissä ruuduissa
    public void viereisetRuudut() {
        for (int i = 0; i < ruudukko.length; i++) {
            //System.out.println(i + " on vasen reuna: " + onVasenReuna(i));
//            System.out.println(i + " on oikea reuna: " + onOikeaReuna(i));
//            System.out.println(i + " on ylareuna: " + onYlareuna(i));
//            System.out.println(i + " on alareuna: " + onAlareuna(i));
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
//        for (int i = 0; i < ruudukko[0].length; i++) {
//            System.out.print((i) + "");
//            for (int j = 0; j < ruudukko.length; j++) {
//                ruudukko[j][i] = vieressaMiinoja(ruudukko, j, i);
//            }
//            System.out.println("");
//        }
    }

    public void aloita() {
        this.viereisetRuudut();
        kentta.tulostaRuudukko();
    }

    public boolean onKeskella(int i) {
        if (!onAlareuna(i) && !onYlareuna(i) && !onVasenReuna(i) && !onOikeaReuna(i)) {
            return true;
        }
        return false;
    }
}
