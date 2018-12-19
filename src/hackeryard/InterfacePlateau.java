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
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

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
     * @param controller
     * @param scene
     * @param jeu
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
            name.setTextFill(j.couleur);
            if (jeu.getJoueurCourant() == j) {
                name.setFont(Font.font("Courier New", FontWeight.BOLD, BASELINE_OFFSET_SAME_AS_HEIGHT));
            } else {
                name.setFont(Font.font("Courier New", FontWeight.NORMAL, BASELINE_OFFSET_SAME_AS_HEIGHT));

            }
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

    public void majGraphique() {
        pane.setLeft(null);
        left = new VBox();
        for (Joueur j : jeu.getJoueurs()) {
            Label name = new Label(j.getNom());
            name.setTextFill(j.couleur);
            if (jeu.getJoueurCourant() == j) {
                name.setFont(Font.font("Courier New", FontWeight.BOLD, BASELINE_OFFSET_SAME_AS_HEIGHT));
            } else {
                name.setFont(Font.font("Courier New", FontWeight.NORMAL, BASELINE_OFFSET_SAME_AS_HEIGHT));

            }
            Label nbCarte = new Label("T1 : " + j.nombreT1 + " T2 : " + j.nombreT2 + " T3 : " + j.nombreT3);
            left.getChildren().add(name);
            left.getChildren().add(nbCarte);

        }
        pane.setLeft(left);
    }
}
