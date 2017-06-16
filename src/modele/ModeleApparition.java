/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import accesAuxDonnees.DaoApparaitre;
import application.Appli;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import tables.Apparaitre;

/**
 *
 * @author Alice
 */
public class ModeleApparition {
    private final List<Apparaitre> listeApparition;
    private final DaoApparaitre leDaoApparaitre;

    public ModeleApparition() throws SQLException {
        // définition du conteneur des groupes
        this.listeApparition = new ArrayList<>();
        // récupération de la référence sur l'objet DAO utilisé
        this.leDaoApparaitre = Appli.getDaoApparaitre();
        // chargement des groupes depuis la table
        leDaoApparaitre.recupererLesApparitions(listeApparition);
    }
    
    public void chargerLesApparitions() throws SQLException {
        // chargement de tous les employés dans la base dans le conteneur du modèle
        leDaoApparaitre.recupererLesApparitions(listeApparition);
        
    }
    
    public void insererApparition(Apparaitre a) throws SQLException {
        listeApparition.clear();
        leDaoApparaitre.insererApparition(a);
        chargerLesApparitions();
    }
}
