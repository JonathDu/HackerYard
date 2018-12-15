/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackeryard;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author jonathan
 */
public class HackerYard extends Application {

    Stage stage;
    Scene scene;

    @Override
    public void start(Stage primaryStage) {
        stage = primaryStage;

        scene = new Scene(new Group(), 500, 600);
        stage.setScene(scene);

        toMenu();
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    public void toMenu() {
        scene.setRoot(new InterfaceTitre(this, scene));
    }

    public void toPlateau() {
        scene.setRoot(new InterfacePlateau(this, scene));
    }

    public void toJoueur() {
        scene.setRoot(new InterfaceJoueur(this, scene));
    }

}
