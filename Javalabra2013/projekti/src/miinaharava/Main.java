/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package miinaharava;

import javax.swing.SwingUtilities;

/**
 *
 * @author antti
 */
public class Main {
    public static void main(String[] args) {
        Kayttoliittyma kayttoliittyma = new Kayttoliittyma();
        SwingUtilities.invokeLater(kayttoliittyma);
    }
}
