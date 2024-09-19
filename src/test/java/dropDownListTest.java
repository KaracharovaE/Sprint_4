import PageObject.HomeScooter;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.junit.After;
import org.junit.Test;

public class dropDownListTest {
    private WebDriver driver;

    @Test
    public void checkActivity() {
        driver = new ChromeDriver();
        // переход на страницу Самоката
        driver.get("https://qa-scooter.praktikum-services.ru/");
        HomeScooter objHomeScooter = new HomeScooter(driver);

        for (int i = 0; i < 8; i++) {
            objHomeScooter.isTextVisible(i);
            Assert.assertTrue("Текст для выпадающего списка " + i + " не виден.", objHomeScooter.isTextVisible(i));
        }
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}