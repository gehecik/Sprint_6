package org.example;

import org.openqa.selenium.By;

import java.time.Duration;

public class EnvConfig {
    public static final String BASE_URL = "https://qa-scooter.praktikum-services.ru/";
    public static final Duration EXPLICIT_TIMEOUT = Duration.ofSeconds(5);
    public static final String CLASS_COOKIE_BUTTON = "App_CookieButton__3cvqF";
    public static final String CLASS_ACCORDION_ITEM = "accordion__item";
    public static final String CLASS_ACCORDION_HEADING = "accordion__button";
    public static final String CLASS_ACCORDION_PANEL = "accordion__panel";
    public static final String CLASS_HEADER_NAV = "Header_Nav__AGCXC";
    public static final String CLASS_ORDER_BUTTON = "Button_Button__ra12g";
    public static final String CLASS_NEXT_ORDER_BUTTON = "Button_Middle__1CSJM";
    public static final String CLASS_ORDER_CONTENT = "Order_Content__bmtHS";
    public static final String XPATH_ORDER_PERSON_CONTENT = "//div[contains(text(),'Для кого самокат')]";
    public static final String XPATH_ORDER_RENT_CONTENT = "//div[contains(text(),'Про аренду')]";
    public static final String CLASS_RESPONSIBLE = "Input_Responsible__1jDKN";
    public static final String XPATH_ORDER_MIDDLE_BUTTON = "//button[contains(@class,'Button_Middle__1CSJM') and text()='Заказать']";
    public static final String SELECTOR_ORDER_NAME = "[placeholder='* Имя']";
    public static final String SELECTOR_ORDER_SURNAME = "[placeholder='* Фамилия']";
    public static final String SELECTOR_ORDER_ADDRESS = "[placeholder='* Адрес: куда привезти заказ']";
    public static final String CLASS_ORDER_SUBWAY = "select-search__value";
    public static final String CLASS_SUBWAY_VALUE = "select-search__options";
    public static final String SELECTOR_ORDER_PHONE = "[placeholder='* Телефон: на него позвонит курьер']";

}
