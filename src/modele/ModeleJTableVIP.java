package modele;

import accesAuxDonnees.DaoVIP;
import application.Appli;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import metier.VIP;

/**
 *
 * @author Alice
 */
public class ModeleJTableVIP extends AbstractTableModel {

    private final List<VIP> leConteneurVIP;
    private final String[] titres;
    private final DaoVIP leDaoVIP;

    public ModeleJTableVIP() {
        this.leConteneurVIP = new ArrayList<>();
        this.titres = new String[]{"Num", "Nom", "Prénom", "Civilité",
            "Date de naissance", "Lieu de naissance", "Role", "Statut", "Pays"};
        this.leDaoVIP = Appli.getDaoVIP();
    }

    @Override
    public int getRowCount() {
        return leConteneurVIP.size();
    }

    @Override
    public int getColumnCount() {
        return titres.length;
    }

    @Override
    public Object getValueAt(int row, int column) {
        VIP vip = leConteneurVIP.get(row);
        switch (column) {
            case 0:
                return vip.getNumVIP();
            case 1:
                return vip.getNom();
            case 2:
                return vip.getPrenom();
            case 3:
                return vip.getCivilite();
            case 4:                
                return vip.getDatenaissance().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            case 5:
                return vip.getLieunaissance();
            case 6:
                return vip.getRole();
            case 7:
                return vip.getStatut();
            case 8:
                return vip.getPays();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return titres[column];
    }

    /**
     * insère le VIP vip dans la base
     * @param vip
     * @throws SQLException 
     */
    public void insererVIP(VIP vip) throws SQLException {
        leConteneurVIP.clear();
        leDaoVIP.insererVIP(vip);
        chargerLesVIP();
    }

    /**
     * charge la liste des VIP
     * @throws SQLException 
     */
    public void chargerLesVIP() throws SQLException {
        leDaoVIP.lireLesVIP(leConteneurVIP);
        this.fireTableDataChanged();
    }
}
