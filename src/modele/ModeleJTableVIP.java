package modele;

import accesAuxDonnees.DaoVIP;
import application.Appli;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import tables.VIP;

/**
 *
 * @author Alain
 */
public class ModeleJTableVIP extends AbstractTableModel {

    // le conteneur de données
    private final List<VIP> leConteneurVIP;
    // le titre des champs du conteneur
    private final String[] titres;
    // l'objet DAO pour mettre à jour le conteneur
    private final DaoVIP leDaoVIP;

    public ModeleJTableVIP() {
        // définition du conteneur d'étudiants
        this.leConteneurVIP = new ArrayList<>();
        // définition des noms du champ
        this.titres = new String[]{"Num", "Nom", "Prénom", "Civilité", "Date de naissance", "Lieu de naissance", "Role", "Statut", "Pays"};
        // récupération de l'objet DAO utilisé
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
                //return vip.getDateEmp().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
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

    public void insererVIP(VIP vip) throws SQLException {
        // on tente d'insérer l'employé dans la base
        leDaoVIP.insererVIP(vip);
        // si c'est OK on l'ajoute au conteneur du modèle
        leConteneurVIP.add(vip);
        // on rafraichit la vue par une notification de modification des données  
        this.fireTableDataChanged();
    }

    public void supprimerVIP(int ligne) throws SQLException {
        // on récupère le numéro de l'employé de la ligne sélectionnée
        int numVIP = (int) getValueAt(ligne, 0);
        // on tente de supprimer l'employé dans la base
        leDaoVIP.supprimerVIP(numVIP);
        // si c'est OK on l'enlève du conteneur du modèle
        leConteneurVIP.remove(ligne);
        // on rafraichit la vue par une notification de modification des données
        this.fireTableDataChanged();
    }

    public void chargerLesVIP() throws SQLException {
        // chargement de tous les employés dans la base dans le conteneur du modèle
        leDaoVIP.lireLesVIP(leConteneurVIP);
        // si c'est OK on rafraichit la vue par une notification  
        this.fireTableDataChanged();
    }
}