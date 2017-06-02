/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import accesAuxDonnees.DaoMariage;
import application.Appli;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import tables.Mariage;
import tables.VIP;

/**
 *
 * @author Alice
 */
public class ModeleJTableMariage extends AbstractTableModel {
    private final List<Mariage> leConteneurMariage;
    private final String[] titres;
    private final DaoMariage leDaoMariage;

    public ModeleJTableMariage() {
        this.leConteneurMariage = new ArrayList<>();
        this.titres = new String[]{"N°VIP1", "Nom", "Prénom", "N°VIP2", "Nom", "Prenom", "Date du mariage", "Lieu"};
        this.leDaoMariage = Appli.getDaoMariage();
    }

    @Override
    public int getRowCount() {
        return leConteneurMariage.size();
    }

    @Override
    public int getColumnCount() {
        return titres.length;
    }

    @Override
    public Object getValueAt(int row, int column) {
        Mariage mariage = leConteneurMariage.get(row);
        switch (column) {
            case 0:
                return mariage.getNum1();
            case 1:
                return mariage.getNom1();
            case 2:
                return mariage.getPrenom1();
            case 3:
                return mariage.getNum2();
            case 4:
                return mariage.getNom2();
            case 5:
                return mariage.getPrenom2();
            case 6:
                return mariage.getDate_mariage();
            case 7:
                return mariage.getLieu_mariage();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return titres[column];
    }

    public void chargerLesMariages() throws SQLException {
        leConteneurMariage.clear();
        // chargement de tous les employés dans la base dans le conteneur du modèle
        leDaoMariage.recupererLesMariages(leConteneurMariage);
        // si c'est OK on rafraichit la vue par une notification  
        this.fireTableDataChanged();
    }
}
