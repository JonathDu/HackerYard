/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackeryard;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
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

    /**
     * Constructeur
     */
    public InterfacePlateau(HackerYard main, Scene scene) {
        super(main, scene);
        left = new VBox();
        right = new VBox();
        graphe = new InterfaceGraphe();

        pane = new BorderPane();
    }

    /**
     * Mets en place les éléments graphique sur l'Interface
     */
    private void initaliseGraphique() {
        left = new VBox();
        right = new VBox();
        graphe = new InterfaceGraphe();

        pane = new BorderPane();
        pane.setLeft(left);
        pane.setRight(right);
        pane.setCenter(graphe);
    }

}
