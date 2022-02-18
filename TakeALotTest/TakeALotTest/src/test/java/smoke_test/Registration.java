package smoke_test;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.w3c.dom.Document;
import page_objects.RegisterUser;
import utility.Common;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.util.List;

public class Registration{

    private static Common common=new Common();
    private static RegisterUser registerUser=new RegisterUser();

    private static final String brand="data";

    private static String firstName;
    private static String lastName;
    private static String emailId;
    private static String reTypeEmailId;
    private static String password;
    private static String reTypePassword;
    private static String mobileNumber;
    private static String pageTitle;
    private static String searchKeyword;
    private static String product1;
    private static String product2;

    @BeforeClass
    public static void loadDataFromProperties()
    {
        firstName=common.getTestData(brand,"firstName");
        lastName=common.getTestData(brand,"lastName");
        emailId=common.getTestData(brand,"emailId");
        reTypeEmailId=common.getTestData(brand,"reTypeEmailId");
        password=common.getTestData(brand,"password");
        reTypePassword=common.getTestData(brand,"reTypePassword");
        mobileNumber=common.getTestData(brand,"mobileNumber");
        pageTitle=common.getTestData(brand,"pageTitle");
        searchKeyword=common.getTestData(brand,"searchKeyword");
        product1=common.getTestData(brand,"product1");
        product2=common.getTestData(brand,"product2");
    }

    private static ChromeOptions getOptions()
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\rreyqh\\Desktop\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--lang=en-US", "--disable-gpu", "--window-size=1920,1200", "--ignore-certificate-errors", "--disable-extensions", "--no-sandbox", "--disable-dev-shm-usage");
        return options;
    }

    @Test
    public void firstTest()
    {
        System.out.println(firstName);
        System.out.println(lastName);
        System.out.println(emailId);
        System.out.println(reTypeEmailId);
        System.out.println(password);
        System.out.println(reTypePassword);
        System.out.println(mobileNumber);
        System.out.println(pageTitle);
        System.out.println(searchKeyword);
    }

    @Test
    public void registerUser()
    {

        WebDriver webDriver=new ChromeDriver(getOptions());
        webDriver.get(registerUser.getWebsiteRegistrationUrl());

        String getPageTitle=webDriver.getTitle();
        if(getPageTitle.equalsIgnoreCase(pageTitle))
        {
            System.out.println("Registration URL is correct....!!");
        }

        webDriver.manage().window().maximize();
        webDriver.findElement(registerUser.getFirstName()).sendKeys(firstName);
        webDriver.findElement(registerUser.getLastName()).sendKeys(lastName);
        webDriver.findElement(registerUser.getEmailId()).sendKeys(emailId);
        webDriver.findElement(registerUser.getReTypeEmailId()).sendKeys(reTypeEmailId);
        webDriver.findElement(registerUser.getPassword()).sendKeys(password);
        webDriver.findElement(registerUser.getReTypePassword()).sendKeys(reTypePassword);
        webDriver.findElement(registerUser.getMobileNumber()).sendKeys(mobileNumber);
        webDriver.findElement(registerUser.getRegisterNowButton()).click();
        webDriver.findElement(registerUser.getWelcomeBox()).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        webDriver.findElement(registerUser.getSearchBox()).sendKeys(searchKeyword);
        webDriver.findElement(registerUser.getSearchBox()).sendKeys(Keys.RETURN);

        By webElement=By.xpath("//body/div[@id='shopfront-app']/div[3]/div[1]/div[2]/div[2]/div[1]");

        List<WebElement> ls=webDriver.findElements(webElement);
        for (WebElement web:
             ls) {
            System.out.println(web.getText());
        }

        System.out.println(webDriver.getTitle());
    }

    @Test
    public void findWatch() throws InterruptedException, ParserConfigurationException {
        WebDriver webDriver=new ChromeDriver(getOptions());
        webDriver.get("https://www.takealot.com/");
        Thread.sleep(3000);
        webDriver.findElement(registerUser.getSearchBox()).sendKeys(searchKeyword);
        webDriver.findElement(registerUser.getSearchBox()).sendKeys(Keys.RETURN);
        Thread.sleep(8000);

        webDriver.findElement(By.xpath("//a[contains(@href,'/michael-kors-parker-silver-tone-watch-mk5353/PLID55963188')]")).click();
        Thread.sleep(10000);
        webDriver.findElement(By.cssSelector("div.buybox-actions.buybox-actions > div > div > button")).click();
//        List<WebElement> elements = webDriver.findElements(By.cssSelector("div.listings-container.listings-container-module_listings-container_AC4LI > div > div"));
//        for (WebElement e : elements) {
//            System.out.println(e.getText());
//            //System.out.println(e);
//        }
//        System.out.println(elements.size());
//        System.out.println("----");
//        System.out.println(elements.get(3).getText());
    }

}
