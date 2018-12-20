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
 * Interface affichant un noeud du graphe
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
    int CONSTANTE_TAILLE = 65;

    public InterfaceNoeud(int posx, int posy, Noeud n) {
        this.posx = posx;
        this.posy = posy;
        this.noeud = n;
        connexion = new ArrayList<>();
        connexion.add(0);
        connexion.add(0);
        connexion.add(0);

        g = new Group();
        cercle = new Circle(CONSTANTE_TAILLE * posx + CONSTANTE_TAILLE, CONSTANTE_TAILLE * posy + CONSTANTE_TAILLE, 20);
        cercle.setStrokeWidth(4);
        g.getChildren().add(cercle);
        this.getChildren().add(g);
    }

    /**
     * Ajoute un joueur sur le noeud
     *
     * @param couleurJoueur
     */
    public void ajouterJoueur(Color couleurJoueur) {
        cercle.setStroke(couleurJoueur);
        isVisible = true;
    }

    /**
     * Supprime le joueur du noeud
     */
    public void supprimerJoueur() {
        cercle.setStroke(Color.TRANSPARENT);
        isVisible = false;
    }

    /**
     * Ajoute le hacker sur le noeud
     */
    public void ajouterHacker() {
        hacker = new Rectangle(CONSTANTE_TAILLE * posx + 47, CONSTANTE_TAILLE * posy + 47, 6, 6);
        hacker.setFill(Color.PURPLE);

        g.getChildren().add(hacker);
    }

    /**
     * Supprime le hacker du noeud
     */
    public void supprimerHacker() {
        if (hacker != null) {
            g.getChildren().remove(hacker);

        }
    }

    /**
     * Ajoute une connexion de type type sur le noeud
     * @param type 
     */
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

    /**
     * Affiche la connexion sous forme de rond
     */
    public void afficherConnexion() {
        connexion.removeIf(new Integer(0)::equals);
        switch (connexion.size()) {
            case 1:
                Circle arc = new Circle(CONSTANTE_TAILLE * posx + CONSTANTE_TAILLE, CONSTANTE_TAILLE * posy + CONSTANTE_TAILLE, 10);
                arc.setFill(Couleur.getCouleurArc(connexion.get(0)));
                g.getChildren().add(arc);
                break;
            case 2:
                Arc arc1 = new Arc();
                arc1.setCenterX(CONSTANTE_TAILLE * posx + CONSTANTE_TAILLE);
                arc1.setCenterY(CONSTANTE_TAILLE * posy + CONSTANTE_TAILLE);
                arc1.setRadiusX(10);
                arc1.setRadiusY(10);
                arc1.setStartAngle(90.0f);
                arc1.setLength(180.0f);
                arc1.setType(ArcType.ROUND);
                arc1.setFill(Couleur.getCouleurArc(connexion.get(0)));
                g.getChildren().add(arc1);

                Arc arc2 = new Arc();
                arc2.setCenterX(CONSTANTE_TAILLE * posx + CONSTANTE_TAILLE);
                arc2.setCenterY(CONSTANTE_TAILLE * posy + CONSTANTE_TAILLE);
                arc2.setRadiusX(10);
                arc2.setRadiusY(10);
                arc2.setStartAngle(270.0f);
                arc2.setLength(180.0f);
                arc2.setType(ArcType.ROUND);
                arc2.setFill(Couleur.getCouleurArc(connexion.get(1)));
                g.getChildren().add(arc2);
                break;
            case 3:
                Arc arc3 = new Arc();
                arc3.setCenterX(CONSTANTE_TAILLE * posx + CONSTANTE_TAILLE);
                arc3.setCenterY(CONSTANTE_TAILLE * posy + CONSTANTE_TAILLE);
                arc3.setRadiusX(10);
                arc3.setRadiusY(10);
                arc3.setStartAngle(90.0f);
                arc3.setLength(120.0f);
                arc3.setType(ArcType.ROUND);
                arc3.setFill(Couleur.getCouleurArc(connexion.get(0)));
                g.getChildren().add(arc3);

                Arc arc4 = new Arc();
                arc4.setCenterX(CONSTANTE_TAILLE * posx + CONSTANTE_TAILLE);
                arc4.setCenterY(CONSTANTE_TAILLE * posy + CONSTANTE_TAILLE);
                arc4.setRadiusX(10);
                arc4.setRadiusY(10);
                arc4.setStartAngle(210.0f);
                arc4.setLength(120.0f);
                arc4.setType(ArcType.ROUND);
                arc4.setFill(Couleur.getCouleurArc(connexion.get(1)));
                g.getChildren().add(arc4);

                Arc arc5 = new Arc();
                arc5.setCenterX(CONSTANTE_TAILLE * posx + CONSTANTE_TAILLE);
                arc5.setCenterY(CONSTANTE_TAILLE * posy + CONSTANTE_TAILLE);
                arc5.setRadiusX(10);
                arc5.setRadiusY(10);
                arc5.setStartAngle(330.0f);
                arc5.setLength(120.0f);
                arc5.setType(ArcType.ROUND);
                arc5.setFill(Couleur.getCouleurArc(connexion.get(2)));
                g.getChildren().add(arc5);
                break;
        }

        if (hacker != null) {
            hacker.toFront();
        }
    }
   
}
