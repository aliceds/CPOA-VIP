/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import accesAuxDonnees.DaoEvenementTotal;
import application.Appli;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import tables.EvenementTotal;

/**
 *
 * @author Alice
 */
public class ModeleJTableEvenementTotal extends AbstractTableModel {
    private final List<EvenementTotal> leConteneurEvenementTotal;
    private final String[] titres;
    private final DaoEvenementTotal leDaoEvenementTotal;

    public ModeleJTableEvenementTotal() {
        this.leConteneurEvenementTotal = new ArrayList<>();
        this.titres = new String[]{"N°VIP1", "Nom", "Prénom", "N°VIP2", "Nom", "Prenom", "Date du mariage", "Lieu", "Date divorce"};
        this.leDaoEvenementTotal = Appli.getDaoEvenementTotal();
    }

    @Override
    public int getRowCount() {
        return leConteneurEvenementTotal.size();
    }

    @Override
    public int getColumnCount() {
        return titres.length;
    }

    @Override
    public Object getValueAt(int row, int column) {
        EvenementTotal evenement = leConteneurEvenementTotal.get(row);
        switch (column) {
            case 0:
                return evenement.getNum1();
            case 1:
                return evenement.getNom1();
            case 2:
                return evenement.getPrenom1();
            case 3:
                return evenement.getNum2();
            case 4:
                return evenement.getNom2();
            case 5:
                return evenement.getPrenom2();
            case 6:
                return evenement.getDate_mariage();
            case 7:
                return evenement.getLieu_mariage();
            case 8:
                return evenement.getDate_divorce();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return titres[column];
    }

    /**
     * charge la liste des événements total
     * @throws SQLException 
     */
    public void chargerLesEvenementsTotal() throws SQLException {
        leConteneurEvenementTotal.clear();
        leDaoEvenementTotal.recupererLesEvenementsTotal(leConteneurEvenementTotal);
        this.fireTableDataChanged();
    }
}
