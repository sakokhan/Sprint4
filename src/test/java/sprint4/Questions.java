package sprint4;

import Pages.MainPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import java.util.List;
import static java.time.temporal.ChronoUnit.SECONDS;

@RunWith(Parameterized.class)
public class Questions {
    private WebDriver webDriver;
    @Parameterized.Parameter
    public int index;
    @Parameterized.Parameters
    public static Object[][] indexes(){
        return new Object[][]{
                {0}, {1}, {2}, {4}, {5}, {6}, {7},
        };

    }

    @Before
    public void setup() {
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.of(3, SECONDS));
    }
    @Test
    public void testQuestionSection(){
        MainPage mainPage = new MainPage(webDriver);
        mainPage.open();
        mainPage.scroll(mainPage.getHowMuchQuestion());
        mainPage.click(mainPage.getHowMuchQuestion());
        List <WebElement> answers = webDriver.findElements(By.xpath(".//div[@class = 'accordion__panel']/p"));
        if((answers.get(index).isDisplayed())){
            System.out.println("Когда нажимаешь на стрелочку, открывается соответствующий текст");
        }else{
            System.out.println("Когда нажимаешь на стрелочку, соответствующий текст не открывается");
        }

    }
    @After
    public void tearDown(){webDriver.quit();
    }
}