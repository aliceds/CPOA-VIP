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
        this.listeApparition = new ArrayList<>();
        this.leDaoApparaitre = Appli.getDaoApparaitre();
        leDaoApparaitre.recupererLesApparitions(listeApparition);
    }
    
    /**
     * charge les apparitions
     * @throws SQLException 
     */
    public void chargerLesApparitions() throws SQLException {
        leDaoApparaitre.recupererLesApparitions(listeApparition);  
    }
    
    /**
     * insère l'apparition a
     * @param a
     * @throws SQLException 
     */
    public void insererApparition(Apparaitre a) throws SQLException {
        listeApparition.clear();
        leDaoApparaitre.insererApparition(a);
        chargerLesApparitions();
    }
}
