package sprint4;

import Pages.MainPage;
import org.junit.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.time.Duration;
import java.util.List;
import static java.time.temporal.ChronoUnit.SECONDS;

    @RunWith(Parameterized.class)
public class TestQuestionSection {
        @Before
        public void setup() {
            webDriver = new ChromeDriver();
            webDriver.manage().timeouts().implicitlyWait(Duration.of(3, SECONDS));
        }
        private WebDriver webDriver;
        @Parameterized.Parameter
        public int index;
        @Parameterized.Parameter(1)
        public String checkElement;

        @Parameterized.Parameters
        public static Object[][] data(){
            return new Object[][]{
                    {0, "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                    {1, "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                    {2, "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                    {3, "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                    {4, "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                    {5, "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                    {6, "Можно ли отменить заказ?"},
                    {7, "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},

            };
        }

        @Test
        public void checkQuestionSection() {
            MainPage mainPage = new MainPage(webDriver);

            mainPage.open();
            webDriver.findElement(mainPage.getCookieYes()).click();
            mainPage.scroll(mainPage.getHowMuchQuestion());
            List <WebElement> questions = webDriver.findElements(By.xpath(".//div[@class = 'accordion__button']"));
            List <WebElement> answers = webDriver.findElements(By.xpath(".//div[@class = 'accordion__panel']/p"));
            questions.get(index).click();
            String expectedText = answers.get(index).getText();
            Assert.assertEquals("Ответ не соответствует вопросу", expectedText, checkElement);
        }
        @After
        public void tearDown() {
            webDriver.quit();
        }

    }