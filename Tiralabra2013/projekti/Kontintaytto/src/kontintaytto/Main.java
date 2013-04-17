/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kontintaytto;

import java.util.Scanner;

/**
 *
 * @author antti
 */
public class Main {

    

    public static void main(String[] args) {
        
        Scanner lukija = new Scanner(System.in);
        
        PakettienMaara paketit = new PakettienMaara(lukija);
        paketit.laatikoidenKyselija();
        
        
        KonttienTiedot kontit = new KonttienTiedot(lukija);
        kontit.konttienKyselija();
        
        System.out.println("Kontin koko: " + kontit.kontinTilavuus());
        
        
        System.out.println("1-laatikkoja: " + paketit.pakettienMaara(1));
        System.out.println("1-laatikkojen tilavuus: " + paketit.getPaketti(1).getTilavuus() * paketit.pakettienMaara(1));
        
        System.out.println("2-laatikkoja: " + paketit.pakettienMaara(2));
        System.out.println("2-laatikkojen tilavuus: " + paketit.getPaketti(2).getTilavuus() * paketit.pakettienMaara(2));
        
        System.out.println("3-laatikkoja: " + paketit.pakettienMaara(3));
        System.out.println("3-laatikkojen tilavuus: " + paketit.getPaketti(3).getTilavuus() * paketit.pakettienMaara(3));
        
        System.out.println("Laatikoita yhteensä: " + paketit.kaikkienPakettienMaara());
    }
}
