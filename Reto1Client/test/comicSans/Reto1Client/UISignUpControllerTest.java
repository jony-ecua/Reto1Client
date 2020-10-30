/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comicSans.Reto1Client;

import java.util.concurrent.TimeoutException;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextInputControl;
import javafx.stage.Stage;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import static org.testfx.api.FxAssert.verifyThat;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit.ApplicationTest;
import static org.testfx.matcher.base.NodeMatchers.isDisabled;
import static org.testfx.matcher.base.NodeMatchers.isEnabled;
import static org.testfx.matcher.base.NodeMatchers.isVisible;
import static org.testfx.matcher.control.TextInputControlMatchers.hasText;

/**
 * Testing class for Sign Up view and controller.
 * 
 * @author Nerea Aranguren
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UISignUpControllerTest extends ApplicationTest{
  
     @BeforeClass
    public static void setUpClass() throws TimeoutException {
        FxToolkit.registerPrimaryStage();
        FxToolkit.setupApplication(Client.class);
   }


    @Test
    public void test1_InitialState() {
        verifyThat("#idTextName", hasText(""));
        verifyThat("#idTextEmail", hasText(""));
        verifyThat("#idTextUser", hasText(""));
        verifyThat("#idTextPassword",hasText(""));
        verifyThat("#idTextRepeatPassword",hasText(""));
        
        verifyThat("#idButtonSignUp", isDisabled());
        verifyThat("#idButtonBack", isEnabled());
        
        verifyThat("#idLabelNameError", isNotVisible());
    }
    
    @Test
    public void test2_SignUpIsEnabled() {
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
        verifyThat("#idButtonSignUp", isEnabled());
    }
    
    @Test
    public void test3_SignUpIsDisabled() {
        clickOn("#idTextName");
        write("fullname");
        verifyThat("#idButtonSignUp", isDisabled());
        eraseText(8);
        
        clickOn("#idTextEmail");
        write("email");
        verifyThat("#idButtonSignUp", isDisabled());
        eraseText(8);
        
        clickOn("#idTextUser");
        write("username");
        verifyThat("#idButtonSignUp", isDisabled());
        eraseText(8);
        
        clickOn("#idTextPassword");
        write("password");
        verifyThat("#idButtonSignUp", isDisabled());
        eraseText(8);
        
        clickOn("#idTextRepeatPassword");
        write("password");
        eraseText(8);
        verifyThat("#idButtonSignUp", isDisabled());
    }
    
    @Test
    public void test4_Name50Characters() {
        clickOn("#idTextName");
        for (int i=0; i<50; i++)
            write("a");
        verifyThat("#idLabelNameError", isVisible());
    }
}
