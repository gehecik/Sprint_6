package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ImportantQuestionsTest {
    @RegisterExtension
    private final DriverExtension extension = new DriverExtension();

    @Test
    public void openMainPage() throws Exception {
        WebDriver driver = extension.getDriver();

        driver.get("https://qa-scooter.praktikum-services.ru/");

        List<WebElement> elements = driver.findElements(By.className("accordion__button"));
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(By.className("App_CookieButton__3cvqF")))
                .click();

        for (WebElement element : elements) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);

            new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.elementToBeClickable(element)).click();
        }

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("accordion__button")));
    }

}
