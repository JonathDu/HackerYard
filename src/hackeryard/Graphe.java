/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackeryard;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;
import java.util.Stack;

/**
 * Classe de graphe, composé d'une liste d'arcs, de noeuds et de joueurs
 *
 * @author Perso
 */
public class Graphe {

    ArrayList<Noeud> tableauNoeuds;
    ArrayList<Arc> tableauArcs;
    ArrayList<Joueur> tableauJoueurs;

    /**
     * Constructeur prenant en parametre des listes d'arcs, et noeuds et de
     * joueurs
     *
     * @param tableauNoeuds
     * @param tableauArcs
     * @param posJoueurs
     */
    public Graphe(ArrayList<Noeud> tableauNoeuds, ArrayList<Arc> tableauArcs, ArrayList<Joueur> posJoueurs) {
        this.tableauNoeuds = tableauNoeuds;
        this.tableauArcs = tableauArcs;
        this.tableauJoueurs = posJoueurs;
    }

    /**
     * Constructeur qui créé un graphe automatiquement, en passant en parametre
     * sa taille en hauteur, en largeur, et le nombre de noeuds
     *
     * @param nbn
     * @param tailleh
     * @param taillel
     */
    public Graphe(Integer nbn, Integer tailleh, Integer taillel) {
        Integer nbcase = tailleh * taillel;
        ArrayList<Integer> listecase = new ArrayList<>();
        this.tableauNoeuds = new ArrayList<>();
        this.tableauArcs = new ArrayList<>();
        for (int j = 0; j < nbcase; j++) {
            listecase.add(j);
        }
        Random rand = new Random();

        //Création des noeuds
        while (tableauNoeuds.size()!= nbn) {
            int n = rand.nextInt(nbcase - 1);
            System.out.println(n);
            if (listecase.contains(n)) {
                listecase.removeIf(yo -> yo.intValue() == n);
                tableauNoeuds.add(new Noeud(n % taillel, n / taillel));
            }
        }
        int v = 0;
        //On continue la génération tant que le graphe n'est pas connexe, ou n'a pas un nombre suffisant de degré par noeud
        while ((!isConnexe() || !verifMinDeg()) && v != 5) {
            //Génération des arcs de type 1
            for (int k = 0; k < nbn - 3; k++) {
                int n1 = rand.nextInt(tableauNoeuds.size() - 1);
                int n2 = rand.nextInt(tableauNoeuds.size() - 1);

                if (((tableauNoeuds.get(n1).posX == tableauNoeuds.get(n2).posX) && (Math.pow((tableauNoeuds.get(n1).posY - tableauNoeuds.get(n2).posY), 2) == 1)) || ((tableauNoeuds.get(n1).posY == tableauNoeuds.get(n2).posY) && (Math.pow((tableauNoeuds.get(n1).posX - tableauNoeuds.get(n2).posX), 2) == 1)) || ((((tableauNoeuds.get(n1).posX - tableauNoeuds.get(n2).posX) ^ 2) == 1) && (Math.pow((tableauNoeuds.get(n1).posY - tableauNoeuds.get(n2).posY), 2) == 1))) {

                    tableauArcs.add(new Arc(tableauNoeuds.get(n1), tableauNoeuds.get(n2), 1));

                } else {
                    k--;
                }
            }

            for (int l = 0; l < nbn/2; l++) {
                int n1 = rand.nextInt(tableauNoeuds.size() - 1);
                int n2 = rand.nextInt(tableauNoeuds.size() - 1);
                if (((Math.pow((tableauNoeuds.get(n1).posX - tableauNoeuds.get(n2).posX), 2) <= 4) && (Math.pow((tableauNoeuds.get(n1).posY - tableauNoeuds.get(n2).posY), 2) == 4)) || ((Math.pow((tableauNoeuds.get(n1).posX - tableauNoeuds.get(n2).posX), 2) == 4) && (Math.pow((tableauNoeuds.get(n1).posY - tableauNoeuds.get(n2).posY), 2) <= 4))) {
                    tableauArcs.add(new Arc(tableauNoeuds.get(n1), tableauNoeuds.get(n2), 2));
                } else {
                    l--;
                }

            }

            //Génération des arcs de type 2
            for (int m = 0; m < nbn/3; m++) {
                int n1 = rand.nextInt(tableauNoeuds.size() - 1);
                int n2 = rand.nextInt(tableauNoeuds.size() - 1);
                if (((Math.pow((tableauNoeuds.get(n1).posX - tableauNoeuds.get(n2).posX), 2) <= 9) && (Math.pow((tableauNoeuds.get(n1).posY - tableauNoeuds.get(n2).posY), 2) == 9)) || ((Math.pow((tableauNoeuds.get(n1).posX - tableauNoeuds.get(n2).posX), 2) == 9) && (Math.pow((tableauNoeuds.get(n1).posY - tableauNoeuds.get(n2).posY), 2) <= 9))) {
                    tableauArcs.add(new Arc(tableauNoeuds.get(n1), tableauNoeuds.get(n2), 3));
                } else {
                    m--;
                }
            }

            
            //Génération des arcs de type 3
            for (int o = 0; o < tableauNoeuds.size(); o++) {
                Boolean isRelie = false;
                for (int p = 0; p < tableauArcs.size(); p++) {
                    if (tableauNoeuds.get(o) == tableauArcs.get(p).n1 || tableauNoeuds.get(o) == tableauArcs.get(p).n2) {
                        isRelie = true;
                    }
                }
                if (isRelie == false) {
                    System.out.println("Le noeud " + tableauNoeuds.get(o).posX + "," + tableauNoeuds.get(o).posY + " est isole, on le supprime donc");
                    tableauNoeuds.remove(o);
                }
            }
            System.out.println(v);
            v++;
        }

        System.out.println(listecase);
        System.out.println(isConnexe());
        System.out.println(verifMinDeg());
    }

