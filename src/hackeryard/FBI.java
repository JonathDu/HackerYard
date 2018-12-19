/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackeryard;

import javafx.scene.paint.Color;

/**
 * Joueur policier (FBI), hérite de joueur
 *
 * @author Perso
 */
public class FBI extends Joueur {

    public FBI(String nom, Integer nombreT1, Integer nombreT2, Integer nombreT3, Noeud position, Color couleur) {
        super(nom, nombreT1, nombreT2, nombreT3, position, couleur);
    }

    public FBI(String nom, Integer nombreT1, Integer nombreT2, Integer nombreT3, Color couleur) {
        super(nom, nombreT1, nombreT2, nombreT3, couleur);
    }

}
