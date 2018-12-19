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
    private int nbTourHacker;
    private final int tourMax;
    private Noeud posHacker;

    public Jeu(ArrayList<Joueur> joueurs, Graphe graphe, int tourMax, Hacker hacker) {
        this.joueurs = joueurs;
        this.graphe = graphe;
        this.tourMax = tourMax;
        this.hacker = hacker;
        joueurCourant = 0;
        posHacker = hacker.position;
        nbTour = 0;
        nbTourHacker = 1;
    }

    /**
     * Rencoie la liste des joueurs
     * @return 
     */
    public ArrayList<Joueur> getJoueurs() {
        return joueurs;
    }

    /**
     * Renvoie le graphe
     * @return 
     */
    public Graphe getGraphe() {
        return graphe;
    }

    /**
     * Renvoie le nombre de tour
     * @return 
     */
    public int getNbTour() {
        return nbTour;
    }

    
    /**
     * Change de joueur
     */
    public void tourSuivant() {
        nbTour++;

        if (joueurCourant < joueurs.size() - 1) {
            joueurCourant++;
        } else {
            joueurCourant = 0;
        }
        if(!verifJoueurPeutJouer()){
            tourSuivant();
        }
        if(tourHacker()){
            nbTourHacker++;
        }
    }

    /**
     * Renvoie le joueur courant
     * @return 
     */
    public Joueur getJoueurCourant() {
        return joueurs.get(joueurCourant);
    }

    /**
     * Renvoie le nombre de tour restant
     * @return 
     */
    public int getTourRestant() {
        return tourMax - nbTour;
    }

    
    /**
     * Renvoie si c'est au tour du hacker de jouer
     * @return 
     */
    public boolean tourHacker(){
        if(hacker == getJoueurCourant()){
            return true;
        }
        return false;
    }
    
    /**
     * Ajoute la carte type au hacker
     * @param type 
     */
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
    
    /**
     * Verifie que le joueur courant possede les cartes necessaires afin de pouvoir se deplacer
     * @return 
     */
    public boolean verifJoueurPeutJouer() {
        for (Noeud n : graphe.GetSuivant(getJoueurCourant().position)) {
            int type = graphe.typeArc(n, getJoueurCourant().position);
            switch (type) {
                case 1:
                    if (getJoueurCourant().nombreT1 == 0) {
                        return false;
                    }
                    break;
                case 2:
                    if (getJoueurCourant().nombreT2 == 0) {
                        return false;
                    }
                    break;
                case 3:
                    if (getJoueurCourant().nombreT3 == 0) {
                        return false;
                    }
                    break;
            }

        }
        return true;
    }

    /**
     * Set la derniere position connue du hacker
     * @param posHacker 
     */
    public void setPosHacker(Noeud posHacker) {
        this.posHacker = posHacker;
    }

    
    /**
     * Retourne la derniere position connue du hacker
     * @return 
     */
    public Noeud getPosHacker() {
        return posHacker;
    }
    
    /**
     * Retourne le joueur hacker
     * @return 
     */
    public Hacker getHacker(){
        return hacker;
    }
    
    
    /**
     * Renvoie le nombre de tour joué par le hacker
     * @return 
     */
    public int getNbTourHacker(){
        return nbTourHacker;
    }
    
    
}
