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
 * @author Alain
 */
public class DaoPays {

    private final Connection connexion;

    public DaoPays(Connection connexion) throws SQLException {
        this.connexion = connexion;
    }

    public void recupererLesPays(List<Pays> lesPays) throws SQLException {
        String requete = "select * from pays";
        PreparedStatement pstmt = connexion.prepareStatement(requete);
        ResultSet rset = pstmt.executeQuery(requete);
        while (rset.next()) {       // traitement du résulat
            String pays = rset.getString(1);
            Pays temp = new Pays(pays);
            lesPays.add(temp);
        }
        rset.close();
        pstmt.close();
    }
/*
    public void insererEmploye(Pays emp) throws SQLException {
        String requete = "insert into EMP (empno, ename, job, hiredate, deptno) values(?,?,?,?,?)";
        PreparedStatement pstmt = connexion.prepareStatement(requete);
        pstmt.setInt(1, emp.getNumEmp());
        pstmt.setString(2, emp.getNomEmp());
        pstmt.setString(3, emp.getJobEmp());
        pstmt.setDate(4, java.sql.Date.valueOf(emp.getDateEmp()));
        pstmt.setInt(5, emp.getDeptEmp());
        pstmt.executeUpdate();
        pstmt.close();
    }*/
}
