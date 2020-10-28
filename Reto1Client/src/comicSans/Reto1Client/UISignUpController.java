/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comicSans.Reto1Client;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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
 * @author Cristina Milea
 */
public class UISignUpController {

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
     * Define que vista se va a mostrar cuando se ejecute la aplicación.
     *
     * @param stageSignUp la vista que se mostrará desde el main.
     */
    public void setStage(Stage stageSignUp) {
        stage = stageSignUp;
    }

    /**
     * Inicializa la vista.
     *
     * @param root carga todos los nodos que descienden de root.
     */
    public void initStage(Parent root) {
        //logger.info("Initializing Sign up stage.");

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Sign up");
        stage.setResizable(false);
        stage.setOnShowing(this::handleWindowShowing);

        stage.show();
    }

    /**
     * Initializes the controller class.
     */
    public void initialize() {
        idButtonBack.setOnAction(this::openSignInWindow);
        idButtonSignUp.setOnAction(this::openLogOutWindow);

        disableButton();
        //idTextName.textProperty().addListener(this::textChanged);

    }

    /**
     * Inicializa el estado de la ventana.
     *
     * @param event determina que evento ha sucedido.
     */
    private void handleWindowShowing(WindowEvent event) {
        //logger.info("Begginning UISignUpController::handleWindowShowing");
        //idButtonSignUp.setDisable(true);
    }

    /**
     * Cierra la ventana actual y abre la ventana de Sign In.
     *
     * @param event determina que evento ha sucedido.
     */
    private void openSignInWindow(ActionEvent event) {
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
            Logger.getLogger(UILogOutController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Cierra la ventana actual y abre la ventana de Logout (Main).
     *
     * @param event
     */
     private void openLogOutWindow(ActionEvent event)  {
        try {
            // Loads the fxml archive
            FXMLLoader loader = new FXMLLoader(getClass().getResource("UILogOut.fxml"));
            Parent root = (Parent) loader.load();
            // Links the controller to the fxml
            UILogOutController controller = ((UILogOutController)loader.getController());
            //Sets the stage
            controller.setStage(stage);
            //Initializes the stage
            controller.initStage(root);
        } catch (IOException ex) {
            Logger.getLogger(UISignInController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Deshabilita el botón de Sign Up si todos los campos de texto están
     * vacíos.
     */
    private void disableButton() {
        idButtonSignUp.disableProperty().bind(
                idTextName.textProperty().isEmpty()
                        .or(idTextEmail.textProperty().isEmpty())
                        .or(idTextUser.textProperty().isEmpty())
                        .or(idTextPassword.textProperty().isEmpty())
                        .or(idTextRepeatPassword.textProperty().isEmpty())
        );
    }

    /*private void textChanged(ObservableValue observable, String oldValue, String newValue) {
        if (!idTextName.getText().trim().isEmpty()) {
            idButtonSignUp.setDisable(false);
        }
    }*/
    
    private void limitTextField(){
        
    }
    
    
}

