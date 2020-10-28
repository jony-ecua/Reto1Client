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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * FXML Controller class
 *
 * @author 2dam
 */
public class UISignInController {

    @FXML
    private Pane idPane;
    @FXML
    private Label idLabelUser;
    @FXML
    private TextField idTextUser;
    @FXML
    private Label idLabelPassword;
    @FXML
    private PasswordField idTextPassword;
    @FXML
    private Button idButtonLogin;
    @FXML
    private Button idButtonSignUp;
    @FXML
    private Label idLabelTitle;
    @FXML
    private Label idLabelError;
    @FXML
    private Label idLabelDontHaveAccount;
    
    
    private Stage stage;

    /**
     * Initializes the controller class.
     */
    public void initialize() {
        idButtonLogin.setOnAction(this::handleButtonAction);
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
    
    private void textChanged(ActionEvent event){
        
        
    }
    
    private void handleButtonAction(ActionEvent event)  {
        
        
        try {
            //Cargar archivo fxml y lo carga
            FXMLLoader loader = new FXMLLoader(getClass().getResource("UISignIn.fxml"));
            Parent root = (Parent) loader.load();
            //Get controller para fxml
            UILogOutController controller = ((UILogOutController)loader.getController());
            
            
            loader.setController(controller);
            
            Pane mainPane = (Pane) loader.load();
            
            
            /*
            //note that on this line you can substitue "Screen2.fxml" for a string chosen prior to this line.
            Parent loader;
            try {
            loader = FXMLLoader.load(getClass().getResource("UILogOut.fxml")); //Creates a Parent called loader and assign it as ScReen2.FXML
            
            
            Scene scene = new Scene(loader); //This creates a new scene called scene and assigns it as the Sample.FXML document which was named "loader"
            
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow(); //this accesses the window.
            
            app_stage.setScene(scene); //This sets the scene as scene
            
            app_stage.show(); // this shows the scene
            } catch (IOException ex) {
            Logger.getLogger(UISignInController.class.getName()).log(Level.SEVERE, null, ex);
            }*/
        } catch (IOException ex) {
            Logger.getLogger(UISignInController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
