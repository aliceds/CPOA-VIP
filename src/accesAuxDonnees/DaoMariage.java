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
import tables.Mariage;

/**
 *
 * @author Alice
 */
public class DaoMariage {
    private final Connection connexion;

    public DaoMariage(Connection connexion) {
        this.connexion = connexion;
    }
    
    /**
     * récupère la liste des mariages dans la liste entrée en paramètre
     * @param lesMariages
     * @throws SQLException 
     */
    public void recupererLesMariages(List<Mariage> lesMariages) throws SQLException {
        String requete = "SELECT numVIP1, v1.nom, v1.prenom, numVIP2, v2.nom, v2.prenom, lieu_mariage, date_mariage FROM evenement e LEFT JOIN VIP AS v1 ON e.numVIP1 = v1.numVIP LEFT JOIN VIP AS v2 ON e.numVIP2 = v2.numVIP WHERE date_divorce is NULL \n";
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
            
            Mariage temp = new Mariage(num1,nom1,prenom1,num2,nom2,prenom2, lieu_mariage, date_mariage);
            lesMariages.add(temp);
        }
        rset.close();
        pstmt.close();
    }
}
