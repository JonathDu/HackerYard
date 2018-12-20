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

/**
 * Classe qui gere le deplacement d'un joueur
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

    /**
     * Fonction appelé lors du click sur un noeud
     *
     * @param t
     */
    @Override
    public void handle(Event t) {

        //Vérification qu'il existe un arc entre les deux noeuds
        if (!jeu.getGraphe().GetSuivant(jeu.getJoueurCourant().position).contains(noeud)) {
            System.out.println("Auncun chemin n'existe entre les deux points");
            return;
        }
        //Vérification que le hacker peut réaliser le mouvement
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
                    jeu.addCarteHacker(3);
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
        if (!jeu.tourHacker()) {
            noeudG.ajouterJoueur(jeu.getJoueurCourant().couleur);
        } else {
            ((InterfacePlateau) noeudG.getParent().getParent().getParent().getParent().getParent().getParent().getParent().getParent()).addDeplacementX(jeu.getGraphe().typeArc(noeud, jeu.getJoueurCourant().position));
        }
        gestionPosHacker();
        jeu.getJoueurCourant().position = noeud;
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
        if (jeu.personneBouge()) {
            controller.toMenu();
            Alert dialog = new Alert(Alert.AlertType.CONFIRMATION);
            dialog.setTitle("Fin du jeu");
            dialog.setHeaderText(null);
            dialog.setContentText("Le hacker à gagné !!!");
            dialog.showAndWait();
            return;
        }

    }

    private void gestionPosHacker() {
        if ((jeu.getNbTourHacker() == 0 || jeu.getNbTour() == 3 || jeu.getNbTour() == 8 || jeu.getNbTour() == 13 || jeu.getNbTour() == 18) && jeu.tourHacker()) {
            noeudToInterface.get(jeu.getPosHacker()).supprimerHacker();
            jeu.setPosHacker(noeud);
            noeudToInterface.get(noeud).ajouterHacker();
        }
    }

}
