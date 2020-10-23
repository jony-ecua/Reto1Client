/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comicSans.com.Reto1Client;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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
public class UISignUpController /*implements Initializable*/ {

    private Stage stage;

    @FXML
    private Pane idPane;
    @FXML
    private Label idLabelName;
    @FXML
    private TextField idTextName;
    @FXML
    private Label idLabelUser;
    @FXML
    private Button idButtonSignUp;
    @FXML
    private Button idButtonBack;
    @FXML
    private Label idLabelTitle;
    @FXML
    private TextField idTextUser;
    @FXML
    private Label idLabelEmail;
    @FXML
    private TextField idTextEmail;
    @FXML
    private Label idLabelPassword;
    @FXML
    private PasswordField idTextPassword;
    @FXML
    private Label idLabelRepeatPassword;
    @FXML
    private PasswordField idTextRepeatPassword;
    @FXML
    private Label idLabelError;
    @FXML
    private Label idLabelPasswordError;
    @FXML
    private Label idLabelUserError;
    @FXML
    private Label idLabelEmailError;
    @FXML
    private Label idLabelNameError;

    /**
     * Initializes the controller class.
     */
    //@Override
    public void initialize(/*URL url, ResourceBundle rb*/) {
        idButtonBack.setOnAction(this::handleEventAction);
    }

    public void setStage(Stage stageSignUp) {
        stage = stageSignUp;
    }

    public void initStage(Parent root) {
        //logger.info("Initializing Sign up stage.");

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("User sign up");
        stage.setResizable(false);
        stage.setOnShowing(this::handleWindowShowing);
        stage.show();
    }

    private void handleWindowShowing(WindowEvent event) {
        //logger.info("Begginning UISignUpController::handleWindowShowing");
        idButtonSignUp.setDisable(true);
    }

    private void handleEventAction(ActionEvent event) {
        idLabelError.setText("hola");
    }
}