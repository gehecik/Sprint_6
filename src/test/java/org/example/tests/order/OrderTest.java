package org.example.tests.order;

import org.example.utils.DriverExtension;
import org.example.pages.order.OrderHomePage;
import org.example.data.PersonData;
import org.example.data.RentData;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;

import java.util.stream.Stream;

public class OrderTest {
    @RegisterExtension
    private final DriverExtension extension = new DriverExtension();

    @ParameterizedTest
    @MethodSource("orderData")
    public void createOrderSuccessfully(String buttonForOrder, PersonData personData, RentData rentData) {
        WebDriver driver = extension.getDriver();
        var orderPage = new OrderHomePage(driver);

        orderPage.openPage();
        orderPage.clickOnCookieButton();

        var orderPersonPage = orderPage.clickOnOrderButton(buttonForOrder);
        orderPersonPage.checkOrderContent();
        orderPersonPage.enterOrderPerson(personData);
        var orderRentPage = orderPersonPage.clickOnNextOrderButton();
        orderRentPage.checkRentContent();
        orderRentPage.enterOrderRent(rentData);
        orderRentPage.clickOnLastOrderButton();
        orderRentPage.clickOnYesButton();
        orderRentPage.checkOrder();
        var orderViewPage = orderRentPage.clickOnStatusViewButton();
        orderViewPage.checkStatusContent();

    }

    private static Stream<Arguments> orderData() {
        return Stream.of(
                Arguments.of("header",
                        new PersonData("Имя",
                                "Фамилия",
                                "Тестовый адрес 123",
                                "Черкизовская",
                                "+1111111111"
                        ),
                        new RentData("30-е марта 2026", //"2026-03-30"
                                "пятеро суток",
                                "black",
                                "Хотела проработать календарь, но не получилось"
                        )
                ),
                Arguments.of( "middle",
                        new PersonData("ИмяИмя",
                                "ФамилияФамилия",
                                "Тестовый адрес 456",
                                "Преображенская площадь",
                                "+2222222222"
                        ),
                        new RentData("31-е марта 2026",
                                "сутки",
                                "grey",
                                "Ошибки в полях Станция метро - следующая, Дата доставки + срок"
                        )
                )
        );
    }

}
