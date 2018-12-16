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
public class Arc {

    Noeud n1;
    Noeud n2;
    Integer typeArc;

    public Arc(Noeud noeud1, Noeud noeud2, Integer type) {
        n1 = noeud1;
        n2 = noeud2;
        typeArc = type;

    }
}
