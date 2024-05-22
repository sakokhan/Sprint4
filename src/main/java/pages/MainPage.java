package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import java.util.List;

public class MainPage {
    private WebDriver webDriver;
    //Адрес сайта
    private final String url = "https://qa-scooter.praktikum-services.ru/";
    private final By cookieYes = By.xpath(".//button[text()='да все привыкли']");
    // верхняя кнопка "Заказать"
    private final By topOrderButton = By.className("Button_Button__ra12g");
    // нижняя кнопка "Заказать"
    private final By lowOrderButton = By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM");
    //Вопрос Сколько это стоит? И как оплатить?
    private final By howMuchQuestion = By.id("accordion__heading-0");


    public MainPage(WebDriver webDriver){this.webDriver = webDriver;}
    public void open(){webDriver.get(url);}
    public void scroll(By scroll){
        ((JavascriptExecutor)webDriver).executeScript("arguments[0].scrollIntoView();", webDriver.findElement(scroll));
    }
    public By getHowMuchQuestion(){return howMuchQuestion;}
    public void cookieYes(){
        webDriver.findElement(cookieYes).click();
    }
    public void clickTopOrderButton(){
        webDriver.findElement(topOrderButton).click();
    }
    public void clickLowOrderButton(){
        webDriver.findElement(lowOrderButton).click();
    }
    public List<WebElement> getListOfQuestions()  {
        return webDriver.findElements(By.xpath(".//div[@class = 'accordion__button']"));
    }
    public List<WebElement> getListOfAnswers()  {
        return webDriver.findElements(By.xpath(".//div[@class = 'accordion__panel']/p"));
    }
    public void clickQuestion(int ind){
        getListOfQuestions().get(ind).click();
    }
    public String checkAnswerVisible(int i) {
        return getListOfAnswers().get(i).getText();
    }


}
