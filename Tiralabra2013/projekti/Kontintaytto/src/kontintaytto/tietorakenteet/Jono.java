/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kontintaytto.tietorakenteet;

/**
 *
 * @author antti
 */
public class Jono<T> {
    
    private int size;
    private T first;
    private T last;
    
    public Jono() {
        this.size = 0;
    }
    
    public void add(T item) {
        if (this.isEmpty()) {
            this.first = item;
            this.last = item;
        }
    }
    
    public int size() {
        return this.size;
    }
    
    public boolean isEmpty() {
        
        if (this.size == 0) {
            return true;
        }
        
        return false;
        
    }
    
    
}
