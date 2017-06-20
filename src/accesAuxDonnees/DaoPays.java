/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package accesAuxDonnees;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import tables.Pays;

/**
 *
 * @author Alice
 */
public class DaoPays {

    private final Connection connexion;

    public DaoPays(Connection connexion) throws SQLException {
        this.connexion = connexion;
    }

    /**
     * récupère la liste des pays dans la liste entrée en paramètre
     * @param lesPays
     * @throws SQLException 
     */
    public void recupererLesPays(List<Pays> lesPays) throws SQLException {
        String requete = "select * from pays";
        PreparedStatement pstmt = connexion.prepareStatement(requete);
        ResultSet rset = pstmt.executeQuery(requete);
        while (rset.next()) {
            String pays = rset.getString(1);
            Pays temp = new Pays(pays);
            lesPays.add(temp);
        }
        rset.close();
        pstmt.close();
    }
}
