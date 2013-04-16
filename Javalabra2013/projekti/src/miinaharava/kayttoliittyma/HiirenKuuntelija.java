/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package miinaharava.kayttoliittyma;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 * @author      Antti Laapas
 * @version     0.7
 * @since       2013-03-25
 */

public class HiirenKuuntelija extends MouseAdapter {
    
    
    @Override
    public void mouseClicked(MouseEvent e) {
        JButton nappi = (JButton) e.getSource();
        
        if (e.getButton() == MouseEvent.BUTTON3) {
            nappi.setText("O");
        }
        
    }
}
