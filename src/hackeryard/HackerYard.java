/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackeryard;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author jonathan
 */
public class HackerYard extends Application {

    Stage stage;
    Scene scene;

    @Override
    public void start(Stage primaryStage) {
        stage = primaryStage;

        scene = new Scene(new Group(), 800, 600);
        stage.setScene(scene);

        Controller controller = new Controller(stage, scene);

        controller.toMenu();
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        launch(args);

    }

}
