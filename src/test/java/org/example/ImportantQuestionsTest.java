package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ImportantQuestionsTest {
    private WebDriver driver;

    @BeforeEach
    public void startUp() {
        WebDriverManager.chromiumdriver().browserVersion("146").setup();
        //WebDriverManager.chromiumdriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void openMainPage() throws Exception {
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }



    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
