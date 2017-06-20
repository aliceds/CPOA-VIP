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
import tables.VIPL;

/**
 *
 * @author Alice
 */
public class DaoVIPL {
    private final Connection connexion;

    public DaoVIPL(Connection connexion) {
        this.connexion = connexion;
    }

    /**
     * récupère la liste des VIP célibataires dans la liste entrée en paramètres
     * @param lesVIPL
     * @throws SQLException 
     */
    public void lireLesVIPL(List<VIPL> lesVIPL) throws SQLException {
        String requete = "select numVIP, nom, prenom from VIP where statut='L'";
        PreparedStatement pstmt = connexion.prepareStatement(requete);
        ResultSet rset = pstmt.executeQuery(requete);
        while (rset.next()) {       // traitement du résulat
            int numVIP = rset.getInt(1);
            String nom = rset.getString(2);
            String prenom = rset.getString(3);
            VIPL temp = new VIPL(numVIP, nom, prenom);
            lesVIPL.add(temp);
        }
        rset.close();
        pstmt.close();
    }
}
