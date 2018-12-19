/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackeryard;

import javafx.scene.paint.Color;

/**
 *
 * @author Perso
 */
public class Joueur {
    Integer nombreT1;
    Integer nombreT2;
    Integer nombreT3;
    Color couleur;
    Noeud position;
    private String nom;

    public Joueur(String nom, Integer nombreT1, Integer nombreT2, Integer nombreT3, Noeud position, Color couleur) {
        this.nombreT1 = nombreT1;
        this.nombreT2 = nombreT2;
        this.nombreT3 = nombreT3;
        this.position = position;
        this.nom = nom;
        this.couleur = couleur;
    }
    
    public String getNom(){
        return this.nom;
    }
}
