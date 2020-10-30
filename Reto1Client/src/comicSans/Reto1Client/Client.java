/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comicSans.Reto1Client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Nerea Aranguren
 */
public class Client extends Application {
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Loads the fxml archive
        FXMLLoader loader = new FXMLLoader(getClass().getResource("UISignUp.fxml"));
        Parent root = (Parent) loader.load();
        // Links the controller to the fxml
        UISignUpController controller = ((UISignUpController)loader.getController());
        //Sets the primary stage
        controller.setStage(primaryStage);
        //Initializes the primary stage
        controller.initStage(root);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
