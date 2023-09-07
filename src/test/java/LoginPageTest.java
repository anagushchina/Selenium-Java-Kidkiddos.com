import Pages.LoginPage;
import Utils.UseCaseBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;


public class LoginPageTest extends UseCaseBase {

    private static LoginPage logInPage;
    private static final Logger logger = LogManager.getLogger(LoginPage.class);

    @BeforeAll
    public static void classSetUp(){
        logInPage = new LoginPage();
    }

    @BeforeEach
    public void testSetUp(){
        logInPage.navigateToLoginPage();
    }

    @Test
    public void emptyInputsTest(){
        logger.info("Running emptyInputsTest");
        logInPage.clickSignInButton();
        assertTrue(logInPage.isErrorTextExists());
    }

    @ParameterizedTest
    @MethodSource("invalidValues")
    public void invalidInputsTest(String email, String password){
        logger.info("Running invalidInputsTest");
        logInPage.typeIntoEmailInput(email);
        logInPage.typeIntoPasswordInput(password);
        logInPage.clickSignInButton();
        if(logInPage.isReCaptchaExists()){
            logger.info("Verification challenge appeared");
        }
        else{
        assertTrue(logInPage.isErrorTextExists());
        }
    }

    static Stream<Arguments> invalidValues(){
        return Stream.of(
                Arguments.of("wrong@email.com", "correct_password"),
                Arguments.of("correct@email.com", "wrong_password"),
                Arguments.of("wrong@email.com", "wrong_password")
        );
    }



}
