package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.openqa.selenium.WebDriver;

public class ImportantQuestionsTest {
    @RegisterExtension
    private final DriverExtension extension = new DriverExtension();

    @Test
    public void openMainPage() throws Exception {
        WebDriver driver = extension.getDriver();

        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

}
