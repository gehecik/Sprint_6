package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.example.EnvConfig.*;

public class StatusPage2 extends BasePage{
    protected final By orderRentContent = By.xpath(XPATH_ORDER_RENT_CONTENT);
    protected final By orderDate = By.cssSelector("[placeholder='* Когда привезти самокат']");
    protected final By orderDropdown = By.className("Dropdown-placeholder");
    protected final By orderDropdownMenu = By.className("Dropdown-menu");
    protected final By calendar = By.className("react-datepicker");
    //protected final By monthDropdown = By.className("react-datepicker__month-select");
    protected final By orderComment = By.cssSelector("[placeholder='Комментарий для курьера']");
    //protected final By blackCheckbox = By.id("black");
    //protected final By greyCheckbox = By.id("grey");
    protected final By finishOrder = By.xpath("//button[contains(@class,'Button_Middle__1CSJM') and text()='Заказать']");
    protected final By yesButton = By.xpath("//button[contains(@class,'Button_Middle__1CSJM') and text()='Да']");
    protected final By statusViewButton = By.xpath("//button[contains(@class,'Button_Middle__1CSJM') and text()='Посмотреть статус']");
    //statusViewButton order number class = .Order_Text__2broi



    //input value="299999"


    //Track_OrderInfo__2fpDL  Track_Value__15eEX

    public StatusPage2(WebDriver driver) {
        super(driver);
    }

    public void selectDate(By locator, String date) {
        checkClickAndClick(locator);
        checkLocator(calendar);
        By checkbox = By.cssSelector("div[aria-label='Choose понедельник, " + date + " г.']");
        checkLocator(checkbox);
        checkClickAndClick(checkbox);
        checkInvisibleOfLocator(calendar);
    }

    public void selectDropdown(By locator, String dropdown) {
        checkClickAndClick(locator);
        checkLocator(orderDropdownMenu);

        By orderDay = By.xpath("//div[text()='" + dropdown + "']");
        checkLocator(orderDay);
        checkClickAndClick(orderDay);

        new WebDriverWait(driver, EXPLICIT_TIMEOUT)
                .until(ExpectedConditions.textToBePresentInElementLocated(locator, dropdown));
    }

    public void checkRentContent() {
        checkLocator(orderRentContent);
    }

    public void selectCheckbox(String value) {
        By checkbox = By.cssSelector("label[for='" + value + "']");
        checkClickAndClick(checkbox);
    }

    public void enterOrderRent(String date, String days, String color, String comment) {
        selectDate(orderDate, date);
        selectDropdown(orderDropdown, days);
        selectCheckbox(color);
        enterNewValue(orderComment, comment);

    }

    public void clickOnLastOrderButton() {
        checkClickAndClick(finishOrder);
    }


    public void clickOnYesButton() {
        checkClickAndClick(yesButton);
    }

    public StatusPage3 clickOnStatusViewButton() {
        checkClickAndClick(statusViewButton);

        return new StatusPage3(driver);
    }

    public void checkOrder() {

    }
}
