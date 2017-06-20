/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import accesAuxDonnees.DaoVIP;
import application.Appli;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import metier.VIPPhoto;

/**
 *
 * @author Alice
 */
public class ModeleJTableVIPPhoto extends AbstractTableModel {

    private final List<VIPPhoto> listeVIPPhoto;
    private final String[] titres;
    private final DaoVIP leDaoVIP;

    public ModeleJTableVIPPhoto() throws SQLException {
        this.listeVIPPhoto = new ArrayList<>();
        this.titres = new String[]{"Num", "Nom", "Prénom"};
        this.leDaoVIP = Appli.getDaoVIP();
    }

    /**
     * charge la liste des VIPPhoto
     * @throws SQLException 
     */
    public void chargerLesVIPPhoto() throws SQLException {
        leDaoVIP.recupererLesVIPPhoto(listeVIPPhoto);
        this.fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return listeVIPPhoto.size();
    }

    @Override
    public int getColumnCount() {
        return titres.length;
    }

    @Override
    public Object getValueAt(int row, int column) {
        VIPPhoto vip = listeVIPPhoto.get(row);
        switch (column) {
            case 0:
                return vip.getNumVIP();
            case 1:
                return vip.getNom();
            case 2:
                return vip.getPrenom();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return titres[column];
    }
}
