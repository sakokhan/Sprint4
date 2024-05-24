package sprint4;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import static java.time.temporal.ChronoUnit.SECONDS;
import org.junit.rules.ExternalResource;

public class CommonAction extends ExternalResource{
    private WebDriver webDriver;

    protected void before() {
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.of(3, SECONDS));
    }

    protected void after() {
        webDriver.quit();
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }


}
