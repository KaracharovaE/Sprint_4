package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class OrderPageScooter {
    private WebDriver driver;
    private WebDriverWait wait;

    // локатор поля "Имя"
    private By nameField = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/input");
    // локатор поля "Фамилия"
    private By surnameField = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/input");
    // локатор поля "Адрес"
    private By addressField = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[3]/input");
    // локатор поля "Станция метро"
    private By metroStationField = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[4]/div/div/input");
    // локатор поля "Телефон"
    private By phoneField = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[5]/input");
    // локатор кнопки "Далее"
    private By nextButton = By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/button");

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
        By stationLocator = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[4]/div/div[2]/ul/li[1]/button/div[contains(text(), 'Сокольники') or contains(text(), 'Бульвар Рокоссовского')]");
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
