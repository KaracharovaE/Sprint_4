package PageObject;

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
    private By timeField = By.xpath("/html/body/div/div/div[2]/div[2]/div[1]/div[1]/div/input");
    // локатор поля "Срок аренды" //*[@id="root"]/
    private By rentalPeriodField = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div[1]");
    // локатор кнопки "Заказать"
    private By orderButton = By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/button[2]");
    // локатор кнопки "Да"
    private By yesButton = By.xpath("//*[@id=\"root\"]/div/div[2]/div[5]/div[2]/button[2]");

    public OrderNextPageScooter(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }
// параметризацию time и rentalPeriod не смогла сделать, все время появлялась ошибка  no such element: Unable to locate element про календарь и выпадающий список
    public void selectTime19September(String time19September) {
        driver.findElement(timeField).click();
        By timeLocator19September = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/div[2]/div[2]/div/div/div[2]/div[2]/div[4]/div[4]");
        driver.findElement(timeLocator19September).click();
    }

    public void selectTime20September(String time20September) {
        driver.findElement(timeField).click();
        By timeLocator20September = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/div[2]/div[2]/div/div/div[2]/div[2]/div[4]/div[5]");
        driver.findElement(timeLocator20September).click();
    }

    public void selectRentalPeriod1Day(String rentalPeriod) {
        driver.findElement(rentalPeriodField).click();
        By rentalPeriodLocator1Day = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div[2]/div[1]");
        driver.findElement(rentalPeriodLocator1Day).click();
    }

    public void selectRentalPeriod2Days(String rentalPeriod) {
        driver.findElement(rentalPeriodField).click();
        By rentalPeriodLocator2Days = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div[2]/div[2]");
        driver.findElement(rentalPeriodLocator2Days).click();
    }

    public void clickOrderButton() {
        driver.findElement(orderButton).click();
    }

    public void waitForLoadWindowConfirm() {
        new WebDriverWait(driver, Duration.ofSeconds(3)) // Change here
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div[2]/div[5]")));
    }

    public void clickYesButton() {
        WebElement yesButtonElement = wait.until(ExpectedConditions.elementToBeClickable(yesButton));
        yesButtonElement.click();
    }

    public void waitForLoadWindowOrder() {
        new WebDriverWait(driver, Duration.ofSeconds(3)) // Change here
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div[2]/div[5]")));
    }

    public String getSuccessMessage() {
        By successMessageLocator = By.xpath("/html/body/div/div/div[2]/div[5]/div[1][contains(text(), 'Заказ оформлен')]"); // Замените текст на актуальный
        wait.until(ExpectedConditions.visibilityOfElementLocated(successMessageLocator));
        return driver.findElement(successMessageLocator).getText();
    }
}