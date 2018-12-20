/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackeryard;

import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

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
    ArrayList<TextField> joueur;
    Button addPlayer;

    Button valider;

    /**
     * Construteur, passage en paramètres de la classe principale HackerYard,
     * qui permet de faire le liens entre les interfaces
     *
     * @param main
     */
    public InterfaceJoueur(Controller controller, Scene scene) {
        super(controller, scene);
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
        valider.setDefaultButton(true);
        misterXLabel = new Label("Mister X");
        joueur = new ArrayList<>();

        addPlayer = new Button("Ajouter un détéctive");

        joueur.add(new TextField("Detective 1"));
        joueur.add(new TextField("Detective 2"));

        majJoueur();
        t.getChildren().add(centre);
        pane.setCenter(t);
        bas.getChildren().add(valider);
        bas.setPadding(new Insets(30));
        pane.setBottom(bas);
        this.getChildren().add(pane);

    }

    /**
     * Ajoute les handlers des elements graphiques
     */
    private void initHandler() {
        addPlayer.setOnAction((t) -> {
            if (joueur.size() < 5) {
                joueur.add(new TextField("Detective " + (joueur.size() + 1)));
                majJoueur();
            }
        });

        valider.setOnAction((t) -> {
            ArrayList<Joueur> liste = new ArrayList<>();

            ArrayList<Color> couleur = new ArrayList<>();
            couleur.add(Color.PURPLE);
            couleur.add(Color.YELLOW);
            couleur.add(Color.BLUE);
            couleur.add(Color.CHARTREUSE);
            couleur.add(Color.GREEN);
            couleur.add(Color.RED);

            Hacker h = new Hacker(4, 3, 3, 2, joueur.size(), 3, couleur.get(0));
            liste.add(h);
            int i = 1;
            for (TextField e : joueur) {
                liste.add(new FBI(e.getText(), 10, 8, 4, couleur.get(i)));
                i++;
            }
            if (joueur.size() == 2) {
                for (TextField e : joueur) {
                    liste.add(new FBI(e.getText() + " 2", 10, 8, 4, couleur.get(i)));
                    i++;
                }
            }

            Graphe g1 = new Graphe(110, 14, 20);
            g1.addJoueur(liste);
            controller.toPlateau(liste, g1, h);

        });

    }

    /**
     * Mets a jour le nombre de champs de textes pour le nom des joueurs
     */
    private void majJoueur() {
        centre.getChildren().clear();
        centre.getChildren().add(misterXLabel);
        for (TextField e : joueur) {
            centre.getChildren().add(e);
        }
        centre.getChildren().add(addPlayer);
    }

}
