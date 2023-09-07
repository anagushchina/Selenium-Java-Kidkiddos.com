package Pages;

public class ContactUsPage extends BasePage{

    public static final String CONTACT_US_HEADER = "//h1[text()='Contact us']";

    public boolean isContactUsHeaderExists(){
        return isElementExists(CONTACT_US_HEADER);
    }

}
