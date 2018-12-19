/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackeryard;

import java.util.ArrayList;
import java.util.Random;
import javafx.scene.paint.Color;

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
        this.tableauJoueurs = posJoueurs;
    }

    public Graphe(Integer nbn, Integer tailleh, Integer taillel) {
        Integer nbcase = tailleh * taillel;
        ArrayList<Noeud> tableauN = new ArrayList<>();
        ArrayList<Arc> tableauA = new ArrayList<>();
        ArrayList<Integer> listecase = new ArrayList<>();
        for (int j = 0; j < nbcase; j++) {
            listecase.add(j);
        }
        Random rand = new Random();

        for (int i = 0; i < nbn; i++) {
            int n = rand.nextInt(nbcase - 1);
            System.out.println(n);
            if (listecase.contains(n)) {
                listecase.removeIf(yo -> yo.intValue() == n);
                tableauN.add(new Noeud(n % taillel, n/taillel));
            }
            else {
                i--;
            }
        }
        for (int k = 0; k < nbn-3; k++) {
            int n1 = rand.nextInt(tableauN.size() - 1);
            int n2 = rand.nextInt(tableauN.size() - 1);
            
            if (((tableauN.get(n1).posX == tableauN.get(n2).posX) && (Math.pow((tableauN.get(n1).posY - tableauN.get(n2).posY),2) == 1)) || ((tableauN.get(n1).posY == tableauN.get(n2).posY) && (Math.pow((tableauN.get(n1).posX - tableauN.get(n2).posX),2) == 1)) || ((((tableauN.get(n1).posX - tableauN.get(n2).posX) ^ 2) == 1) && (Math.pow((tableauN.get(n1).posY - tableauN.get(n2).posY),2) == 1))) {

                tableauA.add(new Arc(tableauN.get(n1), tableauN.get(n2), 1));

            }
            else {
                k--;
            }
        }
        for (int l=0;l<nbn/2;l++){
            int n1 = rand.nextInt(tableauN.size() - 1);
            int n2 = rand.nextInt(tableauN.size() - 1);
            if (((Math.pow((tableauN.get(n1).posX - tableauN.get(n2).posX),2) <= 4) && (Math.pow((tableauN.get(n1).posY - tableauN.get(n2).posY),2) == 4)) || ((Math.pow((tableauN.get(n1).posX - tableauN.get(n2).posX),2) == 4) && (Math.pow((tableauN.get(n1).posY - tableauN.get(n2).posY),2) <= 4))){
                tableauA.add(new Arc(tableauN.get(n1), tableauN.get(n2), 2));
            }
            else {
                l--;
            }
            
            
            
        }
        
        for (int m=0;m<nbn/3;m++){
            int n1 = rand.nextInt(tableauN.size() - 1);
            int n2 = rand.nextInt(tableauN.size() - 1);
            if (((Math.pow((tableauN.get(n1).posX - tableauN.get(n2).posX),2) <= 9) && (Math.pow((tableauN.get(n1).posY - tableauN.get(n2).posY),2) == 9)) || ((Math.pow((tableauN.get(n1).posX - tableauN.get(n2).posX),2) == 9) && (Math.pow((tableauN.get(n1).posY - tableauN.get(n2).posY),2) <= 9))){
                tableauA.add(new Arc(tableauN.get(n1), tableauN.get(n2), 3));
            }
            else {
                m--;
            }
        }
        

        
//        int n1 = rand.nextInt(tableauN.size() - 1);
//        int n2 = rand.nextInt(tableauN.size() - 1);
//        ArrayList<Joueur> posJoueurs = new ArrayList<>();
//        posJoueurs.add(new FBI("pat",2,2,2,tableauN.get(n1), Color.BLUE));
//        posJoueurs.add(new FBI("leo",2,2,2,tableauN.get(n2), Color.CHOCOLATE));
        this.tableauNoeuds = tableauN;
        this.tableauArcs = tableauA;
//        this.tableauJoueurs = posJoueurs;
        System.out.println(listecase);
        System.out.println(tableauN);
        System.out.println(tableauA);
    }

    public ArrayList<Noeud> GetSuivant(Noeud n) {
        ArrayList<Noeud> listeSuivant = new ArrayList<>();
        int nombrearcs = tableauArcs.size();
        for (int i = 0; i < nombrearcs; i++) {
            if (tableauArcs.get(i).n1 == n) {
                listeSuivant.add(tableauArcs.get(i).n2);
            } 
            if (tableauArcs.get(i).n2 == n) {
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
                listeSuivant.add(tableauArcs.get(i).n2.posX + (tableauArcs.get(i).n2.posY) * 4);
            } else if (tableauArcs.get(i).n2 == n) {
                listeSuivant.add(tableauArcs.get(i).n1.posX + (tableauArcs.get(i).n1.posY) * 4);
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

    public int typeArc(Noeud n1, Noeud n2) {
        for (Arc a : tableauArcs) {
            if ((a.n1 == n1 && a.n2 == n2) || (a.n2 == n1 && a.n1 == n2) ) {
                return a.typeArc;
            }
        }
        return -1;
    }
    
    public void addJoueur(ArrayList<Joueur> liste){
        Random rand = new Random();
        this.tableauJoueurs = liste;
        ArrayList<Noeud> temp = (ArrayList<Noeud>)tableauNoeuds.clone();
        for(Joueur j : tableauJoueurs){
            int t = rand.nextInt(temp.size()-1);
            j.position = temp.get(t);
            temp.remove(t);
        }
    }
}
