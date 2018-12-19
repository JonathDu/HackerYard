/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackeryard;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;

/**
 * Premiere interface, ne contient qu'un bouton pour passer a l'ecran de
 * selections des joueurs
 *
 * @author jonathan
 */
public class InterfaceTitre extends Interface {

    private HackerYard main;
    private Button jouer;
    private BorderPane pane;
    private HBox centre;
    private HBox centreTitre;
    private Label titre;

    public InterfaceTitre(Controller controller, Scene scene) {
        super(controller, scene);

        initialiseGraphique();
        initialiseHandler(main);
    }

    /**
     * Mets en place les éléments graphique sur l'Interface
     */
    private void initialiseGraphique() {
        pane = new BorderPane();
        pane.prefHeightProperty().bind(scene.heightProperty());
        pane.prefWidthProperty().bind(scene.widthProperty());

        centre = new HBox();
        centre.setAlignment(Pos.CENTER);
        
        centreTitre = new HBox();
        centreTitre.setAlignment(Pos.CENTER);

        jouer = new Button("Jouer !!!");
        titre = new Label("HackerYard !!!!");
        titre.setFont(Font.font(30));
        
        centre.getChildren().add(jouer);
        centreTitre.getChildren().add(titre);
        pane.setTop(centreTitre);
        
        pane.setCenter(centre);

        this.getChildren().add(pane);
    }

    /**
     * Ajoute les handlers des elements graphiques
     */
    private void initialiseHandler(HackerYard main) {
        jouer.setOnAction((t) -> {
            controller.toJoueur();
        });
    }
}
