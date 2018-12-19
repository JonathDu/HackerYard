/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackeryard;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Perso
 */
public class Graphe {

    ArrayList<Noeud> tableauNoeuds;
    ArrayList<Arc> tableauArcs;
    ArrayList<Joueur> tableauJoueurs;

    public Graphe(ArrayList<Noeud> tableauNoeuds, ArrayList<Arc> tableauArcs, ArrayList<Joueur> posJoueurs) {
        this.tableauNoeuds = tableauNoeuds;
        this.tableauArcs = tableauArcs;
        this.tableauJoueurs = tableauJoueurs;
    }
    
    public Graphe(Integer nbn, Integer tailleh, Integer taillel) {
        Integer nbcase=tailleh*taillel;
        ArrayList<Noeud> tableauN = new ArrayList<>();
        ArrayList<Arc> tableauA = new ArrayList<>();
        ArrayList<Integer> listecase = new ArrayList<>();
        for (int j=0;j<nbcase;j++){
            listecase.add(j);
        }
        Random rand = new Random();
        
        for (int i=0;i<nbn;i++){
        int n = rand.nextInt(nbcase-1);
        if (!listecase.contains(n)){
            listecase.remove(n);
            tableauN.add(new Noeud(n%taillel,n/taillel));
        }
        }
        
    }

    public ArrayList<Noeud> GetSuivant(Noeud n) {
        ArrayList<Noeud> listeSuivant = new ArrayList<>();
        int nombrearcs = tableauArcs.size();
        for (int i = 0; i < nombrearcs; i++) {
            if (tableauArcs.get(i).n1 == n) {
                listeSuivant.add(tableauArcs.get(i).n2);
            } else if (tableauArcs.get(i).n2 == n) {
                listeSuivant.add(tableauArcs.get(i).n1);
            }
        }
        return listeSuivant;

    }

    public ArrayList<Integer> GetSuivanti(Noeud n) {
        ArrayList<Integer> listeSuivant = new ArrayList<>();
        int nombrearcs = tableauArcs.size();
        for (int i = 0; i < nombrearcs; i++) {
            if (tableauArcs.get(i).n1 == n) {
                listeSuivant.add(tableauArcs.get(i).n2.posX+(tableauArcs.get(i).n2.posY)*4);
            } else if (tableauArcs.get(i).n2 == n) {
                listeSuivant.add(tableauArcs.get(i).n1.posX+(tableauArcs.get(i).n1.posY)*4);
            }
        }
        return listeSuivant;
    }

    public Boolean estOccupee(Noeud n) {
        for (Joueur j : tableauJoueurs) {
            if (j.position == n) {
                return true;
            }
        }
        return false;
    }

    public Joueur occupant(Noeud n) {
        for (Joueur j : tableauJoueurs) {
            if (j.position == n) {
                return j;
            }
        }
        return null;
    }
}
