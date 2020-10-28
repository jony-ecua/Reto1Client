/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comicSans.com.Reto1Client;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * FXML Controller class
 *
 * @author 2dam
 */
public class UILogOutController implements Initializable {

    @FXML
    private Pane idPane;
    @FXML
    private Label idLabelWelcome;
    @FXML
    private Button IdButtonLogOut;
    
    
    private Stage stage;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            //Cargar archivo fxml y lo carga
            FXMLLoader loader = new FXMLLoader(getClass().getResource("UILogOut.fxml"));
            Parent root = (Parent) loader.load();
            
            //Get controller para fxml
            //UILogOutController controller = ((UILogOutController)loader.getController());
            
            loader.load();
            //Inicializa primary stage
            //controller.initStage(root);
        } catch (IOException ex) {
            Logger.getLogger(UILogOutController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
    
    
    void setStage(Stage primaryStage) {
        stage = primaryStage;
    }
    

    void initStage(Parent root) {
        
        //Create a new scene
        Scene myScene = new Scene (root);
        //Associate scene to primaryStage(window)
        stage.setScene(myScene);
        //Set windows properties
        stage.setTitle("User login");
        stage.setResizable(false);
        //Set windows event handlers
        stage.setOnShowing(this::handleWindowShowing);
        
        //Set control event handlers and listeners
        //idTextUser.textProperty().addListener(this::textChanged);
        stage.show();
        
    }

    private void handleWindowShowing(WindowEvent event){
        //idButtonLogin.setDisable(true);
        
    }
    
}
