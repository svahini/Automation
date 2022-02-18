import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LoginTest {

    private static ChromeOptions getOptions()
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\rreyqh\\Desktop\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--lang=en-US", "--disable-gpu", "--window-size=1920,1200", "--ignore-certificate-errors", "--disable-extensions", "--no-sandbox", "--disable-dev-shm-usage");
        return options;
    }

    public static void getTitle()
    {
        WebDriver webDriver=new ChromeDriver(getOptions());
        webDriver.get("https://www.takealot.com");
        System.out.println(webDriver.getTitle());
    }

    public static void main(String[] args) {
        getTitle();
    }
}
