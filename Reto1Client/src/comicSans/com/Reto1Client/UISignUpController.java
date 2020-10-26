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

        //idTextName.textProperty().addListener(this::textChanged); //Por qué va esto aquí?
  
        stage.show();
    }

    /**
     * Initializes the controller class.
     */
    public void initialize() {
        idButtonBack.setOnAction(this::openSignInWindow); //De donde me he sacado que esto va aqui?
        idButtonSignUp.setOnAction(this::openMainWindow);
        
        
    }

    /**
     * Inicializa el estado de la ventana.
     *
     * @param event determina que evento ha sucedido.
     */
    private void handleWindowShowing(WindowEvent event) {
        //logger.info("Begginning UISignUpController::handleWindowShowing");
        idButtonSignUp.setDisable(true);
    }

    /**
     * Cierra la ventana actual y abre la ventana de Sign In.
     *
     * @param event determina que evento ha sucedido.
     */
    private void openSignInWindow(ActionEvent event) {
        idLabelError.setText("Volviendo al Sign In..."); //Qutar más tarde
    }

    /**
     * Cierra la ventana actual y abre la ventana de Logout (Main).
     *
     * @param event
     */
    private void openMainWindow(ActionEvent event) {
        idLabelError.setText("Accediendo a la cuenta..."); //Qutar más tarde
    }
}
