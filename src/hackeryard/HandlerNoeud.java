/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackeryard;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

/**
 *
 * @author jonathan
 */
public class HandlerNoeud implements EventHandler<Event> {

    private Noeud noeud;
    private Jeu jeu;
    private Controller controller;

    public HandlerNoeud(Noeud noeud, Jeu jeu, Controller controller) {
        this.noeud = noeud;
        this.jeu = jeu;
        this.controller = controller;
    }

    @Override
    public void handle(Event t) {
        if (jeu.getGraphe().occupant(noeud) != null) {
            if (jeu.getGraphe().occupant(noeud).getClass().getName() == Hacker.class.getName() && jeu.getJoueurCourant().getClass().getName() != Hacker.class.getName()) {
                controller.toMenu();
                Alert dialog = new Alert(Alert.AlertType.CONFIRMATION);
                dialog.setTitle("Fin du jeu");
                dialog.setHeaderText(null);
                dialog.setContentText(jeu.getJoueurCourant().getNom() + " à gagné !!!");
                dialog.showAndWait();
            }
        }

        if (jeu.getGraphe().GetSuivant(jeu.getJoueurCourant().position).contains(noeud) && !jeu.getGraphe().estOccupee(noeud)) {
            jeu.getJoueurCourant().position = noeud;
            System.out.println("Le joueur " + jeu.getJoueurCourant().getNom() + " est maintenant sur le noeud " + noeud.NoNoeud);
            jeu.tourSuivant();
        } else {
            System.out.println("Le mouvement n'est pas permis");
        }
    }

}
