package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
public class MainPage {
    private WebDriver webDriver;
    //Адрес сайта
    private final String URL = "https://qa-scooter.praktikum-services.ru/";
    private final By cookieYes = By.xpath(".//button[text()='да все привыкли']");
    // верхняя кнопка "Заказать"
    private final By topOrderButton = By.className("Button_Button__ra12g");
    // нижняя кнопка "Заказать"
    private final By lowOrderButton = By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM");
    //Вопрос Сколько это стоит? И как оплатить?
    private final By howMuchQuestion = By.id("accordion__heading-0");
    //Ответ Сколько это стоит? И как оплатить?
    private final By howMuchAnswer = By.xpath(".//p[contains(text() , 'Сутки — 400 рублей')]");


    public MainPage(WebDriver webDriver){this.webDriver = webDriver;}
    public void open(){webDriver.get(URL);}
    public void scroll(By scroll){
        ((JavascriptExecutor)webDriver).executeScript("arguments[0].scrollIntoView();", webDriver.findElement(scroll));
    }
    public void click(By element){webDriver.findElement(element).click();}
    public By getCookieYes(){return cookieYes;}
    public By getHowMuchQuestion(){return howMuchQuestion;}
    public By getHowMuchAnswer(){return howMuchAnswer;}
    public By getTopOrderButton(){
        return topOrderButton;
    }
    public By getLowOrderButton(){return lowOrderButton;}

}
