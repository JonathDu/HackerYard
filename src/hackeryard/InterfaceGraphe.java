/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackeryard;

import java.util.ArrayList;
import java.util.HashMap;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

/**
 * Classe affichant le graphe
 *
 * @author jonathan
 */
public class InterfaceGraphe extends Parent {

    private final ArrayList<InterfaceNoeud> noeuds;
    private HashMap<Noeud, InterfaceNoeud> noeudToInterface;
    int CONSTANTE_TAILLE = 65;

    public InterfaceGraphe(Controller controller, Jeu jeu) {
        Group root = new Group();
        Graphe g = jeu.getGraphe();
        noeuds = new ArrayList<>();
        noeudToInterface = new HashMap<>();
        Noeud grille[][] = new Noeud[g.tableauNoeuds.size()][g.tableauNoeuds.size()];

        for (Noeud n : g.tableauNoeuds) {
            grille[n.posX][n.posY] = n;
        }

        for (int i = 0; i < grille.length; i++) {
            for (int j = 0; j < grille[i].length; j++) {
                if (grille[i][j] != null) {
                    InterfaceNoeud c = new InterfaceNoeud(i, j, grille[i][j]);
                    noeudToInterface.put(grille[i][j], c);
                    if (g.estOccupe(grille[i][j]) && g.occupant(grille[i][j]).couleur != Color.PURPLE) {;
                        c.ajouterJoueur(g.occupant(grille[i][j]).couleur);
                    }
                    noeuds.add(c);
                    for (Noeud n : g.GetSuivant(grille[i][j])) {
                        Line l = new Line(CONSTANTE_TAILLE * i + CONSTANTE_TAILLE, CONSTANTE_TAILLE * j + CONSTANTE_TAILLE, CONSTANTE_TAILLE * n.posX + CONSTANTE_TAILLE, CONSTANTE_TAILLE * n.posY + CONSTANTE_TAILLE);
                        switch (g.typeArc(n, grille[i][j])) {
                            case 1:
                                l.setStroke(Color.BISQUE);
                                c.ajouterConnexion(1);
                                break;
                            case 2:
                                l.setStroke(Color.CHOCOLATE);
                                c.ajouterConnexion(2);
                                break;
                            case 3:
                                l.setStroke(Color.DARKRED);
                                c.ajouterConnexion(3);
                                break;
                        }

                        root.getChildren().add(l);
                    }
                }
            }
        }
        for (InterfaceNoeud c : noeuds) {
            c.afficherConnexion();
            root.getChildren().add(c);
            c.addEventHandler(MouseEvent.MOUSE_CLICKED, new HandlerNoeud(c, jeu, controller, noeudToInterface));
            c.setOnMouseEntered((t) -> {
                if (jeu.getGraphe().GetSuivant(jeu.getJoueurCourant().position).contains(c.noeud) && (!g.estOccupe(c.noeud) || g.occupant(c.noeud) == jeu.getHacker())) {
                    c.cercle.setRadius(25);

                }

            });
            c.setOnMouseExited((t) -> {
                c.cercle.setRadius(20);

            });
        }
        this.getChildren().add(root);
    }

    /**
     * Affiche la position du joueur j
     *
     * @param j
     */
    public void afficherJoueur(Joueur j) {
        noeudToInterface.get(j.position).ajouterJoueur(j.couleur);
    }

    /**
     * Cache la position du joueur j
     *
     * @param j
     */
    public void cacherJoueur(Joueur j) {
        noeudToInterface.get(j.position).supprimerJoueur();
    }

}
