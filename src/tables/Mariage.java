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
public class Mariage {
    private int num1;
    private String nom1;
    private String prenom1;
    private int num2;
    private String nom2;
    private String prenom2;
    private String lieu_mariage;
    private int date_mariage;

    public Mariage() {
        
    }

    public Mariage(int num1, String nom1, String prenom1, int num2, String nom2, String prenom2, String lieu_mariage, int date_mariage) {
        this.num1 = num1;
        this.nom1 = nom1;
        this.prenom1 = prenom1;
        this.num2 = num2;
        this.nom2 = nom2;
        this.prenom2 = prenom2;
        this.lieu_mariage = lieu_mariage;
        this.date_mariage = date_mariage;
    }

    
    
    public String getNom1() {
        return nom1;
    }

    public void setNom1(String nom1) {
        this.nom1 = nom1;
    }

    public String getPrenom1() {
        return prenom1;
    }

    public void setPrenom1(String prenom1) {
        this.prenom1 = prenom1;
    }

    public String getNom2() {
        return nom2;
    }

    public void setNom2(String nom2) {
        this.nom2 = nom2;
    }

    public String getPrenom2() {
        return prenom2;
    }

    public void setPrenom2(String prenom2) {
        this.prenom2 = prenom2;
    }

    public String getLieu_mariage() {
        return lieu_mariage;
    }

    public void setLieu_mariage(String lieu_mariage) {
        this.lieu_mariage = lieu_mariage;
    }

    public int getDate_mariage() {
        return date_mariage;
    }

    public void setDate_mariage(int date_mariage) {
        this.date_mariage = date_mariage;
    }

    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }
    
    
}
