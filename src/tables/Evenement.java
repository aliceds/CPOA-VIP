/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tables;

/**
 * table evenement
 * mariages entre vip1 et vip2
 * si encore mariés, date_divorce = null
 * @author Alice
 */
public class Evenement {
    int numVIP1;
    int date_mariage;
    int numVIP2;
    String lieu_mariage;
    int date_divorce;
    
    public Evenement() {
    }

    public Evenement(int numVIP1, int date_mariage, int numVIP2, String lieu_mariage, int date_divorce) {
        this.numVIP1 = numVIP1;
        this.date_mariage = date_mariage;
        this.numVIP2 = numVIP2;
        this.lieu_mariage = lieu_mariage;
        this.date_divorce = date_divorce;
    }

    public int getNumVIP1() {
        return numVIP1;
    }

    public void setNumVIP1(int numVIP1) {
        this.numVIP1 = numVIP1;
    }

    public int getDate_mariage() {
        return date_mariage;
    }

    public void setDate_mariage(int date_mariage) {
        this.date_mariage = date_mariage;
    }

    public int getNumVIP2() {
        return numVIP2;
    }

    public void setNumVIP2(int numVIP2) {
        this.numVIP2 = numVIP2;
    }

    public String getLieu_mariage() {
        return lieu_mariage;
    }

    public void setLieu_mariage(String lieu_mariage) {
        this.lieu_mariage = lieu_mariage;
    }

    public int getDate_divorce() {
        return date_divorce;
    }

    public void setDate_divorce(int date_divorce) {
        this.date_divorce = date_divorce;
    }
    
    
    
}
