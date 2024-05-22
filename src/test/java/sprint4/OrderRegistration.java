package sprint4;

import Pages.MainPage;
import Pages.OrderPage;
import org.junit.After;
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
    public String name;
    @Parameterized.Parameter(1)
    public String surname;
    @Parameterized.Parameter(2)
    public String place;
    @Parameterized.Parameter(3)
    public String phone;

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
    public void OrderTopButton(){
        MainPage mainPage = new MainPage(webDriver);
        OrderPage orderPage = new OrderPage();
        mainPage.open();
        webDriver.findElement(mainPage.getCookieYes()).click();
        webDriver.findElement(mainPage.getTopOrderButton()).click();
        webDriver.findElement(orderPage.getName()).sendKeys(name);
        webDriver.findElement(orderPage.getSurname()).sendKeys(surname);
        webDriver.findElement(orderPage.getPlace()).sendKeys(place);
        webDriver.findElement(orderPage.getPhone()).sendKeys(phone);
        webDriver.findElement(orderPage.getMetro()).click();
        webDriver.findElement(orderPage.getChooseMetro()).click();
        webDriver.findElement(orderPage.getNextButton()).click();
        webDriver.findElement(orderPage.getDateField()).click();
        webDriver.findElement(orderPage.getCurrentDate()).click();
        webDriver.findElement(orderPage.getRentTerm()).click();
        webDriver.findElement(orderPage.getTerm()).click();
        webDriver.findElement(orderPage.getColor()).click();
        webDriver.findElement(orderPage.getOrderButton()).click();
        webDriver.findElement(orderPage.getYesButton());
        if(webDriver.findElement(orderPage.getOrderDode()).isDisplayed()) {
            System.out.println("Заказ оформлен");
        }else {
            System.out.println("Заказ не оформлен");
        }

    }

    @Test
    public void OrderLowButton(){
        MainPage mainPage = new MainPage(webDriver);
        OrderPage orderPage = new OrderPage();
        mainPage.open();
        webDriver.findElement(mainPage.getCookieYes()).click();
        webDriver.findElement(mainPage.getLowOrderButton()).click();
        webDriver.findElement(orderPage.getName()).sendKeys(name);
        webDriver.findElement(orderPage.getSurname()).sendKeys(surname);
        webDriver.findElement(orderPage.getPlace()).sendKeys(place);
        webDriver.findElement(orderPage.getPhone()).sendKeys(phone);
        webDriver.findElement(orderPage.getMetro()).click();
        webDriver.findElement(orderPage.getChooseMetro()).click();
        webDriver.findElement(orderPage.getNextButton()).click();
        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//div[@class='Order_Buttons__1xGrp']//button[text()='Заказать']")));
        webDriver.findElement(orderPage.getDateField()).click();
        webDriver.findElement(orderPage.getCurrentDate()).click();
        webDriver.findElement(orderPage.getRentTerm()).click();
        webDriver.findElement(orderPage.getTerm()).click();
        webDriver.findElement(orderPage.getColor()).click();
        webDriver.findElement(orderPage.getOrderButton()).click();
        webDriver.findElement(orderPage.getYesButton());
        if(webDriver.findElement(orderPage.getOrderDode()).isDisplayed()) {
            System.out.println("Заказ оформлен");
        }else {
            System.out.println("Заказ не оформлен");
        }
    }
    @After
    public void tearDown(){
        webDriver.quit();
    }
}
