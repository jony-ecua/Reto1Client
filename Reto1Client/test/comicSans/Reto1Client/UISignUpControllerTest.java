/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comicSans.Reto1Client;

import java.io.IOException;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.Test;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.testfx.api.FxAssert;
import static org.testfx.api.FxAssert.verifyThat;
import org.testfx.api.FxToolkit;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit.ApplicationTest;
import static org.testfx.matcher.base.NodeMatchers.isDisabled;
import static org.testfx.matcher.base.NodeMatchers.isEnabled;
import static org.testfx.matcher.base.NodeMatchers.isFocused;
import static org.testfx.matcher.base.NodeMatchers.isVisible;
import org.testfx.matcher.base.WindowMatchers;
import org.testfx.matcher.control.LabeledMatchers;
import static org.testfx.matcher.control.TextInputControlMatchers.hasText;

/**
 * Testing class for Sign Up view and controller.
 *
 * @author Nerea Aranguren and Cristina Milea
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UISignUpControllerTest extends ApplicationTest {

    @Override
    public void start(Stage stage) throws Exception {
        new Client().start(stage);
        clickOn("#idButtonSignUp");
    }

    @BeforeClass
    public static void setUpClass() throws TimeoutException {
        FxToolkit.registerPrimaryStage();
        FxToolkit.setupApplication(Client.class);
    }

    @Test
    public void test01_InitialState() {
        verifyThat("#idTextName", hasText(""));
        verifyThat("#idTextEmail", hasText(""));
        verifyThat("#idTextUser", hasText(""));
        verifyThat("#idTextPassword", hasText(""));
        verifyThat("#idTextRepeatPassword", hasText(""));
        verifyThat("#idTextName", isFocused());

        verifyThat("#idButtonSignUp", isDisabled());
        verifyThat("#idButtonBack", isEnabled());
    }

    @Test
    public void test02_SignUpIsEnabled() {
        clickOn("#idTextName");
        write("fullname");
        clickOn("#idTextEmail");
        write("email");
        clickOn("#idTextUser");
        write("username");
        clickOn("#idTextPassword");
        write("password");
        clickOn("#idTextRepeatPassword");
        write("repeat password");
        clickOn("#idTextName");
        verifyThat("#idButtonSignUp", isEnabled());
    }

    @Test
    public void test03_SignUpIsDisabled() {
        clickOn("#idTextName");
        eraseText(8);
    }

    @Test
    public void test04_Name50Characters() {
        clickOn("#idTextName");
        for (int i = 0; i < 52; i++) {
            write("a");
        }
        verifyThat("#idLabelNameError", LabeledMatchers.hasText("Name must be less than 50 characters"));
        doubleClickOn("#idTextName");
        eraseText(1);
    }
    
    @Test
    public void test05_Email50Characters() {
        clickOn("#idTextEmail");
        for (int i = 0; i < 52; i++) {
            write("a");
        }
        verifyThat("#idLabelEmailError", LabeledMatchers.hasText("Email must be less than 50 characters"));
        doubleClickOn("#idTextEmail");
        eraseText(1);
    }
   
    @Test
    public void test06_User50Characters() {
        clickOn("#idTextUser");
        for (int i = 0; i < 52; i++) {
            write("a");
        }
        verifyThat("#idLabelUserError", LabeledMatchers.hasText("User must be less than 50 characters"));
        doubleClickOn("#idTextUser");
        eraseText(1);
    }
    
    @Test
    public void test07_Password50Characters() {
        clickOn("#idTextPassword");
        for (int i = 0; i < 52; i++) {
            write("a");
        }
        verifyThat("#idLabelPasswordError", LabeledMatchers.hasText("Password must be less than 50 characters"));
        doubleClickOn("#idTextPassword");
        eraseText(1);
    }

    @Test
    public void test08_emailFormat() {
        clickOn("#idTextEmail");
        write("email");
        verifyThat("#idLabelEmailError", LabeledMatchers.hasText("Invalid email address"));
        write("@gmail");
        verifyThat("#idLabelEmailError", LabeledMatchers.hasText("Invalid email address"));
        write(".com");
        verifyThat("#idLabelEmailError", LabeledMatchers.hasText(""));
        doubleClickOn("#idTextEmail");
        eraseText(1);
    }

    @Test
    public void test09_passwordsMatch() {
        clickOn("#idTextName");
        write("a");
        clickOn("#idTextEmail");
        write("email");
        clickOn("#idTextUser");
        write("a");
        clickOn("#idTextPassword");
        write("password");
        clickOn("#idTextRepeatPassword");
        write("repeat password");
        clickOn("#idButtonSignUp");
        verifyThat("#idLabelError", LabeledMatchers.hasText("Passwords don't match"));

        clickOn("#idTextRepeatPassword");
        eraseText(15);
        write("password");
        clickOn("#idButtonSignUp");
        verifyThat("#idLabelError", LabeledMatchers.hasText("Passwords don't match"));
        borrar();
    }

    @Test
    public void test10_openSignInWindow() {
        clickOn("#idButtonBack");
        verifyThat("#idPaneSignIn", isVisible());
    }

    public void borrar() {
        doubleClickOn("#idTextName");
        eraseText(1);
        doubleClickOn("#idTextEmail");
        eraseText(1);
        doubleClickOn("#idTextUser");
        eraseText(1);
        doubleClickOn("#idTextPassword");
        eraseText(1);
        doubleClickOn("#idTextRepeatPassword");
        eraseText(1);
    }
}
