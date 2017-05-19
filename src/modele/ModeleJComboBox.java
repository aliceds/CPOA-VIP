package modele;

import accesAuxDonnees.DaoVIP;
import application.Appli;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import tables.VIP;

/**
 *
 * @author Administrateur
 */
public class ModeleJComboBox extends DefaultComboBoxModel<String> {

    private final List<VIP> listeItems;
    private final DaoVIP leDaoDept;

    public ModeleJComboBox() throws SQLException {
        // définition du conteneur des groupes
        this.listeItems = new ArrayList<>();
        // récupération de la référence sur l'objet DAO utilisé
        this.leDaoDept = Appli.getDaoDept();
        // chargement des groupes depuis la table
        leDaoDept.recupererDepartements(listeItems);
    }

    @Override
    public int getSize() {
        return listeItems.size();
    }

    @Override
    public String getElementAt(int i) {
        return listeItems.get(i).getNomDept();
    }

    public int getNumDept(int i) {
        return listeItems.get(i).getNumDept();
    }
} // Fin classe ModeleJComboBox

