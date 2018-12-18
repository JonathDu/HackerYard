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
public class Noeud {

    Integer NoNoeud;
    int posX;
    int posY;

    public Noeud(Integer NoNoeud) {
        this.NoNoeud = NoNoeud;
    }

    public Noeud(Integer NoNoeud, int posX, int posY) {
        this.NoNoeud = NoNoeud;
        this.posX = posX;
        this.posY = posY;
    }


}
