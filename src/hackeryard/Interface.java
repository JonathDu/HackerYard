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
    Controller controller;
    Scene scene;

    protected Interface(Controller controller, Scene scene) {
        this.controller = controller;
        this.scene = scene;
    }
    
    

    
    
}
