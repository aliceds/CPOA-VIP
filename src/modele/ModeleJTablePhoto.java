/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import accesAuxDonnees.DaoPhoto;
import application.Appli;
import java.io.IOException;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import tables.Photo;
import tables.VIP;

/**
 *
 * @author Alice
 */
public class ModeleJTablePhoto extends AbstractTableModel {
    private final List<Photo> listePhotos;
    private final String[] titres;
    private final DaoPhoto leDaoPhoto;

    public ModeleJTablePhoto() throws SQLException {
        this.listePhotos = new ArrayList<>();
        this.leDaoPhoto = Appli.getDaoPhoto();
        this.titres = new String[]{"N°photo","nom fichier"};

    }
    
    public void recupererLaPhoto(Photo photo) throws SQLException {
        leDaoPhoto.recupererLaPhoto(photo);
    }
    
    public void insererPhoto(Photo photo) throws SQLException, IOException {
        leDaoPhoto.insererPhoto(photo);
    }
    
    public void chargerLesPhotos () throws SQLException {
        listePhotos.clear();
        leDaoPhoto.recupererLesPhotos(listePhotos);
    }
    
    @Override
    public int getRowCount() {
        return listePhotos.size();
    }

    @Override
    public int getColumnCount() {
        return titres.length;
    }

    @Override
    public Object getValueAt(int row, int column) {
        Photo photo = listePhotos.get(row);
        switch (column) {
            case 0:
                return photo.getID_photo();
            case 1:
                return photo.getNom_fichier();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return titres[column];
    }
}
