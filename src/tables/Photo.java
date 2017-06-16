/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tables;

import java.io.File;

/**
 *
 * @author Alice
 */
public class Photo {
    private int ID_photo;
    private String nom_fichier;

    public Photo(int ID_photo, String nom_fichier) {
        this.ID_photo = ID_photo;
        this.nom_fichier = nom_fichier;
    }
    
    public Photo() {
        
    }

    public int getID_photo() {
        return ID_photo;
    }

    public void setID_photo(int ID_photo) {
        this.ID_photo = ID_photo;
    }

    public String getNom_fichier() {
        return nom_fichier;
    }

    public void setNom_fichier(String nom_fichier) {
        this.nom_fichier = nom_fichier;
    }

   
    
}
