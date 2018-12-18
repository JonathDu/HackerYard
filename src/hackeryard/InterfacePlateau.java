/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackeryard;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

/**
 * Interface contenant le plateau de jeu
 *
 * @author jonathan
 */
public class InterfacePlateau extends Interface {

    BorderPane pane;
    VBox left;
    VBox right;
    InterfaceGraphe graphe;
    Jeu jeu;

    /**
     * Constructeur
     */
    public InterfacePlateau(Controller controller, Scene scene, Jeu jeu) {
        super(controller, scene);
        this.jeu = jeu;
        initaliseGraphique();
    }

    /**
     * Mets en place les éléments graphique sur l'Interface
     */
    private void initaliseGraphique() {
        left = new VBox();

        for (Joueur j : jeu.getJoueurs()) {
            Label name = new Label(j.getNom());
            Label nbCarte = new Label("T1 : " + j.nombreT1 + " T2 : " + j.nombreT2 + " T3 : " + j.nombreT3);
            left.getChildren().add(name);
            left.getChildren().add(nbCarte);

        }

        right = new VBox();
        graphe = new InterfaceGraphe(controller, jeu);

        pane = new BorderPane();
        pane.setLeft(left);
        pane.setCenter(graphe);

        this.getChildren().add(pane);
    }

}
