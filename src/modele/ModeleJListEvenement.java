/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import accesAuxDonnees.DaoEvenement;
import accesAuxDonnees.DaoPays;
import application.Appli;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;
import tables.Evenement;

/**
 *
 * @author Alice
 */
public class ModeleJListEvenement extends AbstractListModel<String>{

    private final List<Evenement> listeEvenement;
    private final DaoEvenement leDaoEvenement;

    public ModeleJListEvenement() throws SQLException {
        // définition du conteneur des groupes
        this.listeEvenement = new ArrayList<>();
        // récupération de la référence sur l'objet DAO utilisé
        this.leDaoEvenement = Appli.getDaoEvenement();
        // chargement des groupes depuis la table
        leDaoEvenement.recupererLesEvenements(listeEvenement);
    }
    
    public void chargerLesEvenements() throws SQLException {
        // chargement de tous les employés dans la base dans le conteneur du modèle
        leDaoEvenement.recupererLesEvenements(listeEvenement);
    }
    
    public void insererEvenement(Evenement evenement) throws SQLException {
        listeEvenement.clear();
        leDaoEvenement.insererEvenement(evenement);
        chargerLesEvenements();
    }
    
    
    @Override
    public int getSize() {
        return listeEvenement.size();
    }

    @Override
    public String getElementAt(int i) {
        return listeEvenement.get(i).getLieu_mariage();
    }
    
}
