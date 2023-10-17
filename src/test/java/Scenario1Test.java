import Pages.LoginPage;
import Pages.MainPage;
import Utils.UseCaseBase;
import static org.junit.jupiter.api.Assertions.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class Scenario1Test extends UseCaseBase {

    private static MainPage mainPage;
    private static final Logger logger = LogManager.getLogger(Scenario1Test.class);

    @BeforeAll
    public static void classSetUp(){
        mainPage = new MainPage();
    }

    @BeforeEach
    public void testSetUp(){
        mainPage.navigateToMainPage();
    }

    @ParameterizedTest
    @MethodSource("invalidValues")
    public void loginNegativeTest(String email, String password){
        logger.info("Running loginNegativeTest");
        assertTrue(mainPage.isLogoExists());
        LoginPage loginPage = mainPage.clickLogInButton();
        assertTrue(loginPage.isLoginHeaderExists());
        loginPage.typeIntoEmailInput(email);
        loginPage.typeIntoPasswordInput(password);
        loginPage.clickSignInButton();
        if(!loginPage.isReCaptchaExists()){
        assertTrue(loginPage.isErrorTextExists());
        }
    }

    static Stream<Arguments> invalidValues(){
        return Stream.of(
                Arguments.of("",""),
                Arguments.of("wrong@email.com", "correct_password"),
                Arguments.of("correct@email.com", "wrong_password"),
                Arguments.of("wrong@email.com", "wrong_password")
        );
    }
}
