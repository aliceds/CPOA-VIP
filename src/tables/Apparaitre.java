/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tables;

/**
 *
 * @author Alice
 */
public class Apparaitre {
    private int ID_photo;
    private int numVIP;
    
    public Apparaitre() {
        
    }

    public Apparaitre(int ID_photo, int numVIP) {
        this.ID_photo = ID_photo;
        this.numVIP = numVIP;
    }

    public int getID_photo() {
        return ID_photo;
    }

    public void setID_photo(int ID_photo) {
        this.ID_photo = ID_photo;
    }

    public int getNumVIP() {
        return numVIP;
    }

    public void setNumVIP(int numVIP) {
        this.numVIP = numVIP;
    }
    
    
}
