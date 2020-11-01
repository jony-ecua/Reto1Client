/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comicSans.com.Controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * FXML Sign Up Controller class Defines the methods that control the
 * performance of the window UISignUp.
 *
 * @author Cristina Milea and Nerea Aranguren
 */
public class UISignUpController {

    private Stage stage;
    private static final int MAX_LENGHT = 50;
    public static final Pattern VALIDEMAIL = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    public static final Pattern VALIDPASS = Pattern.compile("^[a-zA-Z0-9]+$");

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
     * Defines which view is going to show up when the application executes.
     *
     * @param stageSignUp the view that will show from the main application.
     */
    public void setStage(Stage stageSignUp) {
        stage = stageSignUp;
    }

    /**
     * Initializes the view.
     *
     * @param root loads all the nodes that descend from root.
     */
    public void initStage(Parent root) {
        //logger.info("Initializing Sign up stage.");

        //Creates a new scene.
        Scene scene = new Scene(root);
        //Sets the scene.
        stage.setScene(scene);
        stage.setTitle("Sign up");
        stage.setResizable(false);
        idButtonSignUp.setDisable(true);

        idButtonBack.setOnAction(this::backToLoginButton);
        idButtonSignUp.setOnAction(this::signUpButtonPressed);

        disableButtonWhenTextFieldsEmpty();

        idTextName.textProperty().addListener(this::limitNameTextField);
        idTextEmail.textProperty().addListener(this::limitEmailTextField);
        idTextUser.textProperty().addListener(this::limitUserTextField);
        idTextPassword.textProperty().addListener(this::limitPasswordTextField);
        idTextRepeatPassword.textProperty().addListener(this::limitRepeatPasswordTextField);

        stage.show();
    }