    /**
     * Renvoie les suivant d'un noeud
     *
     * @param n
     * @return
     */
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


    /**
     * Renvoie si le noeud n est occupé par un joueur
     *
     * @param n
     * @return
     */
    public Boolean estOccupe(Noeud n) {
        for (Joueur j : tableauJoueurs) {
            if (j.position == n) {
                return true;
            }
        }
        return false;
    }

    /**
     * Renvoie le joueur occupant le noeud n, null si aucun
     *
     * @param n
     * @return
     */
    public Joueur occupant(Noeud n) {
        for (Joueur j : tableauJoueurs) {
            if (j.position == n) {
                return j;
            }
        }
        return null;
    }

    /**
     * Renvoie le type d'arc entre le noeud n1 et n2
     *
     * @param n1
     * @param n2
     * @return
     */
    public int typeArc(Noeud n1, Noeud n2) {
        for (Arc a : tableauArcs) {
            if ((a.n1 == n1 && a.n2 == n2) || (a.n2 == n1 && a.n1 == n2)) {
                return a.typeArc;
            }
        }
        return -1;
    }

    /**
     * Ajoute une liste de joueur au graphe et leur assigne un noeud
     * aléatoirement
     *
     * @param liste
     */
    public void addJoueur(ArrayList<Joueur> liste) {
        Random rand = new Random();
        this.tableauJoueurs = liste;
        ArrayList<Noeud> temp = (ArrayList<Noeud>) tableauNoeuds.clone();
        for (Joueur j : tableauJoueurs) {
            int t = rand.nextInt(temp.size() - 1);
            j.position = temp.get(t);
            temp.remove(t);
        }
    }

    /**
     * Renvoie si le graphe obtenue est connexe
     *
     * @return
     */
    public boolean isConnexe() {
        Random rand = new Random();
        Noeud depart = tableauNoeuds.get(rand.nextInt(tableauNoeuds.size() - 1));
        ArrayList<Noeud> composanteConnexe = new ArrayList<>();
        Stack<Noeud> pile = new Stack<>();
        pile.add(depart);
        while (!pile.empty()) {
            Noeud n = pile.pop();
            for (Noeud t : GetSuivant(n)) {
                if (!composanteConnexe.contains(t) && !pile.contains(t)) {
                    pile.add(t);
                }
            }
            composanteConnexe.add(n);
        }
        if (composanteConnexe.size() == tableauNoeuds.size()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Renvoie false si un noeud possede moins de deux suivant
     * @return 
     */
    public boolean verifMinDeg() {
        for (Noeud n : tableauNoeuds) {
            ArrayList<Noeud> temp = removeMultiple(this.GetSuivant(n));
            if(temp.size() < 2){
                return false;
            }
        }
        return true;
    }
    
    /**
     * Renvoie une liste de noeud vider des doublons
     * @param liste
     * @return 
     */
    private ArrayList<Noeud> removeMultiple(ArrayList<Noeud> liste){
        Set<Noeud> remove = new LinkedHashSet<Noeud>(liste);
        liste.clear();
        liste.addAll(remove);
        return liste;
    }
}
