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
import java.util.List;
import tables.Apparaitre;

/**
 * 
 * @author Alice
 */
public class DaoApparaitre {
    private final Connection connexion;

    public DaoApparaitre(Connection connexion) throws SQLException {
        this.connexion = connexion;
    }
/**
 * 
 * @param lesApparitions
 * @throws SQLException 
 * récupère la liste des apparitions dans la liste entrée en paramètre depuis
 * la table apparaitre
 */
    public void recupererLesApparitions(List<Apparaitre> lesApparitions) throws SQLException {
        String requete = "select * from apparait";
        PreparedStatement pstmt = connexion.prepareStatement(requete);
        ResultSet rset = pstmt.executeQuery(requete);
        while (rset.next()) {
            int ID_photo = rset.getInt(1);
            int numVIP = rset.getInt(2);
            Apparaitre temp = new Apparaitre(ID_photo, numVIP);
            lesApparitions.add(temp);
        }
        rset.close();
        pstmt.close();
    }
    /**
     * 
     * @param a
     * @throws SQLException 
     * insère une apparition dans la table apparaitre
     */
    public void insererApparition(Apparaitre a) throws SQLException {
        String requete = "insert into apparait (ID_photo, numVIP) values(?,?)";
        PreparedStatement pstmt = connexion.prepareStatement(requete);
        pstmt.setInt(1, a.getID_photo());
        pstmt.setInt(2, a.getNumVIP());
        pstmt.executeUpdate();
        pstmt.close();
    }
}
