package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomeScooter {
    private WebDriver driver;

    // массив локаторов выпадающих списков
    private By[] dropDownLists = {
            By.xpath("//*[@id=\"accordion__heading-0\"]"),
            By.xpath("//*[@id=\"accordion__heading-1\"]"),
            By.xpath("//*[@id=\"accordion__heading-2\"]"),
            By.xpath("//*[@id=\"accordion__heading-3\"]"),
            By.xpath("//*[@id=\"accordion__heading-4\"]"),
            By.xpath("//*[@id=\"accordion__heading-5\"]"),
            By.xpath("//*[@id=\"accordion__heading-6\"]"),
            By.xpath("//*[@id=\"accordion__heading-7\"]")
    };

    // локатор кнопки "Заказать" вверху страницы
    private By orderButtonOnTop = By.xpath("//*[@id=\"root\"]/div/div/div[1]/div[2]/button[1]");

    // локатор кнопки "Заказать" внизу страницы //*[@id="root"]/div/div/div[4]/div[2]/div[5]/button
    private By orderButtonBelow = By.xpath("//*[@id=\"root\"]/div/div/div[4]/div[2]/div[5]/button");

    public HomeScooter(WebDriver driver) {
        this.driver = driver;
    }

    // метод для проверки клика по любому из выпадающих списков
    public boolean isTextVisible(int index) {
        if (index >= 0 && index < dropDownLists.length) {
            return driver.findElement(dropDownLists[index]).isDisplayed();
        } else {
            throw new IndexOutOfBoundsException("Invalid index for DropDownList: " + index);
        }
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
