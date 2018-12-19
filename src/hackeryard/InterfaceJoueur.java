/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackeryard;

import java.util.ArrayList;
import javafx.geometry.Pos;
import javafx.scene.Node;
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

        misterXLabel = new Label("Mister X");
        joueur = new ArrayList<>();

        addPlayer = new Button("Ajouter un détéctive");

        joueur.add(new TextField("Detective 1"));
        joueur.add(new TextField("Detective 2"));

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
            if (joueur.size() < 5) {
                joueur.add(new TextField("Detective " + (joueur.size() + 1)));
                majJoueur();
            }
        });

        valider.setOnAction((t) -> {
            ArrayList<Joueur> liste = new ArrayList<>();

            ArrayList<Noeud> tableauN = new ArrayList<>();
            ArrayList<Arc> tableauA = new ArrayList<>();
            Integer[] posJoueurs = {1, 2, 3, 4};
            Noeud n1 = new Noeud(0, 0);
            Noeud n2 = new Noeud(0, 1);
            Noeud n3 = new Noeud(1, 0);
            Noeud n4 = new Noeud(1, 1);
            Noeud n5 = new Noeud(2, 0);
            tableauN.add(n1);
            tableauN.add(n2);
            tableauN.add(n3);
            tableauN.add(n4);
            Arc a1 = new Arc(n1, n2, 1);
            Arc a2 = new Arc(n3, n1, 1);
            Arc a3 = new Arc(n4, n1, 1);
            Arc a4 = new Arc(n4, n2, 1);
            Arc a5 = new Arc(n3, n2, 1);
            Arc a6 = new Arc(n3, n4, 1);

            tableauA.add(a1);
            tableauA.add(a2);
            tableauA.add(a3);
            tableauA.add(a4);
            tableauA.add(a5);
            tableauA.add(a6);

            ArrayList<Color> couleur = new ArrayList<>();
            couleur.add(Color.PURPLE);
            couleur.add(Color.YELLOW);
            couleur.add(Color.BLUE);
            couleur.add(Color.CHARTREUSE);
            couleur.add(Color.GREEN);
            couleur.add(Color.RED);

            liste.add(new Hacker(3, 3000, 3, n4, 3, 3, 3, couleur.get(0)));
            int i = 1;
            for (TextField e : joueur) {
                liste.add(new Joueur(e.getText(), 100, 1, 1, n1, couleur.get(i)));
                i++;
            }

            //Graphe g1 = new Graphe(tableauN, tableauA, liste);
            Graphe g1 = new Graphe(10,4,5);
            
            controller.toPlateau(liste, g1);

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
