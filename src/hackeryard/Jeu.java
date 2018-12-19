/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackeryard;

import java.util.ArrayList;

/**
 *
 * @author jonathan
 */
public class Jeu {
    private ArrayList<Joueur> joueurs;
    private int joueurCourant;
    private Graphe graphe;
    private int nbTour;
    private int tourMax;

    public Jeu(ArrayList<Joueur> joueurs, Graphe graphe, int tourMax) {
        this.joueurs = joueurs;
        this.graphe = graphe;
        this.tourMax = tourMax;
        joueurCourant = 0;
        nbTour = 0;
    }

    public ArrayList<Joueur> getJoueurs() {
        return joueurs;
    }

    public Graphe getGraphe() {
        return graphe;
    }

    public int getNbTour() {
        return nbTour;
    }
    
    public void tourSuivant(){
        nbTour++;
        if(nbTour >= tourMax){
            
        }
        if(joueurCourant < joueurs.size()-1){
            joueurCourant++;
        }else{
            joueurCourant = 0;
        }
    }
    
    public Joueur getJoueurCourant(){
        return joueurs.get(joueurCourant);
    }
    
    public int getTourRestant(){
        return tourMax - nbTour;
    }
    
    
}
