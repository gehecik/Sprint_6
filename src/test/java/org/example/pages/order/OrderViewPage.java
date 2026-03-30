package org.example.pages.order;

import org.example.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderViewPage extends BasePage {
    protected final By orderStatusContent = By.className("Input_Responsible__1jDKN");

    public OrderViewPage(WebDriver driver) {
        super(driver);
    }

    public void checkStatusContent() {
        checkLocator(orderStatusContent);
    }

}
