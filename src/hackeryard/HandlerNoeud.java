/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackeryard;

import java.util.HashMap;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.paint.Color;

/**
 *
 * @author jonathan
 */
public class HandlerNoeud implements EventHandler<Event> {

    private final InterfaceNoeud noeudG;
    private final Noeud noeud;
    private final Jeu jeu;
    private final Controller controller;
    private final HashMap<Noeud, InterfaceNoeud> noeudToInterface;

    public HandlerNoeud(InterfaceNoeud noeudG, Jeu jeu, Controller controller, HashMap<Noeud, InterfaceNoeud> noeudToInterface) {
        this.noeud = noeudG.noeud;
        this.noeudG = noeudG;
        this.jeu = jeu;
        this.controller = controller;
        this.noeudToInterface = noeudToInterface;
    }

    @Override
    public void handle(Event t) {

        //Vérification qu'il existe un arc entre les deux noeuds
        if (!jeu.getGraphe().GetSuivant(jeu.getJoueurCourant().position).contains(noeud)) {
            System.out.println("Auncun chemin n'existe entre les deux points");
            return;
        }
        //Vérification que le joueur peut réaliser le mouvement
        switch (jeu.getGraphe().typeArc(noeud, jeu.getJoueurCourant().position)) {
            case 1:
                if (jeu.getJoueurCourant().nombreT1 > 0) {
                    jeu.getJoueurCourant().nombreT1--;
                    jeu.addCarteHacker(1);
                } else {
                    System.out.println("Vous n'avez pas de carte permettant se déplacement");
                    return;
                }
                break;
            case 2:
                if (jeu.getJoueurCourant().nombreT2 > 0) {
                    jeu.getJoueurCourant().nombreT2--;
                    jeu.addCarteHacker(2);
                } else {
                    System.out.println("Vous n'avez pas de carte permettant se déplacement");
                    return;
                }
                break;
            case 3:
                if (jeu.getJoueurCourant().nombreT3 > 0) {
                    jeu.getJoueurCourant().nombreT3--;
                    jeu.addCarteHacker(1);
                } else {
                    System.out.println("Vous n'avez pas de carte permettant se déplacement");
                    return;
                }
                break;
            default:
                break;
        }

        //Vérification que le noeud visé est vide
        if (jeu.getGraphe().occupant(noeud) != null) {
            //Vérification que le mouvement ne mets pas fin a la partie
            if (jeu.getGraphe().occupant(noeud).getClass().getName() == Hacker.class.getName() && jeu.getJoueurCourant().getClass().getName() != Hacker.class.getName()) {
                controller.toMenu();
                Alert dialog = new Alert(Alert.AlertType.CONFIRMATION);
                dialog.setTitle("Fin du jeu");
                dialog.setHeaderText(null);
                dialog.setContentText(jeu.getJoueurCourant().getNom() + " à gagné !!!");
                dialog.showAndWait();
                return;
            } else {
                System.out.println("Un joueur occupe déja la case");
                return;
            }
        }

        noeudToInterface.get(jeu.getJoueurCourant().position).supprimerJoueur();

        jeu.getJoueurCourant().position = noeud;
        noeudG.ajouterJoueur(jeu.getJoueurCourant().couleur);
        //System.out.println("Le joueur " + jeu.getJoueurCourant().getNom() + " est maintenant sur le noeud " + noeud.NoNoeud);
        jeu.tourSuivant();

        ((InterfacePlateau) controller.getScene().getRoot()).majGraphique();
        if (jeu.getTourRestant() <= 0) {
            controller.toMenu();
            Alert dialog = new Alert(Alert.AlertType.CONFIRMATION);
            dialog.setTitle("Fin du jeu");
            dialog.setHeaderText(null);
            dialog.setContentText("Le hacker à gagné !!!");
            dialog.showAndWait();
            return;
        }

    }

}
