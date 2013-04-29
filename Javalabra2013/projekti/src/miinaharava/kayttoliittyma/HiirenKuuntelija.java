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
 * @version     1.0
 * @since       2013-03-28
 */

public class HiirenKuuntelija extends MouseAdapter {
    
    
    
    @Override
    public void mouseClicked(MouseEvent e) {
        JButton nappi = (JButton) e.getSource();
        
        if (e.getButton() == MouseEvent.BUTTON3) {
            if (nappi.getText().equals("O")) {
                nappi.setText("");
            } else {
                nappi.setText("O");
            }
        }
    }
    
}
