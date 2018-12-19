/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackeryard;

import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author jonathan
 */
public class InterfaceNoeud extends Parent {

    Circle cercle;
    int posx;
    int posy;
    Group g;
    Rectangle joueur;
    Noeud noeud;

    public InterfaceNoeud(int posx, int posy, Noeud n) {
        this.posx = posx;
        this.posy = posy;
        this.noeud = n;
        g = new Group();
        cercle = new Circle(50 * posx + 50, 50 * posy + 50, 10);

        g.getChildren().add(cercle);
        this.getChildren().add(g);
    }

    public void ajouterJoueur(Color couleurJoueur) {
        joueur = new Rectangle(50 * posx + 50, 50 * posy + 50, 5, 5);
        joueur.setFill(couleurJoueur);

        g.getChildren().add(joueur);
    }

    public void supprimerJoueur() {
        if (joueur != null) {
            g.getChildren().remove(joueur);
            
        }
    }

}
