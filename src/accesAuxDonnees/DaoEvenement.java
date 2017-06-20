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
import java.sql.Types;
import java.util.List;
import tables.Evenement;

/**
 *
 * @author Alice
 */
public class DaoEvenement {
     private final Connection connexion;

    public DaoEvenement(Connection connexion) {
        this.connexion = connexion;
    }
    
    /**
     * 
     * @param lesEvenements
     * @throws SQLException 
     * récupère la liste des événements dans la liste entrée en paramètres
     */
    public void recupererLesEvenements(List<Evenement> lesEvenements) throws SQLException {
        String requete = "select * from evenement";
        PreparedStatement pstmt = connexion.prepareStatement(requete);
        ResultSet rset = pstmt.executeQuery(requete);
        while (rset.next()) {
            int numVIP1 = rset.getInt(1);
            int date_mariage = rset.getInt(2);
            int numVIP2 = rset.getInt(3);
            String lieu_mariage = rset.getString(4);
            int date_divorce = rset.getInt(5);
            Evenement temp = new Evenement(numVIP1, date_mariage, numVIP2, lieu_mariage, date_divorce);
            lesEvenements.add(temp);
        }
        rset.close();
        pstmt.close();
    }
    
   /**
    * 
    * @param evt
    * @throws SQLException 
    * insère l'événement entré en paramètre dans la table evenement
    */    
    public void insererEvenement(Evenement evt) throws SQLException {
        String requete = "insert into evenement (numVIP1, date_mariage, numVIP2, lieu_mariage, date_divorce) values(?,?,?,?,?)";
        PreparedStatement pstmt = connexion.prepareStatement(requete);
        pstmt.setInt(1, evt.getNumVIP1());
        pstmt.setInt(2, evt.getDate_mariage());
        pstmt.setInt(3, evt.getNumVIP2());
        pstmt.setString(4, evt.getLieu_mariage());
        pstmt.setNull(5, Types.INTEGER);
        pstmt.executeUpdate();
        pstmt.close();
    }
    
    
    /**
     * 
     * @param evt
     * @throws SQLException 
     * modifie l'événement entré en paramètre
     */
    public void modifierEvenement(Evenement evt) throws SQLException {
        String requete = "update evenement set date_divorce=? where numVIP1=? and date_mariage=?";
        PreparedStatement pstmt = connexion.prepareStatement(requete);
        pstmt.setInt(1, evt.getDate_divorce());
        pstmt.setInt(2, evt.getNumVIP1());
        pstmt.setInt(3, evt.getDate_mariage());
        pstmt.executeUpdate();
        pstmt.close();
        
    }
    
}