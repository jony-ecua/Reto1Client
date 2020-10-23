/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comicSans.com.Reto1Client;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
        idTextUser.setOnKeyTyped(this::handleTextChanged);
        stage.show();
        
    }

    private void handleWindowShowing(WindowEvent event){
        idButtonLogin.setDisable(true);
        
    }
    
    private void handleTextChanged(WindowEvent event){
        idLabelUser.setText("hola");
        
    }
    
}
