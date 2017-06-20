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
import tables.EvenementTotal;

/**
 *
 * @author Alice
 */
public class DaoEvenementTotal {
    private final Connection connexion;

    public DaoEvenementTotal(Connection connexion) {
        this.connexion = connexion;
    }
    
    /**
     * récupère la liste des événements avec les informations des deux VIP
     * dans la liste entrée en paramètre
     * @param lesEvenementsTotal
     * @throws SQLException 
     */
    public void recupererLesEvenementsTotal(List<EvenementTotal> lesEvenementsTotal) throws SQLException {
        String requete = "SELECT numVIP1, v1.nom, v1.prenom, numVIP2, v2.nom, v2.prenom, lieu_mariage, date_mariage, date_divorce FROM evenement e LEFT JOIN VIP AS v1 ON e.numVIP1 = v1.numVIP LEFT JOIN VIP AS v2 ON e.numVIP2 = v2.numVIP \n";
        PreparedStatement pstmt = connexion.prepareStatement(requete);
        ResultSet rset = pstmt.executeQuery(requete);
        while (rset.next()) {
            int num1 = rset.getInt(1);
            String nom1 = rset.getString(2);
            String prenom1 = rset.getString(3);
            int num2 = rset.getInt(4);
            String nom2 = rset.getString(5);
            String prenom2 = rset.getString(6);
            String lieu_mariage = rset.getString(7);
            int date_mariage = rset.getInt(8);
            int date_divorce = rset.getInt(9);
            
            EvenementTotal temp = new EvenementTotal(num1,nom1,prenom1,num2,nom2,prenom2, lieu_mariage, date_mariage, date_divorce);
            lesEvenementsTotal.add(temp);
        }
        rset.close();
        pstmt.close();
    }
    
}
