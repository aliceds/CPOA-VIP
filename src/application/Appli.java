/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import accesAuxDonnees.DaoEvenement;
import accesAuxDonnees.DaoEvenementTotal;
import accesAuxDonnees.DaoMariage;
import accesAuxDonnees.DaoVIP;
import ihm.FenetreIdentification;
import ihm.AccueilApplication;
import accesAuxDonnees.DaoPays;
import accesAuxDonnees.DaoVIPL;
import accesAuxDonnees.SourceMariaDB;
import java.net.PasswordAuthentication;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class Appli {
    // réfrences sur les DAO utilisés par l'application
    private static DaoPays daoPays;
    private static DaoVIP daoVIP;
    private static DaoVIPL daoVIPL;
    private static DaoEvenement daoEvenement;
    private static DaoMariage daoMariage;
    private static DaoEvenementTotal daoEvenementTotal;

    // les accesseurs aux DAO utilisés par l'application
    public static DaoPays getDaoPays() {
        return daoPays;
    }

    public static DaoVIP getDaoVIP() {
        return daoVIP;
    }
    
    public static DaoVIPL getDaoVIPL() {
        return daoVIPL;
    }
    
    public static DaoEvenement getDaoEvenement() {
        return daoEvenement;
    }
    
    public static DaoMariage getDaoMariage() {
        return daoMariage;
    }
    
    public static DaoEvenementTotal getDaoEvenementTotal() {
        return daoEvenementTotal;
    }

    // le point d'entré du programme
    public static void main(String[] args) {
        // les variables locales
        DataSource laSourceDeDonnees;   // la sourde de données
        Connection laConnexion = null;  // la connexion
        
        // Look and Feel windows
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            System.out.print(e.getMessage());
        }

        // Etablissement de la connexion à la base MariaDB avec affichage de la fenetre d'identification 
        boolean etat = false;
        do {
            FenetreIdentification fi = new FenetreIdentification(null);
            PasswordAuthentication login = fi.identifier();
            try {
                laSourceDeDonnees = SourceMariaDB.getSource(login);
                laConnexion = laSourceDeDonnees.getConnection();
                etat = true;
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "login incorrect : " + ex.getMessage(),
                        "avertissement", JOptionPane.WARNING_MESSAGE);
            }
        } while (etat == false); // tant que la saisie n'est pas correcte

        // Instanciation des objets nécessaires à l'application
        try {
            // les DAO nécessaires
            daoPays = new DaoPays(laConnexion);
            daoVIP = new DaoVIP(laConnexion);
            daoVIPL = new DaoVIPL(laConnexion);
            daoEvenement = new DaoEvenement(laConnexion);
            daoMariage = new DaoMariage(laConnexion);
            daoEvenementTotal = new DaoEvenementTotal(laConnexion);
            // la fenetre principale de l'application qui tourne dans l'EDT
            javax.swing.SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    try {
                        new AccueilApplication().setVisible(true);
                    } catch (SQLException ex) {
                        Logger.getLogger(Appli.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "problème dans la création des objets nécessaires" + ex.getMessage(),
                    "avertissement", JOptionPane.WARNING_MESSAGE);
        }
    }
}
