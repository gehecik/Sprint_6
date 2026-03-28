package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ImportantQuestionsPage {
    private final WebDriver driver;

    public ImportantQuestionsPage(WebDriver driver) {
        this.driver = driver;
    }

    protected final By cookieButton = By.className("App_CookieButton__3cvqF");
    protected final By accordionItem = By.className("accordion__item");

    List<Map<String, String>> expectedTexts = List.of(
            Map.of("Сколько это стоит? И как оплатить?",
                    "Сутки — 400 рублей. Оплата курьеру — наличными или картой."),
            Map.of("Хочу сразу несколько самокатов! Так можно?",
                    "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."),
            Map.of("Как рассчитывается время аренды?",
                    "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."),
            Map.of("Можно ли заказать самокат прямо на сегодня?",
                    "Только начиная с завтрашнего дня. Но скоро станем расторопнее."),
            Map.of("Можно ли продлить заказ или вернуть самокат раньше?",
                    "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."),
            Map.of("Вы привозите зарядку вместе с самокатом?",
                    "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."),
            Map.of("Можно ли отменить заказ?",
                    "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."),
            Map.of("Я жизу за МКАДом, привезёте?",
                    "Да, обязательно. Всем самокатов! И Москве, и Московской области.")
    );

    public void openPage() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    public void clickOnCookieButton() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(cookieButton))
                .click();
    }

    public List<WebElement> getElements () {
        return driver.findElements(accordionItem);
    }

    public void checkQuestionAnswer() {
        List<WebElement> elements = getElements();
        IntStream.range(0, elements.size()).forEachOrdered(i -> {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", elements.get(i));
            new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.elementToBeClickable(elements.get(i))).click();

            By accordionHeading = By.className("accordion__button");
            By accordionPanel = By.className("accordion__panel");

            WebElement question = elements.get(i).findElement(accordionHeading);
            WebElement answer = elements.get(i).findElement(accordionPanel);

            new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.visibilityOf(answer));

            String actualQuestion = question.getText();
            String actualAnswer = answer.getText();

            String expectedQuestion = expectedTexts.get(i).keySet().iterator().next();
            String expectedAnswer = expectedTexts.get(i).get(expectedQuestion);

            assertEquals(expectedQuestion, actualQuestion);
            assertEquals(expectedAnswer, actualAnswer);
        });
    }
}
