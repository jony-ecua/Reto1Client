/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comicSans.com.Reto1Client;

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
        //Cargar archivo fxml y lo carga
        FXMLLoader loader = new FXMLLoader(getClass().getResource("UISignIn.fxml"));
        Parent root = (Parent) loader.load();
        
        //Get controller para fxml
        UISignInController controller = ((UISignInController)loader.getController());
        
        controller.setStage(primaryStage);
        //Inicializa primary stage
        controller.initStage(root);
        
        
        
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
