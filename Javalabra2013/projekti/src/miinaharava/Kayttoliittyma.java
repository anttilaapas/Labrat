/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package miinaharava;

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
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 *
 * @author antti
 */
public class Kayttoliittyma implements Runnable, ActionListener {

    private JFrame frame;
    private JButton aloita;
    private JRadioButton[] vaikeusaste;
    private ButtonGroup vaikeusasteRyhma;
    private JLabel aika;
    private Kello kello;
    private JTextField leveysKentta;
    private JTextField pituusKentta;
    private JButton[] ruudut;
    private Kentta kentta;
    private Peli peli;
    private JLabel lopputulos;
    private ArrayList<Integer> miinojenPaikat;
    private ArrayList<Integer> painetutRuudut;
    private int leveys;
    private int pituus;
    private boolean peliOhi;

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
        JLabel label1 = new JLabel("Leveys: ");
        leveysKentta = new JTextField(3);

        JLabel label2 = new JLabel("Pituus: ");
        pituusKentta = new JTextField(3);

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

        this.aloita = new JButton("Aloita!");

        JPanel panel = new JPanel();

        panel.add(label1);
        panel.add(leveysKentta);
        panel.add(label2);
        panel.add(pituusKentta);
        //panel.add(label3);
        panel.add(vaikeus);
        panel.add(aloita);

        contentPane.setLayout(new BorderLayout());

        //contentPane.add(label1, BorderLayout.NORTH);
        //contentPane.add(leveys, BorderLayout.NORTH);
        //contentPane.add(label2, BorderLayout.NORTH);
        //contentPane.add(pituus, BorderLayout.NORTH);
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
        if (e.getSource() == aloita) {

            // haetaan pelikenttien pituus ja leveys tekstikentistä
            leveys = Integer.parseInt(this.leveysKentta.getText());
            pituus = Integer.parseInt(this.pituusKentta.getText());
            int vaikeus = 0;
            this.peliOhi = false;

            // pelin vaikeusaste (miinojen lkm) saadaan valintanapista
            for (int i = 0; i < 3; i++) {
                if (vaikeusaste[i].isSelected()) {
                    vaikeus = i;
                }
            }

            piirraRuudukko(leveys, pituus);

            // luodaan taustalle ruudukko, johon on tallennettu miinojen paikka
            // sekä viereisten miinojen lukumäärä
            kentta = new Kentta(leveys, pituus, vaikeus);

            this.miinojenPaikat = kentta.miinojenPaikat();
            this.painetutRuudut = new ArrayList<Integer>();

            peli = new Peli(kentta);
            peli.aloita();

            // käynnistetään kello
            this.kello = new Kello(this.aika);
            this.kello.aloita();

            // jos painetaan jotain peliruutua, näytetään joko miina (punaisella taustalla)
            // tai miinojen lkm (valkoisella taustalla)
        } else {
            if (!peliOhi) {
                int painettu = Integer.parseInt((String) e.getActionCommand());
                System.out.println(painettu);

                String vieressa;

                // jos painetaan miinaa
                if (peli.vieressaMiinoja(painettu) == -1) {
                    vieressa = miinaaPainettu(painettu);
                // jos painetaan ruutua, jonka vieressä ei ole miinoja
                } else if (peli.vieressaMiinoja(painettu) == 0) {
                    vieressa = eiViereisiaMiinoja(painettu);
                // muutoin
                } else {
                    vieressa = vieressaMiinoja(painettu);

                }
                System.out.println("PAINETUT: " + this.painetutRuudut.size());
                ruudut[painettu].setText(vieressa);
            }
        }

    }

    private void naytaKokoKentta(int painettu) {
        for (int i = 0; i < this.leveys * this.pituus; i++) {
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
                    naytaViereisetTyhjat(i + leveys + 1);
                    naytaViereisetTyhjat(i + leveys);
                } else if (peli.onOikeaYlakulma(i)) {
                    naytaViereisetTyhjat(i - 1);
                    naytaViereisetTyhjat(i + leveys - 1);
                    naytaViereisetTyhjat(i + leveys);
                } else if (peli.onVasenAlakulma(i)) {
                    naytaViereisetTyhjat(i + 1);
                    naytaViereisetTyhjat(i - leveys + 1);
                    naytaViereisetTyhjat(i - leveys);
                } else if (peli.onOikeaAlakulma(i)) {
                    naytaViereisetTyhjat(i - 1);
                    naytaViereisetTyhjat(i - leveys - 1);
                    naytaViereisetTyhjat(i - leveys);
                } else if (peli.onVasenReuna(i) && !peli.onVasenAlakulma(i)
                        && !peli.onVasenYlakulma(i)) {
                    naytaViereisetTyhjat(i - leveys);
                    naytaViereisetTyhjat(i - leveys + 1);
                    naytaViereisetTyhjat(i + 1);
                    naytaViereisetTyhjat(i + leveys + 1);
                    naytaViereisetTyhjat(i + leveys);
                } else if (peli.onOikeaReuna(i) && !peli.onOikeaAlakulma(i)
                        && !peli.onOikeaYlakulma(i)) {
                    naytaViereisetTyhjat(i - leveys);
                    naytaViereisetTyhjat(i - leveys - 1);
                    naytaViereisetTyhjat(i - 1);
                    naytaViereisetTyhjat(i + leveys - 1);
                    naytaViereisetTyhjat(i + leveys);
                } else if (peli.onAlareuna(i) && !peli.onVasenAlakulma(i)
                        && !peli.onOikeaAlakulma(i)) {
                    naytaViereisetTyhjat(i - 1);
                    naytaViereisetTyhjat(i - leveys - 1);
                    naytaViereisetTyhjat(i - leveys);
                    naytaViereisetTyhjat(i - leveys + 1);
                    naytaViereisetTyhjat(i + 1);
                } else if (peli.onYlareuna(i) && !peli.onVasenYlakulma(i)
                        && !peli.onOikeaYlakulma(i)) {
                    naytaViereisetTyhjat(i - 1);
                    naytaViereisetTyhjat(i + leveys - 1);
                    naytaViereisetTyhjat(i + leveys);
                    naytaViereisetTyhjat(i + leveys + 1);
                    naytaViereisetTyhjat(i + 1);
                } else if (peli.onKeskella(i)) {
                    naytaViereisetTyhjat(i - 1);
                    naytaViereisetTyhjat(i + leveys - 1);
                    naytaViereisetTyhjat(i + leveys);
                    naytaViereisetTyhjat(i + leveys + 1);
                    naytaViereisetTyhjat(i - leveys - 1);
                    naytaViereisetTyhjat(i - leveys);
                    naytaViereisetTyhjat(i - leveys + 1);
                    naytaViereisetTyhjat(i + 1);
                }
            }
        }

    }

    // piirretään leveys*pituus verran nappuloita, joista
    // muodostuu peliruudukko
    public void piirraRuudukko(int leveys, int pituus) {

        ruudut = new JButton[leveys * pituus];
        GridLayout gridlayout = new GridLayout(leveys, pituus);

        JPanel ruutuPanel = new JPanel();
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

        if (this.miinojenPaikat.size() + this.painetutRuudut.size() == (this.leveys * this.pituus)) {
            this.lopputulos.setText("VOITIT!");
            this.peliOhi = true;
        }
        return String.valueOf(peli.vieressaMiinoja(painettu));
    }
}
