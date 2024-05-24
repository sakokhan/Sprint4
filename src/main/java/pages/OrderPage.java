package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPage {
    private WebDriver webDriver;
    //Поле имя
    private final By nameField = By.xpath(".//input[@placeholder='* Имя']");
    //Поле фамилия
    private final By surnameField = By.xpath(".//input[@placeholder='* Фамилия']");
    //Поле адрес
    private final By placeField = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    //Моле метро
    private final By metroField = By.xpath(".//input[@placeholder ='* Станция метро']");
    //Дропдаун станция метро
    private final By chooseMetroField = By.xpath(".//button[@value='1']//div[text()='Бульвар Рокоссовского']");
    //Поле телефон
    private final By phoneField = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    //Кнопка далее
    private final By nextButton = By.xpath(".//div[@class='Order_NextButton__1_rCA']//button[text()='Далее']");
    //Дата доставки самоката
    private final By dateField = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    //Дата в календаре
    private final By currentDate = By.xpath(".//div[@aria-label='Choose четверг, 30-е мая 2024 г.']");
    //Срок аренды
    private final By rentTerm = By.xpath(".//div[@class='Dropdown-placeholder']");
    //Дропдаун срок аренды
    private final By term = By.xpath(".//div[@class='Dropdown-menu']/div[text()='сутки']");
    //Чекбокс цвет самоката черный
    private final By color = By.xpath(".//input[@type='checkbox']");
    //Кнопка Заказать
    private final By orderButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']//button[text()='Заказать']");
    //Кнопка подтверждения заказа
    private final By yesButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']//button[text()='Да']");
    //Окно заказ оформлен
    private final By orderDode =By.xpath(".//div[@class='Order_ModalHeader__3FDaJ']");
    public OrderPage(WebDriver webDriver){this.webDriver = webDriver;}

    public void fillOrderForm(String name, String surname, String place, String phone){
        webDriver.findElement(nameField).sendKeys(name);
        webDriver.findElement(surnameField).sendKeys(surname);
        webDriver.findElement(placeField).sendKeys(place);
        webDriver.findElement(phoneField).sendKeys(phone);
        webDriver.findElement(metroField).click();
        webDriver.findElement(chooseMetroField).click();
        webDriver.findElement(nextButton).click();
        webDriver.findElement(dateField).click();
        webDriver.findElement(currentDate).click();
        webDriver.findElement(rentTerm).click();
        webDriver.findElement(term).click();
        webDriver.findElement(color).click();
        webDriver.findElement(orderButton).click();
        webDriver.findElement(yesButton).click();
    }
    public String textOfMessage(){
        return webDriver.findElement(orderDode).getText();
    }

}
