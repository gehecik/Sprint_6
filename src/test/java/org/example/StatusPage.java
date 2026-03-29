package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.example.EnvConfig.*;

public class StatusPage {

    //protected final By orderContent = By.className(CLASS_ORDER_CONTENT);
    protected final By orderContent = By.xpath(XPATH_ORDER_PERSON_CONTENT);
    protected final By orderName = By.cssSelector("[placeholder='* Имя']");
    protected final By orderSurname = By.cssSelector("[placeholder='* Фамилия']");
    protected final By orderAddress = By.cssSelector("[placeholder='* Адрес: куда привезти заказ']");
    protected final By orderSubway = By.className("select-search__value");
    protected final By subwayValue = By.className("select-search__options");
    //By.cssSelector("[data-index='0'])"
    protected final By orderPhone = By.cssSelector("[placeholder='* Телефон: на него позвонит курьер']");
    protected final By orderNextButton = By.className(CLASS_NEXT_ORDER_BUTTON);


    private final WebDriver driver;

    public StatusPage(WebDriver driver) {
        this.driver = driver;
    }

    public void checkLocator(By locator) {
        new WebDriverWait(driver, EXPLICIT_TIMEOUT)
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void checkClickAndClick(By locator) {
        new WebDriverWait(driver, EXPLICIT_TIMEOUT)
                .until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public void checkOrderContent() {
        checkLocator(orderContent);
    }

    public void enterNewValue(By locator, String newValue) {
        checkClickAndClick(locator);
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(newValue);
    }

    public void enterSubwayValue(By locator, String subway) {
        checkClickAndClick(locator);
        By locatorSubway = By.xpath("//div[text()='" + subway + "']");
        checkClickAndClick(locatorSubway);
    }

    public void enterOrderPerson(String name, String surname, String address, String subway, String phone) {
        enterNewValue(orderName, name);
        enterNewValue(orderSurname, surname);
        enterNewValue(orderAddress, address);
        enterSubwayValue(orderSubway, subway);
        enterNewValue(orderPhone, phone);
    }

    public StatusPage2 clickOnNextOrderButton() {
        checkClickAndClick(orderNextButton);

        return new StatusPage2(driver);
    }
}
