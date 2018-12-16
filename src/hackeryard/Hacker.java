/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackeryard;

/**
 *
 * @author Perso
 */
public class Hacker extends Joueur {
    Integer nombreT4;
    Integer nombreT5;
    Integer tourDeJeu;

    public Hacker(Integer nombreT1, Integer nombreT2, Integer nombreT3, Integer position, Integer nombreT4, Integer nombreT5, Integer tourDeJeu) {
        super(nombreT1,nombreT2,nombreT3,position);
        this.nombreT4 = nombreT4;
        this.nombreT5 = nombreT5;
        this.tourDeJeu = tourDeJeu;
    }
    
}
