/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesAuxDonnees;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import tables.VIP;
import tables.VIPPhoto;

/**
 *
 * @author Alice
 */
public class DaoVIP {

    private final Connection connexion;

    public DaoVIP(Connection connexion) {
        this.connexion = connexion;
    }

    /**
     * récupère la liste des VIP dans la liste entrée en paramètre
     * @param lesVIP
     * @throws SQLException 
     */
    public void lireLesVIP(List<VIP> lesVIP) throws SQLException {
        String requete = "select * from VIP";
        PreparedStatement pstmt = connexion.prepareStatement(requete);
        ResultSet rset = pstmt.executeQuery(requete);
        while (rset.next()) {
            int numVIP = rset.getInt(1);
            String nom = rset.getString(2);
            String prenom = rset.getString(3);
            String civilite = rset.getString(4);
            LocalDate datenaissance = rset.getDate(5).toLocalDate();
            String lieunaissance = rset.getString(6);
            String role = rset.getString(7);
            String statut = rset.getString(8);
            String pays = rset.getString(9);
            VIP temp = new VIP(numVIP, nom, prenom, civilite, datenaissance, lieunaissance, role, statut, pays);
            lesVIP.add(temp);
        }
        rset.close();
        pstmt.close();
    }
    
    /**
     * récupère la liste des VIPL (célibataires) dans la liste entrée en
     * paramètres
     * @param lesVIP
     * @throws SQLException 
     */
    public void lireLesVIPL(List<VIP> lesVIP) throws SQLException {
        String requete = "select nom,prenom from VIP where statut='L'";
        PreparedStatement pstmt = connexion.prepareStatement(requete);
        ResultSet rset = pstmt.executeQuery(requete);
        while (rset.next()) {
            int numVIP = rset.getInt(1);
            String nom = rset.getString(2);
            String prenom = rset.getString(3);
            String civilite = rset.getString(4);
            LocalDate datenaissance = rset.getDate(5).toLocalDate();
            String lieunaissance = rset.getString(6);
            String role = rset.getString(7);
            String statut = rset.getString(8);
            String pays = rset.getString(9);
            VIP temp = new VIP(numVIP, nom, prenom, civilite, datenaissance, lieunaissance, role, statut, pays);
            lesVIP.add(temp);
        }
        rset.close();
        pstmt.close();
    }
    
    /**
     * insère le VIP entré en paramètres dans la table VIP
     * @param vip
     * @throws SQLException 
     */
    public void insererVIP(VIP vip) throws SQLException {
        String requete = "insert into VIP (nom, prenom, civilite, datenaissance, lieunaissance, role, statut, pays) values(?,?,?,?,?,?,?,?)";
        PreparedStatement pstmt = connexion.prepareStatement(requete);
        pstmt.setString(1, vip.getNom());
        pstmt.setString(2, vip.getPrenom());
        pstmt.setString(3, vip.getCivilite());
        pstmt.setDate(4, java.sql.Date.valueOf(vip.getDatenaissance()));
        pstmt.setString(5, vip.getLieunaissance());
        pstmt.setString(6, vip.getRole());
        pstmt.setString(7, vip.getStatut());
        pstmt.setString(8, vip.getPays());
        pstmt.executeUpdate();
        pstmt.close();
    }
    
    /**
     * récupère la liste des VIPPhoto dans la liste entrée en paramètres
     * @param lesVIPPhoto
     * @throws SQLException 
     */
    public void recupererLesVIPPhoto(List<VIPPhoto> lesVIPPhoto) throws SQLException {
        String requete = "select numVIP, nom, prenom from VIP order by nom";
        PreparedStatement pstmt = connexion.prepareStatement(requete);
        ResultSet rset = pstmt.executeQuery(requete);
        while (rset.next()) {
            int numVIP = rset.getInt(1);
            String nom = rset.getString(2);
            String prenom = rset.getString(3);
            VIPPhoto temp = new VIPPhoto(numVIP, nom, prenom);
            lesVIPPhoto.add(temp);
        }
        rset.close();
        pstmt.close();
    }
    
}
