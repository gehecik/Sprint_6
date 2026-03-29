package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.example.EnvConfig.*;

public class StatusPage {
    protected final By orderContent = By.className(CLASS_ORDER_CONTENT);
    protected final By orderName = By.cssSelector("[placeholder='* Имя']");
    protected final By orderSurname = By.cssSelector("[placeholder='* Фамилия']");
    protected final By orderAddress = By.cssSelector("[placeholder='* Адрес: куда привезти заказ']");
    protected final By orderSubway = By.className("select-search__value");
    protected final By subwayValue = By.className("select-search__options");
    //data-index="0"
    protected final By orderPhone = By.cssSelector("[placeholder='* Телефон: на него позвонит курьер']");
    //+7812123456

    protected final By nextButton = By.className("Button_Middle__1CSJM");


    private final WebDriver driver;

    public StatusPage(WebDriver driver) {
        this.driver = driver;
    }

    public void checkOrderContent() {
        WebElement element = driver.findElement(orderContent);
        new WebDriverWait(driver, EXPLICIT_TIMEOUT)
                .until(ExpectedConditions.visibilityOf(element))
                .click();
    }

    public void enterNewNameValue(String newValue) {
        if (driver.findElement(orderName).isEnabled()) {
            driver.findElement(orderName).clear();
            driver.findElement(orderName).sendKeys(newValue);
        }
    }

    public void enterNewSurnameValue(String newValue) {
        if (driver.findElement(orderSurname).isEnabled()) {
            driver.findElement(orderSurname).clear();
            driver.findElement(orderSurname).sendKeys(newValue);
        }
    }

    public void enterNewAddressValue(String newValue) {
        if (driver.findElement(orderAddress).isEnabled()) {
            driver.findElement(orderAddress).clear();
            driver.findElement(orderAddress).sendKeys(newValue);
        }
    }

    public void enterNewPhoneValue(String newValue) {
        if (driver.findElement(orderPhone).isEnabled()) {
            driver.findElement(orderPhone).clear();
            driver.findElement(orderPhone).sendKeys(newValue);
        }
    }
}
