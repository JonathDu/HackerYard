/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackeryard;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
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
    HBox centre;
    InterfaceGraphe graphe;
    Jeu jeu;

    /**
     * Constructeur
     *
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
        setLeft();
        right = new VBox();
        right.setPadding(new Insets(30));
        graphe = new InterfaceGraphe(controller, jeu);
        centre = new HBox();
        centre.setAlignment(Pos.CENTER);
        pane = new BorderPane();
        pane.prefHeightProperty().bind(this.scene.heightProperty());
        pane.prefWidthProperty().bind(this.scene.widthProperty());

        pane.setLeft(left);
        centre.getChildren().add(graphe);
        pane.setCenter(centre);
        pane.setRight(right);

        Label historique = new Label("Historique de Mister X");
        right.getChildren().add(historique);

        this.getChildren().add(pane);
    }

    public void majGraphique() {
        pane.setLeft(null);
        setLeft();
        pane.setLeft(left);
    }

    private void setLeft() {
        left = new VBox();
        left.setPadding(new Insets(30));

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

        Button afficher = new Button("Afficher Mister X");
        Button cacher = new Button("Cacher Mister X");

        afficher.setOnAction((t) -> {
            graphe.afficherJoueur(jeu.getJoueurCourant());
            left.getChildren().remove(afficher);
            left.getChildren().add(cacher);
        });

        cacher.setOnAction((t) -> {
            graphe.cacherJoueur(jeu.getJoueurCourant());
            left.getChildren().remove(cacher);
            left.getChildren().add(afficher);
        });

        if (jeu.tourHacker()) {
            left.getChildren().add(afficher);
        }

    }

    /**
     * Ajoute le déplacement dans l'historique placé à droite
     *
     * @param type
     */
    public void addDeplacementX(int type) {
        Group g = new Group();
        Rectangle r = new Rectangle(50, 5, 50, 50);
        r.setStroke(Color.BLACK);
        r.setFill(Couleur.getCouleurArc(type));
        g.getChildren().add(r);
        right.getChildren().add(g);

    }
}
