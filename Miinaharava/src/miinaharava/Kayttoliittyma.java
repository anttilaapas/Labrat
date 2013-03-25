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

    @Override
    public void run() {
        frame = new JFrame("Miinaharava");
        frame.setPreferredSize(new Dimension(600, 400));
        // kielletään käyttöliittymän koon muuttaminen
        frame.setResizable(false);


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
        if (e.getSource() == aloita) {
            
            int leveys = Integer.parseInt(this.leveysKentta.getText());
            int pituus = Integer.parseInt(this.pituusKentta.getText());
            int vaikeus = 0;

            for (int i = 0; i < 3; i++) {
                if (vaikeusaste[i].isSelected()) {
                    vaikeus = i;
                }
            }
            
            ruudut = new JButton[leveys*pituus];
            
            GridLayout gridlayout = new GridLayout(leveys, pituus);
            
            JPanel ruutuPanel = new JPanel();
            ruutuPanel.setLayout(gridlayout);
            
            for (int i=0; i < leveys*pituus; i++) {
                ruudut[i] = new JButton("");
                ruudut[i].addActionListener(this);
                ruudut[i].setActionCommand(String.valueOf(i));
                ruutuPanel.add(ruudut[i]);
            }
            frame.getContentPane().add(ruutuPanel, BorderLayout.CENTER);

            kentta = new Kentta(leveys, pituus, vaikeus);

            kentta.tulostaRuudukko();

            peli = new Peli(kentta);
            peli.aloita();
            
            this.kello = new Kello(this.aika);
            this.kello.aloita();
        } else {
            int painettu = Integer.parseInt((String) e.getActionCommand());
            System.out.println(painettu);
            
            String vieressa;
            
            if (peli.vieressaMiinoja(painettu) == -1) {
                vieressa = "*";
                lopputulos.setText("HÄVISIT!");
                ruudut[painettu].setBackground(Color.red);
                kello.lopeta();
                
            } else {
                vieressa = String.valueOf(peli.vieressaMiinoja(painettu));
                ruudut[painettu].setBackground(Color.white);
            }
            
            ruudut[painettu].setText(vieressa);
            
        }
    }
}
