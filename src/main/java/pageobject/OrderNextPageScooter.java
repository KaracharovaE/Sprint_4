package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class OrderNextPageScooter {
    private WebDriver driver;
    private WebDriverWait wait;

    // локатор поля "Когда привезти самокат"
    private final By timeField = By.xpath("//input[@placeholder='* Когда привезти самокат']");
    // локатор поля "Срок аренды" //*[@id="root"]/
    private final By rentalPeriodField = By.xpath("//div[1][@class='Dropdown-placeholder']");
    // локатор кнопки "Заказать"
    private final By orderButton = By.xpath("//button[2][contains(text(), 'Заказать')]"); // исправить
    // локатор кнопки "Да"
    private final By yesButton = By.xpath("//button[2][contains(text(), 'Да')]");

    public OrderNextPageScooter(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }

    // параметризацию time и rentalPeriod не смогла сделать, все время появлялась ошибка  no such element: Unable to locate element про календарь и выпадающий список
    public void selectTime19September(String time19September) {
        driver.findElement(timeField).click();
        By timeLocator19September = By.xpath("//div[@aria-label='Choose четверг, 19-е сентября 2024 г.']");
        driver.findElement(timeLocator19September).click();
    }

    public void selectTime20September(String time20September) {
        driver.findElement(timeField).click();
        By timeLocator20September = By.xpath("//div[@aria-label='Choose пятница, 20-е сентября 2024 г.']");
        driver.findElement(timeLocator20September).click();
    }

    public void selectRentalPeriod1Day(String rentalPeriod) {
        driver.findElement(rentalPeriodField).click();
        By rentalPeriodLocator1Day = By.xpath("//div[1][contains(text(), 'сутки')]");
        driver.findElement(rentalPeriodLocator1Day).click();
    }

    public void selectRentalPeriod2Days(String rentalPeriod) {
        driver.findElement(rentalPeriodField).click();
        By rentalPeriodLocator2Days = By.xpath("//div[2][contains(text(), 'двое суток')]");
        driver.findElement(rentalPeriodLocator2Days).click();
    }

    public void clickOrderButton() {
        driver.findElement(orderButton).click();
    }

    public void clickYesButton() {
        WebElement yesButtonElement = wait.until(ExpectedConditions.elementToBeClickable(yesButton));
        yesButtonElement.click();
    }

    public String getSuccessMessage() {
        WebElement successMessageElement = driver.findElement(By.xpath("//div[1][contains(text(), 'Заказ оформлен')]"));
        return successMessageElement.getText();
    }

    public void waitForLoadWindowOrder() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[1][contains(text(), 'Заказ оформлен')]")));
    }
}