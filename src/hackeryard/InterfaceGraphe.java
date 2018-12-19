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
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

/**
 *
 * @author jonathan
 */
public class InterfaceGraphe extends Parent {

    private final ArrayList<Circle> noeuds;
    private HashMap<Circle, Noeud> circleToNoeud;

    public InterfaceGraphe(Controller controller, Jeu jeu) {
        Group root = new Group();
        Graphe g = jeu.getGraphe();
        noeuds = new ArrayList<>();
        circleToNoeud = new HashMap<>();
        Noeud grille[][] = new Noeud[g.tableauNoeuds.size()][g.tableauNoeuds.size()];

        for (Noeud n : g.tableauNoeuds) {
            grille[n.posX][n.posY] = n;
        }

        for (int i = 0; i < grille.length; i++) {
            for (int j = 0; j < grille[i].length; j++) {
                if (grille[i][j] != null) {
                    Circle c = new Circle(50 * i + 50, 50 * j + 50, 10);
                    noeuds.add(c);
                    circleToNoeud.put(c, grille[i][j]);
                    for (Noeud n : g.GetSuivant(grille[i][j])) {
                        Line l = new Line(50 * i + 50, 50 * j + 50, 50 * n.posX + 50, 50 * n.posY + 50);
                        root.getChildren().add(l);
                    }
                }
            }
        }
        for (Circle c : noeuds) {
            root.getChildren().add(c);
            c.addEventHandler(MouseEvent.MOUSE_CLICKED, new HandlerNoeud(circleToNoeud.get(c), jeu, controller));

        }
        this.getChildren().add(root);
    }

}
