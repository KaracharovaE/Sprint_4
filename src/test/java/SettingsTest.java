import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.After;
import org.junit.Before;

public class SettingsTest {
    protected WebDriver driver;

    final String url = "https://qa-scooter.praktikum-services.ru/";

    @Before
    public void open(){
        driver = new ChromeDriver();
        driver.get(url);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

