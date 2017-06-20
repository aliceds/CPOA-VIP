package modele;

import accesAuxDonnees.DaoPays;
import application.Appli;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;
import metier.Pays;

/**
 *
 * @author Alice
 */
public class ModeleJListPays extends AbstractListModel<String> {

    private final List<Pays> listePays;
    private final DaoPays leDaoPays;

    public ModeleJListPays() throws SQLException {
        this.listePays = new ArrayList<>();
        this.leDaoPays = Appli.getDaoPays();
        leDaoPays.recupererLesPays(listePays);
    }
    
    /**
     * charge la liste des pays
     * @throws SQLException 
     */
    public void chargerLesPays() throws SQLException {
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
}

