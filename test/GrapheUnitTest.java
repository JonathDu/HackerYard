/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import hackeryard.Arc;
import hackeryard.FBI;
import hackeryard.Graphe;
import hackeryard.Joueur;
import hackeryard.Noeud;
import java.util.ArrayList;
import java.util.Collection;
import javafx.scene.paint.Color;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jonathan
 */
public class GrapheUnitTest {

    public GrapheUnitTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void testverifMinDeg() {
        ArrayList<Joueur> aj = new ArrayList<Joueur>();
        aj.add(new FBI("jo", 1, 1, 1, Color.AZURE));

        ArrayList<Arc> aa = new ArrayList<>();
        ArrayList<Noeud> an = new ArrayList<>();

        Noeud n1 = new Noeud(1, 1);
        Noeud n2 = new Noeud(2, 1);
        an.add(n1);
        an.add(n2);

        Arc a1 = new Arc(n1, n2, 1);
        Arc a2 = new Arc(n2, n1, 1);
        aa.add(a2);
        aa.add(a1);

        Graphe g1 = new Graphe(an, aa, aj);
        assertFalse(g1.verifMinDeg());

        Noeud n3 = new Noeud(2, 2);
        Arc a3 = new Arc(n3, n1, 1);
        Arc a4 = new Arc(n2, n3, 1);

        aa.add(a3);
        aa.add(a4);

        an.add(n3);

        Graphe g2 = new Graphe(an, aa, aj);
        assertTrue(g2.verifMinDeg());
    }

    @Test
    public void testConnexe() {
        ArrayList<Joueur> aj = new ArrayList<Joueur>();
        aj.add(new FBI("jo", 1, 1, 1, Color.AZURE));

        ArrayList<Arc> aa = new ArrayList<>();
        ArrayList<Noeud> an = new ArrayList<>();

        Noeud n1 = new Noeud(1, 1);
        Noeud n2 = new Noeud(2, 1);
        an.add(n1);
        an.add(n2);

        Graphe g1 = new Graphe(an, aa, aj);
        assertFalse(g1.isConnexe());

        Arc a1 = new Arc(n1, n2, 1);
        Arc a2 = new Arc(n2, n1, 1);
        aa.add(a2);
        aa.add(a1);

        Graphe g2 = new Graphe(an, aa, aj);
        assertTrue(g2.isConnexe());

    }
}
