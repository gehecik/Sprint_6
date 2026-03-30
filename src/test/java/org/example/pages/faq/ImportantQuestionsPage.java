package org.example.pages.faq;

import org.example.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.stream.IntStream;

import static org.example.locators.EnvConfig.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ImportantQuestionsPage extends BasePage {
    protected final By cookieButton = By.className(CLASS_COOKIE_BUTTON);
    protected final By accordionItem = By.className("accordion__item");
    protected final By accordionHeading = By.className("accordion__button");
    protected final By accordionPanel = By.className("accordion__panel");

    public ImportantQuestionsPage(WebDriver driver) {
        super(driver);
    }

    public static class PairQuestionAnswer {
        public final String question;
        public final String answer;

        public PairQuestionAnswer(String question, String answer) {
            this.question = question;
            this.answer = answer;
        }
    }

    List<PairQuestionAnswer> expectedTexts = List.of(
            new PairQuestionAnswer("Сколько это стоит? И как оплатить?",
                    "Сутки — 400 рублей. Оплата курьеру — наличными или картой."),
            new PairQuestionAnswer("Хочу сразу несколько самокатов! Так можно?",
                    "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."),
            new PairQuestionAnswer("Как рассчитывается время аренды?",
                    "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."),
            new PairQuestionAnswer("Можно ли заказать самокат прямо на сегодня?",
                    "Только начиная с завтрашнего дня. Но скоро станем расторопнее."),
            new PairQuestionAnswer("Можно ли продлить заказ или вернуть самокат раньше?",
                    "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."),
            new PairQuestionAnswer("Вы привозите зарядку вместе с самокатом?",
                    "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."),
            new PairQuestionAnswer("Можно ли отменить заказ?",
                    "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."),
            new PairQuestionAnswer("Я жизу за МКАДом, привезёте?",
                    "Да, обязательно. Всем самокатов! И Москве, и Московской области.")
    );

    public void openPage() {
        driver.get(BASE_URL);
    }

    public void clickOnCookieButton() {
        checkClickAndClick(cookieButton);
    }

    public List<WebElement> getElements () {
        return driver.findElements(accordionItem);
    }

    public void checkQuestionAnswer() {
        List<WebElement> elements = getElements();
        IntStream.range(0, elements.size()).forEachOrdered(i -> {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", elements.get(i));

            WebElement question = elements.get(i).findElement(accordionHeading);
            WebElement answer = elements.get(i).findElement(accordionPanel);

            new WebDriverWait(driver, EXPLICIT_TIMEOUT)
                    .until(ExpectedConditions.elementToBeClickable(question)).click();

            new WebDriverWait(driver, EXPLICIT_TIMEOUT)
                    .until(ExpectedConditions.visibilityOf(answer));

            String actualQuestion = question.getText();
            String actualAnswer = answer.getText();

            PairQuestionAnswer expected = expectedTexts.get(i);

            assertEquals(expected.question, actualQuestion);
            assertEquals(expected.answer, actualAnswer);
        });
    }
}
