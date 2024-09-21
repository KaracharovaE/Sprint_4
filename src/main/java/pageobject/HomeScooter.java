package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HomeScooter {
    private WebDriver driver;

    // локатор списка выопросов
    private final By listQuestion = By.xpath("//div[@class='accordion']");
    // локатор кнопки "Заказать" вверху страницы
    private final By orderButtonOnTop = By.xpath("//button[1][@class='Button_Button__ra12g']");
    // локатор кнопки "Заказать" внизу страницы ****
    private final By orderButtonBelow = By.xpath("//button[contains(text(), 'Заказать')]");

    public HomeScooter(WebDriver driver) {
        this.driver = driver;
    }

    public void scrollToQuestions() {
        WebElement element = driver.findElement(listQuestion);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void clickQuestions(String number) {
        driver.findElement(By.id("accordion__heading-" + number)).click();
    }

    public String getAnswer(String number) {
        String elementId = "accordion__panel-";
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id(elementId + number)));
    return driver.findElement(By.id(elementId + number)).getText();
    }

    public String getQuestions(String number) {
        return driver.findElement(By.id("accordion__heading-" + number)).getText();
    }

    // метод для клика по кнопке "Заказать" вверху страницы
    public void clickOrderButtonOnTop() {
        WebElement buttonTop = driver.findElement(orderButtonOnTop);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", buttonTop);
        buttonTop.click();
    }

    // метод для клика по кнопке "Заказать" внизу страницы
    public void clickOrderButtonBelow() {
        WebElement buttonBelow = driver.findElement(orderButtonBelow);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", buttonBelow);
        buttonBelow.click();
    }
}