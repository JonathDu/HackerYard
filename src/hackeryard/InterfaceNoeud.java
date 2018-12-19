/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackeryard;

import java.util.ArrayList;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;

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
    Rectangle hacker;
    public boolean isVisible;
    Noeud noeud;
    ArrayList<Integer> connexion;

    public InterfaceNoeud(int posx, int posy, Noeud n) {
        this.posx = posx;
        this.posy = posy;
        this.noeud = n;
        connexion = new ArrayList<>();
        connexion.add(0);
        connexion.add(0);
        connexion.add(0);

        g = new Group();
        cercle = new Circle(50 * posx + 50, 50 * posy + 50, 20);
        cercle.setStrokeWidth(4);
        g.getChildren().add(cercle);
        this.getChildren().add(g);
    }

    public void ajouterJoueur(Color couleurJoueur) {
        cercle.setStroke(couleurJoueur);
        isVisible = true;
    }

    public void supprimerJoueur() {
        cercle.setStroke(Color.TRANSPARENT);
        isVisible = false;
    }
    
    public void ajouterHacker() {
        hacker = new Rectangle(50 * posx + 47, 50 * posy + 47, 6, 6);
        hacker.setFill(Color.PURPLE);

        g.getChildren().add(hacker);
    }

    public void supprimerHacker() {
        if (hacker != null) {
            g.getChildren().remove(hacker);

        }
    }

    public void ajouterConnexion(int type) {

        switch (type) {
            case 1:
                connexion.set(0, type);
                break;
            case 2:
                connexion.set(1, type);
                break;
            case 3:
                connexion.set(2, type);
                break;
        }

    }

    public void afficherConnexion() {

        Arc arc3 = new Arc();
        arc3.setCenterX(50 * posx + 50);
        arc3.setCenterY(50 * posy + 50);
        arc3.setRadiusX(10);
        arc3.setRadiusY(10);
        arc3.setStartAngle(90.0f);
        arc3.setLength(120.0f);
        arc3.setType(ArcType.ROUND);
        arc3.setFill(Couleur.getCouleurArc(connexion.get(0)));
        g.getChildren().add(arc3);

        Arc arc4 = new Arc();
        arc4.setCenterX(50 * posx + 50);
        arc4.setCenterY(50 * posy + 50);
        arc4.setRadiusX(10);
        arc4.setRadiusY(10);
        arc4.setStartAngle(210.0f);
        arc4.setLength(120.0f);
        arc4.setType(ArcType.ROUND);
        arc4.setFill(Couleur.getCouleurArc(connexion.get(1)));
        g.getChildren().add(arc4);

        Arc arc5 = new Arc();
        arc5.setCenterX(50 * posx + 50);
        arc5.setCenterY(50 * posy + 50);
        arc5.setRadiusX(10);
        arc5.setRadiusY(10);
        arc5.setStartAngle(330.0f);
        arc5.setLength(120.0f);
        arc5.setType(ArcType.ROUND);
        arc5.setFill(Couleur.getCouleurArc(connexion.get(2)));
        g.getChildren().add(arc5);

        if (hacker != null) {
            hacker.toFront();
        }
    }
}
