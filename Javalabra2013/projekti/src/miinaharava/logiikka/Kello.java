/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package miinaharava.logiikka;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 * @author      Antti Laapas
 * @version     0.8
 * @since       2013-03-20
 */


// Täällä käy kello, joka näyttää, kuinka paljon on aikaa kulunut
public class Kello implements ActionListener {
    public Timer timer;
    
    public JLabel aika;
    private int counter;
    
    // testikonstruktori
    public Kello() {
        this.timer = new Timer(1000, this);
        this.counter = 0;
    }
    
    public Kello(JLabel aika) {
        this.timer = new Timer(1000, this);
        this.aika = aika;
        this.counter = 0;
    }
    
    public int getSekunnit() {
        return this.counter - 1;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        aika.setText(getAika(counter++));
    }

    public String getAika(int sekunnit) {
        int min = sekunnit / 60;
        int sec = sekunnit - (60 * min);
        
        StringBuffer teksti = new StringBuffer();
        
        if (min < 1) {
            teksti.append(0);
        }
        
        teksti.append(min);
        teksti.append(":");
        
        if (sec < 10) {
            teksti.append(0);
        }
        
        teksti.append(sec);
        
        return teksti.toString();
    }

    public void aloita() {
        timer.start();
    }
    
    public void lopeta() {
        timer.stop();
    }
    
}
