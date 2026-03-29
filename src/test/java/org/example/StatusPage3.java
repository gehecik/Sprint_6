package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.example.EnvConfig.*;

public class StatusPage3 extends BasePage{
    protected final By orderStatusContent = By.className(CLASS_RESPONSIBLE);

    public StatusPage3(WebDriver driver) {
        super(driver);
    }

    public void checkStatusContent() {
        checkLocator(orderStatusContent);
    }
}
