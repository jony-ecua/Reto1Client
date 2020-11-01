/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comicSans.com.Controller;

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
        idButtonLogin.setOnAction(this::loginButtonPressed);
        idButtonSignUp.setOnAction(this::openSignUpWindow);
    }    
    
    
    public void setStage(Stage primaryStage) {
        stage = primaryStage;
    }

    public void initStage(Parent root) {
        
        //Create a new scene
        Scene myScene = new Scene (root);
        //Associate scene to primaryStage(window)
        stage.setScene(myScene);
        //Set windows properties
        stage.setTitle("User login");
        stage.setResizable(false);
        stage.show();
        
    }
    
    private void loginButtonPressed(ActionEvent event) {
        openLogOutWindow();
    }
    
    
    private void openLogOutWindow()  {
        try {
            // Loads the fxml archive
            FXMLLoader loader = new FXMLLoader(getClass().getResource("UILogOut.fxml"));
            Parent root = (Parent) loader.load();
            // Links the controller to the fxml
            UILogOutController controller = ((UILogOutController)loader.getController());
            //Sets the stage
            controller.setStage(stage);
            //Initializes the stage
            controller.initStage(root, idTextUser.getText());
        } catch (IOException ex) {
            Logger.getLogger(UISignInController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void openSignUpWindow(ActionEvent event)  {
        try {
            // Loads the fxml archive
            FXMLLoader loader = new FXMLLoader(getClass().getResource("UISignUp.fxml"));
            Parent root = (Parent) loader.load();
            // Links the controller to the fxml
            UISignUpController controller = ((UISignUpController)loader.getController());
            //Sets the stage
            controller.setStage(stage);
            //Initializes the stage
            controller.initStage(root);
        } catch (IOException ex) {
            Logger.getLogger(UISignInController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
