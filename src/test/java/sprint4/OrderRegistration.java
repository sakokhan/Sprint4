package sprint4;

import org.junit.*;
import pages.MainPage;
import pages.OrderPage;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class OrderRegistration{

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

    @Rule
    public CommonAction commonAction = new CommonAction();
    @Test
    public void orderTopButton(){
        MainPage mainPage = new MainPage(commonAction.getWebDriver());
        OrderPage orderPage = new OrderPage(commonAction.getWebDriver());
        mainPage.open();
        mainPage.cookieYes();
        mainPage.clickTopOrderButton();
        orderPage.fillOrderForm(nameField, surnameField, placeField, phoneField);
        String expected = "Заказ оформлен";
        String actual = orderPage.textOfMessage();
        Assert.assertEquals("Текст сообщения не соответствует ТЗ", expected, actual);
    }

    @Test
    public void orderLowButton(){
        MainPage mainPage = new MainPage(commonAction.getWebDriver());
        OrderPage orderPage = new OrderPage(commonAction.getWebDriver());
        mainPage.open();
        mainPage.cookieYes();
        mainPage.clickLowOrderButton();
        orderPage.fillOrderForm(nameField, surnameField, placeField, phoneField);
        String expected = "Заказ оформлен";
        String actual = orderPage.textOfMessage();
        Assert.assertEquals("Текст сообщения не соответствует ТЗ", expected, actual);
    }
}
