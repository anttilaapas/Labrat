/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package miinaharava.kayttoliittyma;

import miinaharava.logiikka.Kello;
import miinaharava.logiikka.Peli;
import miinaharava.logiikka.Kentta;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 * @author Antti Laapas
 * @version 0.8
 * @since 2013-03-20
 */
public class Kayttoliittyma implements Runnable, ActionListener {

    private JFrame frame;
    private JButton aloita;
    private JRadioButton[] vaikeusaste;
    private ButtonGroup vaikeusasteRyhma;
    private JLabel aika;
    private Kello kello;
    private JTextField ruudukonKoko;
    private JTextField pituusKentta;
    private JButton[] ruudut;
    private Kentta kentta;
    private Peli peli;
    private JLabel lopputulos;
    private ArrayList<Integer> miinojenPaikat;
    private ArrayList<Integer> painetutRuudut;
    private int sivunPituus;
    private boolean peliOhi = true;
    private JPanel ruutuPanel = new JPanel();

    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void run() {
        frame = new JFrame("Miinaharava");
        frame.setPreferredSize(new Dimension(600, 400));
        // kielletään käyttöliittymän koon muuttaminen
        frame.setResizable(true);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        // asetetaan käyttöliittymä näkyväksi
        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container contentPane) {

        // haetaan leveys, pituus ja vaikeus käyttöliittymän
        // kentistä
        JLabel label1 = new JLabel("Sivun pituus: ");
        ruudukonKoko = new JTextField(3);

//        JLabel label2 = new JLabel("Pituus: ");
//        pituusKentta = new JTextField(3);

        JPanel vaikeus = new JPanel();
        vaikeusasteRyhma = new ButtonGroup();
        vaikeusaste = new JRadioButton[]{
            new JRadioButton("Helppo", true),
            new JRadioButton("Keskivaikea"),
            new JRadioButton("Vaikea")
        };
        
        for (int i = 0; i < vaikeusaste.length; i++) {
            vaikeusasteRyhma.add(vaikeusaste[i]);
            vaikeus.add(vaikeusaste[i]);
        }

        this.ruutuPanel.removeAll();

        this.aloita = new JButton("Aloita!");
        JPanel panel = new JPanel();

        panel.add(label1);
        panel.add(ruudukonKoko);

        panel.add(vaikeus);
        panel.add(aloita);

        contentPane.setLayout(new BorderLayout());

        contentPane.add(panel, BorderLayout.NORTH);
        this.aika = new JLabel("00:00");

        JPanel alarivi = new JPanel();
        alarivi.add(aika);

        lopputulos = new JLabel();
        alarivi.add(lopputulos);

        contentPane.add(alarivi, BorderLayout.SOUTH);

        aloita.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // jos painetaan Aloita-nappia
        if (e.getSource() == aloita && this.peliOhi) {

            // haetaan pelikenttien pituus ja leveys tekstikentistä
            sivunPituus = Integer.parseInt(this.ruudukonKoko.getText());

            int vaikeus = 0;
            this.peliOhi = false;

            // pelin vaikeusaste (miinojen lkm) saadaan valintanapista
            for (int i = 0; i < 3; i++) {
                if (vaikeusaste[i].isSelected()) {
                    vaikeus = i;
                }
            }

            piirraRuudukko(sivunPituus, sivunPituus);

            // luodaan taustalle ruudukko, johon on tallennettu miinojen paikka
            // sekä viereisten miinojen lukumäärä
            kentta = new Kentta(sivunPituus, sivunPituus, vaikeus);

            this.miinojenPaikat = kentta.miinojenPaikat();
            this.painetutRuudut = new ArrayList<Integer>();

            peli = new Peli(kentta);
            peli.aloita();

            this.lopputulos.setText("");

            // käynnistetään kello
            this.kello = new Kello(this.aika);
            this.kello.aloita();

            // jos painetaan jotain peliruutua, näytetään joko miina (punaisella taustalla)
            // tai miinojen lkm (valkoisella taustalla)
        } else {
            if (!peliOhi && e.getSource() != aloita) {
                int painettu = Integer.parseInt((String) e.getActionCommand());
                System.out.println(painettu);

                String vieressa;

                // jos painetaan miinaa
                if (peli.vieressaMiinoja(painettu) == -1) {
                    vieressa = miinaaPainettu(painettu);
                    ruudut[painettu].setText(vieressa);
                    havinneenViesti();
                    this.ruutuPanel.removeAll();
                    // jos painetaan ruutua, jonka vieressä ei ole miinoja
                } else if (peli.vieressaMiinoja(painettu) == 0) {
                    vieressa = eiViereisiaMiinoja(painettu);
                    ruudut[painettu].setText(vieressa);
                    // muutoin
                } else {
                    vieressa = vieressaMiinoja(painettu);
                    ruudut[painettu].setText(vieressa);
                }
                System.out.println("PAINETUT: " + this.painetutRuudut.size());
                
                voitonTarkistus();
            }
        }

    }

