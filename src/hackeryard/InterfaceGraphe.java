/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackeryard;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.HashMap;
import javafx.event.EventType;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

/**
 *
 * @author jonathan
 */
public class InterfaceGraphe extends Parent {

    private final ArrayList<InterfaceNoeud> noeuds;
    private HashMap<Noeud, InterfaceNoeud> noeudToInterface;

    public InterfaceGraphe(Controller controller, Jeu jeu) {
        Group root = new Group();
        Graphe g = jeu.getGraphe();
        noeuds = new ArrayList<>();
        noeudToInterface = new HashMap<>();
        Noeud grille[][] = new Noeud[g.tableauNoeuds.length][g.tableauNoeuds.length];

        for (Noeud n : g.tableauNoeuds) {
            grille[n.posX][n.posY] = n;
        }

        for (int i = 0; i < grille.length; i++) {
            for (int j = 0; j < grille[i].length; j++) {
                if (grille[i][j] != null) {
                    InterfaceNoeud c = new InterfaceNoeud(grille[i][j].NoNoeud, i, j, grille[i][j]);
                    noeudToInterface.put(grille[i][j], c);
                    if(g.estOccupee(grille[i][j])){
                        c.ajouterJoueur(g.occupant(grille[i][j]).couleur);
                    }
                    noeuds.add(c);
                    for (Noeud n : g.GetSuivant(grille[i][j])) {
                        Line l = new Line(50 * i + 50, 50 * j + 50, 50 * n.posX + 50, 50 * n.posY + 50);
                        root.getChildren().add(l);
                    }
                }
            }
        }
        for (InterfaceNoeud c : noeuds) {
            root.getChildren().add(c);
            c.addEventHandler(MouseEvent.MOUSE_CLICKED, new HandlerNoeud(c, jeu, controller, noeudToInterface));
            
        }
        this.getChildren().add(root);
    }

}