    /**
     * Closes this window and opens the Sign In window.
     *
     * @param event determines which event has happened.
     */
    private void backToLoginButton(ActionEvent event) {
        try {
            // Loads the fxml archive
            FXMLLoader loader = new FXMLLoader(getClass().getResource("UISignIn.fxml"));
            Parent root = (Parent) loader.load();
            // Links the controller to the fxml
            UISignInController controller = ((UISignInController) loader.getController());
            //Sets the stage
            controller.setStage(stage);
            //Initializes the stage
            controller.initStage(root);
        } catch (IOException ex) {
            Logger.getLogger(UILogOutController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Executes action when Sign Up button pressed.
     *
     * @param event determines which event has happened.
     */
    private void signUpButtonPressed(ActionEvent event) {
        boolean errorEmail = false;
        boolean errorPassEqual = false;
        boolean errorPassPattern = false;

        errorEmail = checkEmailPatternCorrect();
        errorPassEqual = checkPasswordsEqual();
        errorPassPattern = checkPasswordPatternCorrect();

        if (!errorEmail && !errorPassEqual && !errorPassPattern) {
            openLogOutWindow();
        }
    }

    /**
     * Closes this window and opens the Sign In window.
     */
    private void openLogOutWindow() {
        try {
            // Loads the fxml archive
            FXMLLoader loader = new FXMLLoader(getClass().getResource("UILogOut.fxml"));
            Parent root = (Parent) loader.load();
            // Links the controller to the fxml
            UILogOutController controller = ((UILogOutController) loader.getController());
            //Sets the stage
            controller.setStage(stage);
            //Initializes the stage
            controller.initStage(root, idTextUser.getText());
        } catch (IOException ex) {
            Logger.getLogger(UISignInController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Disables Sign Up button if there's at least one Text Field empty.
     *
     * @param observable observes the changes that happen in the Text Field.
     * @param oldValue the value that was in the Text Field before changes
     * happened.
     * @param newValue the value that is in the Text Field after changes
     * happenes.
     */
    private void disableButtonWhenTextFieldsEmpty() {
        idButtonSignUp.disableProperty().bind(
                idTextName.textProperty().isEmpty()
                        .or(idTextEmail.textProperty().isEmpty())
                        .or(idTextUser.textProperty().isEmpty())
                        .or(idTextPassword.textProperty().isEmpty())
                        .or(idTextRepeatPassword.textProperty().isEmpty())
        );
    }

    /**
     * Limits the max number of characters of the "Name" Text Field.
     *
     * @param observable observes the changes that happen in the Text Field.
     * @param oldValue the value that was in the Text Field before changes
     * happened.
     * @param newValue the value that is in the Text Field after changes
     * happenes.
     */
    private void limitNameTextField(ObservableValue observable, String oldValue, String newValue) {
        //If the text lenght is bigger than 50
        if (idTextName.getText().length() > MAX_LENGHT) {
            //Saves in a String the characters from 1 to 50 that are written in the Text Field
            String name = idTextName.getText().substring(0, MAX_LENGHT);
            //Substitutes the text with the String
            idTextName.setText(name);

            idLabelNameError.setText("Name must be less than 50 characters");
            idLabelNameError.setTextFill(Color.web("#FF0000"));
        } else {
            idLabelNameError.setText("");
        }
    }

    /**
     * Limits the max number of characters of the "Email" Text Field.
     *
     * @param observable observes the changes that happen in the Text Field.
     * @param oldValue the value that was in the Text Field before changes
     * happened.
     * @param newValue the value that is in the Text Field after changes
     * happenes.
     */
    private void limitEmailTextField(ObservableValue observable, String oldValue, String newValue) {
        if (idTextEmail.getText().length() > MAX_LENGHT) {
            String email = idTextEmail.getText().substring(0, MAX_LENGHT);
            idTextEmail.setText(email);

            idLabelEmailError.setText("Email must be less than 50 characters");
            idLabelEmailError.setTextFill(Color.web("#FF0000"));
        } else {
            idLabelEmailError.setText("");

            checkEmailPatternCorrect();
        }
    }

    /**
     * Limits the max number of characters of the "User" Text Field.
     *
     * @param observable observes the changes that happen in the Text Field.
     * @param oldValue the value that was in the Text Field before changes
     * happened.
     * @param newValue the value that is in the Text Field after changes
     * happenes.
     */
    private void limitUserTextField(ObservableValue observable, String oldValue, String newValue) {
        if (idTextUser.getText().length() > MAX_LENGHT) {
            String user = idTextUser.getText().substring(0, MAX_LENGHT);
            idTextUser.setText(user);

            idLabelUserError.setText("User must be less than 50 characters");
            idLabelUserError.setTextFill(Color.web("#FF0000"));
        } else {
            idLabelUserError.setText("");
        }
    }

    /**
     * Limits the max number of characters of the "Password" Text Field.
     *
     * @param observable observes the changes that happen in the Text Field.
     * @param oldValue the value that was in the Text Field before changes
     * happened.
     * @param newValue the value that is in the Text Field after changes
     * happenes.
     */
    private void limitPasswordTextField(ObservableValue observable, String oldValue, String newValue) {
        if (idTextPassword.getText().length() > MAX_LENGHT) {
            String pass = idTextPassword.getText().substring(0, MAX_LENGHT);
            idTextPassword.setText(pass);

            idLabelPasswordError.setText("Password must be less than 50 characters");
            idLabelPasswordError.setTextFill(Color.web("#FF0000"));
        } else {
            idLabelPasswordError.setText("");
        }
    }

    /**
     * Limits the max number of characters of the "Repeat Password" Text Field.
     *
     * @param observable observes the changes that happen in the Text Field.
     * @param oldValue the value that was in the Text Field before changes
     * happened.
     * @param newValue the value that is in the Text Field after changes
     * happenes.
     */
    private void limitRepeatPasswordTextField(ObservableValue observable, String oldValue, String newValue) {
        if (idTextRepeatPassword.getText().length() > MAX_LENGHT) {
            String repPass = idTextRepeatPassword.getText().substring(0, MAX_LENGHT);
            idTextRepeatPassword.setText(repPass);
        }
    }

    /**
     * Checks if the Email Pattern is correct.
     *
     * @return "error" boolean if the email is not correct.
     */
    private boolean checkEmailPatternCorrect() {
        boolean error = false;
        //Compares the text from the Text Field with the Pattern
        Matcher matcher = VALIDEMAIL.matcher(idTextEmail.getText());
        //If the text and the Pattern don't match
        if (!matcher.find()) {
            idLabelEmailError.setText("Invalid email address");
            idLabelEmailError.setTextFill(Color.web("#FF0000"));

            error = true;
        }

        return error;
    }

     /**
     * Checks if the Password Pattern is correct (If there's only alphanumeric
     * text).
     *
     * @return "error" boolean if the two passwords don't match.
     */
    private boolean checkPasswordPatternCorrect() {
        boolean error = false;
        //Compares the text from the Text Field with the Pattern
        Matcher matcher = VALIDPASS.matcher(idTextPassword.getText());
        //If the text and the Pattern don't match
        if (!matcher.find()) {
            idLabelError.setText("Password must only contain letters and numbers");
            idLabelError.setTextFill(Color.web("#FF0000"));

            error = true;
        }

        return error;
    }
    
    /**
     * Checks if the two passwords are equal.
     *
     * @return "error" boolean if the two passwords don't match.
     */
    private boolean checkPasswordsEqual() {
        boolean error = false;

        if (!idTextPassword.getText().equals(idTextRepeatPassword.getText())) {
            idLabelError.setText("Passwords don't match");
            idLabelError.setTextFill(Color.web("#FF0000"));

            error = true;
        }

        return error;
    }

}
