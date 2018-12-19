/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackeryard;

import java.util.ArrayList;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author jonathan
 */
public class Controller {

    private Stage stage;
    private Scene scene;

    public Controller(Stage stage, Scene scene) {
        this.stage = stage;
        this.scene = scene;
    }

    public void toMenu() {
        scene.setRoot(new InterfaceTitre(this, scene));
    }

    public void toPlateau(ArrayList<Joueur> liste, Graphe g, Hacker hacker) {
        scene.setRoot(new InterfacePlateau(this, scene, new Jeu(liste, g, 50, hacker)));
    }

    public void toJoueur() {
        scene.setRoot(new InterfaceJoueur(this, scene));
    }
    
    public Scene getScene(){
        return scene;
    }
}
