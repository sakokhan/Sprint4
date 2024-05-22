package sprint4;

import pages.MainPage;
import pages.OrderPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import static java.time.temporal.ChronoUnit.SECONDS;

@RunWith(Parameterized.class)
public class OrderRegistration {
    private WebDriver webDriver;

    @Parameterized.Parameter
    public String nameField;
    @Parameterized.Parameter(1)
    public String surnameField;
    @Parameterized.Parameter(2)
    public String placeField;
    @Parameterized.Parameter(3)
    public String phoneField;

    @Parameterized.Parameters
    public static Object[][] data(){
        return new Object[][]{
                {"Сицилия", "Ли", "Москва", "+79109876543"},
                {"Патагония", "Фи", "Млсква", "+78964563456"},
        };
    }

    @Before
    public void setup() {
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.of(3, SECONDS));
    }

    @Test
    public void orderTopButton(){
        MainPage mainPage = new MainPage(webDriver);
        OrderPage orderPage = new OrderPage(webDriver);
        mainPage.open();
        mainPage.cookieYes();
        mainPage.clickTopOrderButton();
        orderPage.fillOrderForm(nameField, surnameField, placeField, phoneField);
        Assert.assertTrue("Сообщение заказ оформлен не появилось", orderPage.checkMessageExist());

    }

    @Test
    public void orderLowButton(){
        MainPage mainPage = new MainPage(webDriver);
        OrderPage orderPage = new OrderPage(webDriver);
        mainPage.open();
        mainPage.cookieYes();
        mainPage.clickLowOrderButton();
        orderPage.fillOrderForm(nameField, surnameField, placeField, phoneField);
        Assert.assertTrue("Сообщение заказ оформлен не появилось", orderPage.checkMessageExist());
    }
    @After
    public void tearDown(){
        webDriver.quit();
    }
}
