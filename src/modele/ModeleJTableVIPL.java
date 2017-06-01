/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import accesAuxDonnees.DaoVIPL;
import application.Appli;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import tables.VIPL;

/**
 *
 * @author Alice
 */
public class ModeleJTableVIPL extends AbstractTableModel{
    private final List<VIPL> listeVIPL;
    private final DaoVIPL leDaoVIPL;
    private final String[] titres;

    public ModeleJTableVIPL() throws SQLException {
        this.listeVIPL = new ArrayList<>();
        this.leDaoVIPL = Appli.getDaoVIPL();
        leDaoVIPL.lireLesVIPL(listeVIPL);
        this.titres = new String[]{"num VIP","nom","prénom"};
    }
    
    public void chargerLesVIPL() throws SQLException {
        leDaoVIPL.lireLesVIPL(listeVIPL);
    }
    
    
    @Override
    public int getRowCount() {
        return listeVIPL.size();
    }

    @Override
    public int getColumnCount() {
        return titres.length;
    }

    @Override
    public Object getValueAt(int row, int column) {
        VIPL vipl = listeVIPL.get(row);
        switch (column) {
            case 0:
                return vipl.getNumVIP();
            case 1:
                return vipl.getNom();
            case 2:
                return vipl.getPrenom();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return titres[column];
    }
}
