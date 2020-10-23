/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comicSans.com.Reto1Client;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author jonyv
 */
public class Client extends Application {
    
    @Override
    public void start(Stage stageSignUp) throws Exception {
        //Parent root = FXMLLoader.load(getClass().getResource("UISignUp.fxml"));

        
        FXMLLoader loader=new FXMLLoader(getClass().getResource("UISignUp.fxml"));
        Parent root=(Parent)loader.load();
        UISignUpController controller=((UISignUpController)loader.getController());
        controller.setStage(stageSignUp);
        controller.initStage(root);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
