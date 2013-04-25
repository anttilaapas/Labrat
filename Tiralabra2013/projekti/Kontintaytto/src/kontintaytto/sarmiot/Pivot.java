/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kontintaytto.sarmiot;

/**
 *
 * @author antti
 */
public class Pivot {

    private int x;
    private int y;
    private int z;

    public Pivot() {
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }
    
    public Pivot(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void setPivot(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getZ() {
        return this.z;
    }
    
    @Override
    public String toString() {
        return "x: " + this.getX() + ", y: " + this.getY() + ", z: " + this.getZ();
        
    }
}
