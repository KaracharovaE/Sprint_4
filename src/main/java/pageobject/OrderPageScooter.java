package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class OrderPageScooter {
    private WebDriver driver;
    private WebDriverWait wait;

    // локатор поля "Имя"
    private final By nameField = By.xpath("//input[@placeholder= '* Имя']");
    // локатор поля "Фамилия"
    private final By surnameField = By.xpath("//input[@placeholder= '* Фамилия']");
    // локатор поля "Адрес"
    private final By addressField = By.xpath("//input[@placeholder= '* Адрес: куда привезти заказ']");
    // локатор поля "Станция метро"
    private final By metroStationField = By.xpath("//input[@placeholder= '* Станция метро']");
    // локатор поля "Телефон"
    private final By phoneField = By.xpath("//input[@placeholder= '* Телефон: на него позвонит курьер']");
    // локатор кнопки "Далее"
    private final By nextButton = By.xpath("//button[contains(text(), 'Далее')]");

    public OrderPageScooter(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void setName(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    public void setSurname(String surname) {
        driver.findElement(surnameField).sendKeys(surname);
    }

    public void setAddress(String address) {
        driver.findElement(addressField).sendKeys(address);
    }

    public void selectMetroStation(String stationName) {
        driver.findElement(metroStationField).click();
        By stationLocator = By.xpath("//div[contains(text(), 'Сокольники') or contains(text(), 'Бульвар Рокоссовского')]");
        driver.findElement(stationLocator).click();
        // Переместить фокус на поле имя для закрытия списка
        driver.findElement(nameField).click();
    }

    public void setPhone(String phone) {
        driver.findElement(phoneField).sendKeys(phone);
    }

    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }

    public void makeOrder(String name, String surname, String address, String stationName, String phone) {
        setName(name);
        setSurname(surname);
        setAddress(address);
        selectMetroStation(stationName);
        setPhone(phone);
        clickNextButton();
    }
}
