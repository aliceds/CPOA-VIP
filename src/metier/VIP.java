package metier;

import java.time.LocalDate;

/**
 * table VIP
 * @author Alice
 */
public class VIP {

    private int numVIP;
    private String nom;
    private String prenom;
    private String civilite;
    private LocalDate datenaissance;
    private String lieunaissance;
    private String role;
    private String statut;
    private String pays;

    public VIP() {
    }

    public VIP(int numVIP, String nom, String prenom, String civilite, LocalDate datenaissance, String lieunaissance, String role, String statut, String pays) {
        this.numVIP = numVIP;
        this.nom = nom;
        this.prenom = prenom;
        this.civilite = civilite;
        this.datenaissance = datenaissance;
        this.lieunaissance = lieunaissance;
        this.role = role;
        this.statut = statut;
        this.pays = pays;
    }

    public int getNumVIP() {
        return numVIP;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getCivilite() {
        return civilite;
    }

    public LocalDate getDatenaissance() {
        return datenaissance;
    }

    public String getLieunaissance() {
        return lieunaissance;
    }

    public String getRole() {
        return role;
    }

    public String getStatut() {
        return statut;
    }

    public String getPays() {
        return pays;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setCivilite(String civilite) {
        this.civilite = civilite;
    }

    public void setDatenaissance(LocalDate datenaissance) {
        this.datenaissance = datenaissance;
    }

    public void setLieunaissance(String lieunaissance) {
        this.lieunaissance = lieunaissance;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    
}