    public void voittaneenViesti() {
        JOptionPane.showMessageDialog(null, "OU JEE, SIE VOITIT!" + "\nAikaa ehti kulua " + kello.getSekunnit() + " sekuntia.", "Tulos", JOptionPane.INFORMATION_MESSAGE);
    }

    public void havinneenViesti() {
        JOptionPane.showMessageDialog(null, "ÖY NÖY, SIE HÄVISIT!" + "\nAikaa ehti kulua " + kello.getSekunnit() + " sekuntia\nja ehdit saada " + this.painetutRuudut.size() + " ruutua auki.", "Tulos", JOptionPane.INFORMATION_MESSAGE);
    }

    /*
     * Näyttää koko pelikentän miinat ja viereisten miinojen lukumäärän,
     * jos käyttäjä on painanut miinan kohtaa
     * 
     * @param   painettu   miinan kohta ruudukossa, jota on juuri painettu
     * 
     */
    private void naytaKokoKentta(int painettu) {
        for (int i = 0; i < this.sivunPituus * this.sivunPituus; i++) {
            String vieressa = "";
            if (i == painettu) {
                continue;
            }

            if (peli.vieressaMiinoja(i) == -1) {
                vieressa = "*";

            } else if (peli.vieressaMiinoja(i) == 0) {
                vieressa = "";
                ruudut[i].setBackground(Color.white);
            } else {
                vieressa = String.valueOf(peli.vieressaMiinoja(i));
            }


            ruudut[i].setText(vieressa);


        }
    }

