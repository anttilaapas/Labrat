/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package miinaharava;

import miinaharava.kayttoliittyma.Kayttoliittyma;
import javax.swing.SwingUtilities;

/**
 * @author      Antti Laapas
 * @version     1.0
 * @since       2013-03-14
 */

public class Main {
    public static void main(String[] args) {
        Kayttoliittyma kayttoliittyma = new Kayttoliittyma();
        SwingUtilities.invokeLater(kayttoliittyma);
    }
}
