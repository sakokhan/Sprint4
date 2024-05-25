package sprint4;

import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import static java.time.temporal.ChronoUnit.SECONDS;
import org.junit.rules.ExternalResource;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class CommonActions extends ExternalResource{
    private WebDriver webDriver;
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
        //WebDriverManager.firefoxdriver().setup();
    }
    protected void before() {
        webDriver = new ChromeDriver();
        //webDriver = new FirefoxDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.of(3, SECONDS));
    }

    protected void after() {
        webDriver.quit();
    }


    public WebDriver getWebDriver() {
        return webDriver;
    }
}
