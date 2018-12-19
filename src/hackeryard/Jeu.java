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

    private final ArrayList<Joueur> joueurs;
    private final Hacker hacker;
    private int joueurCourant;
    private final Graphe graphe;
    private int nbTour;
    private final int tourMax;

    public Jeu(ArrayList<Joueur> joueurs, Graphe graphe, int tourMax, Hacker hacker) {
        this.joueurs = joueurs;
        this.graphe = graphe;
        this.tourMax = tourMax;
        this.hacker = hacker;
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

    public void tourSuivant() {
        nbTour++;
        if (nbTour >= tourMax) {

        }
        if (joueurCourant < joueurs.size() - 1) {
            joueurCourant++;
        } else {
            joueurCourant = 0;
        }
    }

    public Joueur getJoueurCourant() {
        return joueurs.get(joueurCourant);
    }

    public int getTourRestant() {
        return tourMax - nbTour;
    }

    public void addCarteHacker(int type) {
        switch (type) {
            case 1:
                hacker.nombreT1++;
                break;
            case 2:
                hacker.nombreT2++;
                break;
            case 3:
                hacker.nombreT3++;
                break;
        }
    }

}