    /*
     * Näyttää kaikki viereiset tyhjät kohdat peliruudukosta, jos käyttäjä
     * painaa ruutua, jonka vieressä miinaa ei ole. Näytetään myös tyhjien ruutujen
     * viereiset ruudut
     * 
     * @param   i   tyhjä kohta ruudukossa, jota käyttäjä on painanut
     * 
     */
    private void naytaViereisetTyhjat(int i) {

        int viereiset = peli.vieressaMiinoja(i);

        if (viereiset != 0) {
            ruudut[i].setText(String.valueOf(viereiset));
            if (!this.painetutRuudut.contains(i)) {
                this.painetutRuudut.add(i);
            }
        } else {
            if (!this.painetutRuudut.contains(i)) {
                ruudut[i].setBackground(Color.white);
                this.painetutRuudut.add(i);
                if (peli.onVasenYlakulma(i)) {
                    naytaViereisetTyhjat(i + 1);
                    naytaViereisetTyhjat(i + sivunPituus + 1);
                    naytaViereisetTyhjat(i + sivunPituus);
                } else if (peli.onOikeaYlakulma(i)) {
                    naytaViereisetTyhjat(i - 1);
                    naytaViereisetTyhjat(i + sivunPituus - 1);
                    naytaViereisetTyhjat(i + sivunPituus);
                } else if (peli.onVasenAlakulma(i)) {
                    naytaViereisetTyhjat(i + 1);
                    naytaViereisetTyhjat(i - sivunPituus + 1);
                    naytaViereisetTyhjat(i - sivunPituus);
                } else if (peli.onOikeaAlakulma(i)) {
                    naytaViereisetTyhjat(i - 1);
                    naytaViereisetTyhjat(i - sivunPituus - 1);
                    naytaViereisetTyhjat(i - sivunPituus);
                } else if (peli.onVasenReuna(i) && !peli.onVasenAlakulma(i)
                        && !peli.onVasenYlakulma(i)) {
                    naytaViereisetTyhjat(i - sivunPituus);
                    naytaViereisetTyhjat(i - sivunPituus + 1);
                    naytaViereisetTyhjat(i + 1);
                    naytaViereisetTyhjat(i + sivunPituus + 1);
                    naytaViereisetTyhjat(i + sivunPituus);
                } else if (peli.onOikeaReuna(i) && !peli.onOikeaAlakulma(i)
                        && !peli.onOikeaYlakulma(i)) {
                    naytaViereisetTyhjat(i - sivunPituus);
                    naytaViereisetTyhjat(i - sivunPituus - 1);
                    naytaViereisetTyhjat(i - 1);
                    naytaViereisetTyhjat(i + sivunPituus - 1);
                    naytaViereisetTyhjat(i + sivunPituus);
                } else if (peli.onAlareuna(i) && !peli.onVasenAlakulma(i)
                        && !peli.onOikeaAlakulma(i)) {
                    naytaViereisetTyhjat(i - 1);
                    naytaViereisetTyhjat(i - sivunPituus - 1);
                    naytaViereisetTyhjat(i - sivunPituus);
                    naytaViereisetTyhjat(i - sivunPituus + 1);
                    naytaViereisetTyhjat(i + 1);
                } else if (peli.onYlareuna(i) && !peli.onVasenYlakulma(i)
                        && !peli.onOikeaYlakulma(i)) {
                    naytaViereisetTyhjat(i - 1);
                    naytaViereisetTyhjat(i + sivunPituus - 1);
                    naytaViereisetTyhjat(i + sivunPituus);
                    naytaViereisetTyhjat(i + sivunPituus + 1);
                    naytaViereisetTyhjat(i + 1);
                } else if (peli.onKeskella(i)) {
                    naytaViereisetTyhjat(i - 1);
                    naytaViereisetTyhjat(i + sivunPituus - 1);
                    naytaViereisetTyhjat(i + sivunPituus);
                    naytaViereisetTyhjat(i + sivunPituus + 1);
                    naytaViereisetTyhjat(i - sivunPituus - 1);
                    naytaViereisetTyhjat(i - sivunPituus);
                    naytaViereisetTyhjat(i - sivunPituus + 1);
                    naytaViereisetTyhjat(i + 1);
                }
            }
        }

    }

    /*
     * piirretään leveys*pituus verran nappuloita, joista
     * muodostuu peliruudukko
     * 
     * @param   leveys   pelikentän leveys
     * @param   pituus   pelikentän pituus
     * 
     */
    // 
    public void piirraRuudukko(int leveys, int pituus) {

        ruudut = new JButton[leveys * pituus];
        GridLayout gridlayout = new GridLayout(leveys, pituus);

        this.ruutuPanel = new JPanel();

        ruutuPanel.setLayout(gridlayout);

        for (int i = 0; i < leveys * pituus; i++) {
            ruudut[i] = new JButton("");
            ruudut[i].addActionListener(this);
            ruudut[i].setActionCommand(String.valueOf(i));
            ruudut[i].addMouseListener(new HiirenKuuntelija());
            ruutuPanel.add(ruudut[i]);
        }
        frame.getContentPane().add(ruutuPanel, BorderLayout.CENTER);
    }

    public String miinaaPainettu(int painettu) {

        lopputulos.setText("HÄVISIT!");
        ruudut[painettu].setBackground(Color.red);
        naytaKokoKentta(painettu);
        this.peliOhi = true;
        kello.lopeta();


        return "*";
    }

    public String eiViereisiaMiinoja(int painettu) {

        ruudut[painettu].setBackground(Color.white);
        naytaViereisetTyhjat(painettu);
        return "";
    }

    public String vieressaMiinoja(int painettu) {

        if (!this.painetutRuudut.contains(painettu)) {
            this.painetutRuudut.add(painettu);
        }

        
        return String.valueOf(peli.vieressaMiinoja(painettu));
    }

    private void voitonTarkistus() {
        if (this.miinojenPaikat.size() + this.painetutRuudut.size() == (this.sivunPituus * this.sivunPituus)) {
            this.lopputulos.setText("VOITIT!");
            this.peliOhi = true;
            kello.lopeta();
            voittaneenViesti();
            this.ruutuPanel.removeAll();
        }
    }
}
