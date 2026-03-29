package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.example.EnvConfig.*;

public class StatusPage2 {
    protected final By orderRentContent = By.xpath(XPATH_ORDER_RENT_CONTENT);
    protected final By orderDate = By.cssSelector("[placeholder='* Когда привезти самокат']");
    protected final By orderDropdown = By.cssSelector("[placeholder='* Срок аренды']");
    protected final By calendar = By.className("react-datepicker");
    protected final By monthDropdown = By.className("react-datepicker__month-select");

    //class="Dropdown-placeholder" * Срок аренды class="Dropdown-option" сутки пятеро суток
    //protected final By blackCheckbox = By.id("black");
    //protected final By greyCheckbox = By.id("grey");
    //id="black"
    //id="grey"
    //placeholder="Комментарий для курьера"
    //class="Button_Button__ra12g Button_Middle__1CSJM" text()="Заказать"





    private final WebDriver driver;

    public StatusPage2(WebDriver driver) {
        this.driver = driver;
    }

    public void checkLocator(By locator) {
        new WebDriverWait(driver, EXPLICIT_TIMEOUT)
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void checkInvisibleOfLocator(By locator) {
        new WebDriverWait(driver, EXPLICIT_TIMEOUT)
                .until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public void checkClickAndClick(By locator) {
        new WebDriverWait(driver, EXPLICIT_TIMEOUT)
                .until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public void enterNewValue(By locator, String newValue) {
        checkClickAndClick(locator);
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(newValue);
    }

    public void selectDate(By locator, String date) {
        checkClickAndClick(locator);
        checkLocator(calendar);
        By checkbox = By.cssSelector("div[aria-label='Choose понедельник, " + date + " г.']");
        checkLocator(checkbox);
        checkClickAndClick(checkbox);
        checkInvisibleOfLocator(calendar);
    }


    public void checkRentContent() {
        checkLocator(orderRentContent);
    }

    public void selectCheckbox(String value) {
        By checkbox = By.cssSelector("label[for='" + value + "']");
        checkClickAndClick(checkbox);
    }

    public void enterOrderRent(String date, String days, String color) {
        selectDate(orderDate, date);
        //selectDropdown(orderDropdown, days);
        selectCheckbox(color);
    }

}
