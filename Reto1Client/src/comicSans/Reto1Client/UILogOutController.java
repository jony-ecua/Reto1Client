/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comicSans.Reto1Client;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Loug Out Controller class
 * Defines the methods that control the performance of the window UILogOut.
 * @author Nerea Aranguren
 */
public class UILogOutController {

    @FXML
    private Pane idPane;
    @FXML
    private Label idLabelWelcome;
    @FXML
    private Button idButtonLogOut;
   
    private Stage stage;
  
    /**
     * Defines the view to show when the controller is executed.
     * 
     * @param secondaryStage the view sent from the class that called the method.
     */
    void setStage(Stage secondaryStage) {
        stage = secondaryStage;
    }

    /**
     * Initializes the view.
     * 
     * @param root Includes all the nodes.
     * @param userName The name to be shown in the label idLabelWelcome.
     */
    void initStage(Parent root, String userName) {
        //Creates a new scene
        Scene myScene = new Scene (root);
        //Associates scene to the stage(window)
        stage.setScene(myScene);
        //Set windows properties
        stage.setTitle("Log Out");
        stage.setResizable(false);
        
        idButtonLogOut.setOnAction(this::openSignInWindow);
        // Includes the user login in the Welcome label
        idLabelWelcome.setText(idLabelWelcome.getText() + ", " +userName);
        
        stage.show();
    }
    
    /**
     * Loads the FXml and controller to open the Sign In window.
     * 
     * @param event Contains the action ejecuted on the button.
     */
    private void openSignInWindow(ActionEvent event)  {
        try {
            // Loads the fxml archive
            FXMLLoader loader = new FXMLLoader(getClass().getResource("UISignIn.fxml"));
            Parent root = (Parent) loader.load();
            // Links the controller to the fxml
            UISignInController controller = ((UISignInController)loader.getController());
            //Sets the stage
            controller.setStage(stage);
            //Initializes the stage
            controller.initStage(root);
        } catch (IOException ex) {
            Logger.getLogger(UILogOutController.class.getName()).log(Level.SEVERE, null, ex);//////////////////////////
        }
    }
}
