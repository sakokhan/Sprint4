package sprint4;

import org.junit.*;
import pages.MainPage;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class Questions extends CommonActions {

    @Parameterized.Parameter
    public int index;
    @Parameterized.Parameter(1)
    public String answer;
    @Parameterized.Parameter(2)
    public int index1;
    @Parameterized.Parameters
    public static Object[][] data(){
        return new Object[][]{
                {0, "Сутки — 400 рублей. Оплата курьеру — наличными или картой.", 0},
                {1, "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.", 1},
                {2, "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.", 2},
                {3, "Только начиная с завтрашнего дня. Но скоро станем расторопнее.",3},
                {4, "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.", 4},
                {5, "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.", 5},
                {6, "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.", 6},
                {7, "Да, обязательно. Всем самокатов! И Москве, и Московской области.", 7},
        };
    }

    @Rule
    public CommonActions commonAction = new CommonActions();
    @Test
    public void testQuestionSection(){
        MainPage mainPage = new MainPage(commonAction.getWebDriver());
        mainPage.open();
        mainPage.scroll(mainPage.getHowMuchQuestion());
        mainPage.getListOfQuestions();
        mainPage.clickQuestion(index);
        String expected = answer;
        String actual = mainPage.checkAnswerVisible(index1);
        Assert.assertEquals("Текст ответа не совпадает", expected, actual);

    }

}