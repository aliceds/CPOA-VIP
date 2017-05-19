package modele;

import accesAuxDonnees.DaoPays;
import application.Appli;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;
import tables.Pays;

/**
 *
 * @author Administrateur
 */
public class ModeleJListPays extends AbstractListModel<String> {

    private final List<Pays> listePays;
    private final DaoPays leDaoPays;

    public ModeleJListPays() throws SQLException {
        // définition du conteneur des groupes
        this.listePays = new ArrayList<>();
        // récupération de la référence sur l'objet DAO utilisé
        this.leDaoPays = Appli.getDaoPays();
        // chargement des groupes depuis la table
        leDaoPays.recupererLesPays(listePays);
    }
    
    public void chargerLesPays() throws SQLException {
        // chargement de tous les employés dans la base dans le conteneur du modèle
        leDaoPays.recupererLesPays(listePays);
    }
    
    
    @Override
    public int getSize() {
        return listePays.size();
    }

    @Override
    public String getElementAt(int i) {
        return listePays.get(i).getPays();
    }
} // Fin classe ModeleJComboBox

