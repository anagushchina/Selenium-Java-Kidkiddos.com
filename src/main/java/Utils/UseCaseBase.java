package Utils;

import Pages.BasePage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;

public class UseCaseBase {

    private static WebDriver webDriver;
    private static BasePage page;

    @BeforeAll
    public static void setUpMain(){
        webDriver = SharedDriver.getWebDriver(SharedDriver.Browsers.CHROME);
        page = new BasePage();
        page.setWebDriver(webDriver);
    }

    @AfterAll
    public static void tearDownMain(){
        SharedDriver.closeBrowser();
        webDriver=null;
    }
}
