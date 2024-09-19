import PageObject.HomeScooter;
import PageObject.OrderNextPageScooter;
import PageObject.OrderPageScooter;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class GetOrderTest {
    private WebDriver driver;

    @Parameterized.Parameter(0)
    public String name;

    @Parameterized.Parameter(1)
    public String surname;

    @Parameterized.Parameter(2)
    public String address;

    @Parameterized.Parameter(3)
    public String stationName;

    @Parameterized.Parameter(4)
    public String phone;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {"Катя", "Иванова", "Семакова 10", "Бульвар Рокоссовского", "89000000000"},
                {"Маша", "Петрова", "Ушакова 1", "Сокольники", "89876543210"},
        };
    }
//Тест для кнопки Заказать сверху, 19 сентября и сутки
    @Test
    public void makeOrderWithButtonOnTop() {
        driver = new ChromeDriver();
        // переход на страницу Самоката
        driver.get("https://qa-scooter.praktikum-services.ru/");
        HomeScooter objHomeScooter = new HomeScooter(driver);
        objHomeScooter.clickOrderButtonOnTop();

        OrderPageScooter objOrderPageScooter = new OrderPageScooter(driver);
        objOrderPageScooter.makeOrder(name, surname, address, stationName, phone);

        OrderNextPageScooter orderNextPageScooter = new OrderNextPageScooter(driver);
        orderNextPageScooter.selectTime19September("19");
        orderNextPageScooter.selectRentalPeriod1Day("сутки");
        orderNextPageScooter.clickOrderButton();
        orderNextPageScooter.waitForLoadWindowConfirm();
        orderNextPageScooter.clickYesButton();
        orderNextPageScooter.waitForLoadWindowOrder();

        String successMessage = orderNextPageScooter.getSuccessMessage();
        assertEquals("Заказ оформлен", successMessage);
    }

    //Тест для кнопки Заказать снизу, 20 сентября и двое суток
    @Test
    public void makeOrderWithButtonBelow() {
        driver = new ChromeDriver();
        // переход на страницу Самоката
        driver.get("https://qa-scooter.praktikum-services.ru/");
        HomeScooter objHomeScooter = new HomeScooter(driver);
        objHomeScooter.clickOrderButtonBelow();

        OrderPageScooter objOrderPageScooter = new OrderPageScooter(driver);
        objOrderPageScooter.makeOrder(name, surname, address, stationName, phone);

        OrderNextPageScooter orderNextPageScooter = new OrderNextPageScooter(driver);
        orderNextPageScooter.selectTime20September("20");
        orderNextPageScooter.selectRentalPeriod2Days("двое суток");
        orderNextPageScooter.clickOrderButton();
        orderNextPageScooter.waitForLoadWindowConfirm();
        orderNextPageScooter.clickYesButton();
        orderNextPageScooter.waitForLoadWindowOrder();

        String successMessage = orderNextPageScooter.getSuccessMessage();
        assertEquals("Заказ оформлен", successMessage);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}