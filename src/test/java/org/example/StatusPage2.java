package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

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
    protected final By orderSuccess = By.xpath("//div[contains(text(),'Заказ оформлен')]");
    protected final By currentMonthYear = By.className("react-datepicker__month");
    protected final By calendarDayItem = By.className("react-datepicker__day");
    //input value="299999"
    //Track_OrderInfo__2fpDL  Track_Value__15eEX

    public StatusPage2(WebDriver driver) {
        super(driver);
    }

    public String dateElement(String ariaLabel) {
        String cleaned = ariaLabel
                .replace("Choose", "")
                .replace("г.", "")
                .replaceAll("-е", "")
                .trim();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(
                "EEEE, d MMMM yyyy",
                new Locale("ru")
        );

        return String.valueOf(LocalDate.parse(cleaned, formatter));
    }

    public void selectDate(By locator, String date) {
        checkClickAndClick(locator);
        checkLocator(calendar);

//        WebElement element = driver.findElement(currentMonthYear);
//        checkLocator(currentMonthYear);
//        String ariaLabelMonth = element.getAttribute("aria-label");
//        String[] parts = ariaLabelMonth.split("\\s+");
//        String[] dateCurrent = parts[1].split("-");
//
//        int yearCurrent = Integer.parseInt(dateCurrent[0]);
//        int monthCurrent = Integer.parseInt(dateCurrent[1]);
//
//        String day = date.split("-")[2];
//        String month = date.split("-")[1];
//        String year = date.split("-")[0];
//
//        if (year.equals(dateCurrent)) {
//            if (month.equals(monthCurrent))
//            {
//                List<WebElement> elements = driver.findElements(calendarDayItem);
//                for (int i = 0; i < elements.size(); i++) {
//                    String ariaLabelDay = elements.get(i).getAttribute("aria-label");
//                    if (dateElement(ariaLabelDay).equals(date)) {
//                        checkLocator(By.cssSelector(ariaLabelDay));
//                        checkClickAndClick(By.cssSelector(ariaLabelDay));
//                    }
//                }
//
//            }
//        }


        String xpath = "//div[contains(@aria-label, '" + date + "')]";
        By checkbox = By.xpath(xpath);
                        //By.cssSelector("div[aria-label='Choose понедельник, " + date + " г.']");
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

    public void enterOrderRent(RentData rentData) {


        selectDate(orderDate, rentData.date);
        selectDropdown(orderDropdown, rentData.days);
        selectCheckbox(rentData.color);
        enterNewValue(orderComment, rentData.comment);

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
        checkLocator(orderSuccess);
    }
}
