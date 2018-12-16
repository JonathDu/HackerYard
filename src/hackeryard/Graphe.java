/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackeryard;

import java.util.ArrayList;

/**
 *
 * @author Perso
 */
public class Graphe {

    Noeud tableauNoeuds[];
    Arc tableauArcs[];
    Joueur tableauJoueurs[];

    public Graphe(Noeud[] tableauNoeuds, Arc[] tableauArcs, Integer[] posJoueurs) {
        this.tableauNoeuds = tableauNoeuds;
        this.tableauArcs = tableauArcs;
        this.tableauJoueurs = tableauJoueurs;
    }


    public ArrayList<Noeud> GetSuivant(Noeud n) {
        ArrayList<Noeud> listeSuivant = new ArrayList<>();
        int nombrearcs = tableauArcs.length;
        for (int i = 0; i < nombrearcs; i++) {
            if (tableauArcs[i].n1.NoNoeud == n.NoNoeud) {
                listeSuivant.add(tableauArcs[i].n2);
            } else if (tableauArcs[i].n2.NoNoeud == n.NoNoeud) {
                listeSuivant.add(tableauArcs[i].n1);
            }
        }
        return listeSuivant;

    }

    public ArrayList<Integer> GetSuivanti(Noeud n) {
        ArrayList<Integer> listeSuivant = new ArrayList<>();
        int nombrearcs = tableauArcs.length;
        for (int i = 0; i < nombrearcs; i++) {
            if (tableauArcs[i].n1.NoNoeud == n.NoNoeud) {
                listeSuivant.add(tableauArcs[i].n2.NoNoeud);
            } else if (tableauArcs[i].n2.NoNoeud == n.NoNoeud) {
                listeSuivant.add(tableauArcs[i].n1.NoNoeud);
            }
        }
        return listeSuivant;
    }
}
