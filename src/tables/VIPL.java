/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tables;

/**
 * table VIP
 * vip célibataire donc statut = 'L'
 * @author Alice
 */
public class VIPL {
    private int numVIP;
    private String nom;
    private String prenom;

    public VIPL() {
    }

    public VIPL(int numVIP, String nom, String prenom) {
        this.numVIP = numVIP;
        this.nom = nom;
        this.prenom = prenom;
    }

    public int getNumVIP() {
        return numVIP;
    }

    public void setNumVIP(int numVIP) {
        this.numVIP = numVIP;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    
    
    
}
