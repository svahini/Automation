package page_objects;

import org.openqa.selenium.By;

public class RegisterUser {
    private final By firstName = By.xpath("//input[@id='firstname']");
    private final By lastName = By.xpath("//input[@id='surname']");
    private final By emailId = By.xpath("//input[@id='email']");
    private final By reTypeEmailId = By.xpath("//input[@id='email2']");
    private final By password = By.xpath("//input[@id='password']");
    private final By reTypePassword = By.xpath("//input[@id='password2']");
    private final By mobileNumber = By.xpath("//input[@id='telno1']");
    private final By registerNowButton = By.xpath("//input[@type='submit']");
    private final By searchBox = By.xpath("//input[@name='search']");
    private final By cartButton = By.xpath("//button[contains(@class,'mini-cart-button')]");

    private final By welcomeBox=By.xpath("//div[@id=\"welcome\"]//p[2]/a");

    //URLS
    private static final String WEBSITE_HOME_URL="https://www.takealot.com";
    private static final String WEBSITE_REGISTRATION_URL="https://secure.takealot.com/account/register";

    private static final String WEBSITE_REGISTRATION_TITLE="";

    public By getFirstName() {
        return firstName;
    }

    public By getLastName() {
        return lastName;
    }

    public By getEmailId() {
        return emailId;
    }

    public By getReTypeEmailId() {
        return reTypeEmailId;
    }

    public By getPassword() {
        return password;
    }

    public By getReTypePassword() {
        return reTypePassword;
    }

    public By getMobileNumber() {
        return mobileNumber;
    }

    public By getRegisterNowButton() {
        return registerNowButton;
    }

    public By getSearchBox() {
        return searchBox;
    }

    public By getCartButton() {
        return cartButton;
    }

    public String getWebsiteHomeUrl()
    {
        return WEBSITE_HOME_URL;
    }

    public String getWebsiteRegistrationUrl()
    {
        return WEBSITE_REGISTRATION_URL;
    }

    public By getWelcomeBox() {
        return welcomeBox;
    }
}
