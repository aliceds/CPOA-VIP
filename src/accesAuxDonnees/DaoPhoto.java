/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesAuxDonnees;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import tables.Photo;

/**
 *
 * @author Alice
 */
public class DaoPhoto {

    private final Connection connexion;

    public DaoPhoto(Connection connexion) {
        this.connexion = connexion;
    }

    /**
     * insère la photo entrée en paramètre dans la table photo
     * @param photo
     * @throws SQLException
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public void insererPhoto(Photo photo) throws SQLException, FileNotFoundException, IOException {
        String requete = "insert into photo (nom_fichier) values(?)";
        PreparedStatement pstmt = connexion.prepareStatement(requete);
        pstmt.setString(1, photo.getNom_fichier());
        pstmt.executeUpdate();
        pstmt.close();
    }
    
    /**
     * ajoute l'ID de la photo à partir du nom de la photo entrée en paramètres
     * @param photo
     * @throws SQLException 
     */
    public void recupererLaPhoto(Photo photo) throws SQLException {
        String requete = "select * from photo where nom_fichier = ?";
        PreparedStatement pstmt = connexion.prepareStatement(requete);
        pstmt.setString(1, photo.getNom_fichier());
        ResultSet rset = pstmt.executeQuery();
        while (rset.next()) {
            photo.setID_photo(rset.getInt(1));
        }
        rset.close();
        pstmt.close();
    }
    
    /**
     * récupère la liste des photos dans la liste entrée en paramètres
     * @param lesPhotos
     * @throws SQLException 
     */
    public void recupererLesPhotos(List<Photo> lesPhotos) throws SQLException {
        String requete = "select * from photo";
        PreparedStatement pstmt = connexion.prepareStatement(requete);
        ResultSet rset = pstmt.executeQuery(requete);
        while (rset.next()) {
            Photo photo = new Photo(rset.getInt(1), rset.getString(2));
            lesPhotos.add(photo);
        }
        rset.close();
        pstmt.close();
    }
}
