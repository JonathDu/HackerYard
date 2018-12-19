/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackeryard;

import java.util.ArrayList;
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
        
        Controller controller = new Controller(stage, scene);
        
        
        controller.toMenu();
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //test pour savoir si Getsuivant marche
        ArrayList<Noeud> tableauN = new ArrayList<>();
        ArrayList<Arc> tableauA = new ArrayList<>();
        ArrayList<Joueur> posJoueurs = new ArrayList<>();
        
        Noeud n1 = new Noeud(0,1);
        Noeud n2 = new Noeud(2,0);
        Noeud n3 = new Noeud(1,1);
        Noeud n4 = new Noeud(2,1);
        posJoueurs.add(new FBI("pat",2,2,2,n1));
        posJoueurs.add(new FBI("leo",2,2,2,n3));
        tableauN.add(n1);
        tableauN.add(n2);
        tableauN.add(n3);
        tableauN.add(n4);        
        Arc a1 = new Arc(n1,n2,1);
        Arc a2 = new Arc(n3,n1,2);
        
        tableauA.add(a1);
        tableauA.add(a2);
        
        Graphe g1 = new Graphe(tableauN,tableauA,posJoueurs);
        System.out.println(g1.GetSuivanti(n1)); //j'ai utilisé GetSuivanti pour afficher sous forme d'integer pour tester
        launch(args);

    }

    public Noeud[] listeNoeudsAuto(Integer t){
        return null;
    }
}
