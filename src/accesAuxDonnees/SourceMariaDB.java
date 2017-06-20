/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package accesAuxDonnees;

import java.io.FileInputStream;
import java.net.PasswordAuthentication;
import java.util.Properties;
import javax.sql.DataSource;
import org.mariadb.jdbc.MariaDbDataSource;

/**
 *
 * @author Alice
 */
public class SourceMariaDB {
    
    /**
     * renvoie un objet DataSource
     * @param login
     * @return
     * @throws Exception 
     */
    public static DataSource getSource(PasswordAuthentication login) throws Exception {
        // récupération des informations d'authentification
        String user = login.getUserName();
        String pwd = new String(login.getPassword());
        // création d'un objet Properties à parir du fichier 
        Properties props = new Properties();
        FileInputStream fichier = new FileInputStream("src/connexion.properties");
        props.load(fichier);
        MariaDbDataSource ds = new MariaDbDataSource();
        ds.setPortNumber(Integer.parseInt(props.getProperty("port")));
        ds.setDatabaseName(props.getProperty("service"));
        ds.setServerName(props.getProperty("serveur"));
        ds.setUser(user);
        ds.setPassword(pwd);
        return ds;
    }
}
