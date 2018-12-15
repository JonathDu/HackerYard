/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackeryard;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *Partie commune a toutes les interfaces
 * @author jonathan
 */
public abstract class Interface extends Parent{
    HackerYard main;
    Scene scene;

    protected Interface(HackerYard main, Scene scene) {
        this.main = main;
        this.scene = scene;
    }
    
    

    
    
}
