/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package miinaharava;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
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
public class HiirenKuuntelija extends MouseAdapter {
    
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
    public void mouseClicked(MouseEvent e) {
        JButton nappi = (JButton) e.getSource();
        
        if (e.getButton() == MouseEvent.BUTTON3) {
            nappi.setText("O");
        }
        
    }
}
