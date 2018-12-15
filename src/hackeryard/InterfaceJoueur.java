/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackeryard;

import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * Interface de choix des joueurs
 *
 * @author jonathan
 */
public class InterfaceJoueur extends Interface {

    BorderPane pane;
    VBox centre;
    HBox bas;
    HBox t;
    Label misterXLabel;
    ArrayList<Node> joueur;
    Button addPlayer;

    Button valider;

    /**
     * Construteur, passage en paramètres de la classe principale HackerYard,
     * qui permet de faire le liens entre les interfaces
     *
     * @param main
     */
    public InterfaceJoueur(HackerYard main, Scene scene) {
        super(main, scene);
        initaliseGraphique();
        initHandler();
    }

    /**
     * Mets en place les éléments graphique sur l'Interface
     */
    private void initaliseGraphique() {
        pane = new BorderPane();

        pane.prefHeightProperty().bind(scene.heightProperty());
        pane.prefWidthProperty().bind(scene.widthProperty());

        t = new HBox();
        t.setAlignment(Pos.CENTER);
        
        bas = new HBox();
        bas.setAlignment(Pos.CENTER);

        centre = new VBox();
        centre.setAlignment(Pos.CENTER);

        valider = new Button("Valider");

        misterXLabel = new Label("Mister X");
        joueur = new ArrayList<>();

        addPlayer = new Button("Ajouter un détéctive");

        joueur.add(misterXLabel);

        joueur.add(new TextField("Detective 1"));
        joueur.add(new TextField("Detective 2"));

        joueur.add(addPlayer);

        majJoueur();
        t.getChildren().add(centre);
        pane.setCenter(t);
        bas.getChildren().add(valider);
        pane.setBottom(bas);
        this.getChildren().add(pane);

    }

    /**
     * Ajoute les handlers des elements graphiques
     */
    private void initHandler() {
        addPlayer.setOnAction((t) -> {
            joueur.remove(addPlayer);
            joueur.add(new TextField("Detective " + joueur.size()));
            joueur.add(addPlayer);
            majJoueur();
        });
        valider.setOnAction((t) -> {
            main.toPlateau();

        });

    }

    /**
     * Mets a jour le nombre de champs de textes pour le nom des joueurs
     */
    private void majJoueur() {
        centre.getChildren().clear();
        for (Node e : joueur) {
            centre.getChildren().add(e);
        }
    }

}
