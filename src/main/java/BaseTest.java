import com.github.javafaker.Faker;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.*;

public class BaseTest {
    protected static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Faker faker;

    @Before
    public void start() {
        if (threadLocalDriver.get() != null) {
            driver = threadLocalDriver.get();
            wait = new WebDriverWait(driver, 15); // явное ожидание
            return;
        }

        System.setProperty("webdriver.chrome.driver", "src/main/resources/mac/chromedriver");
        driver = new ChromeDriver();
        threadLocalDriver.set(driver);
        driver.manage().window().setPosition(new Point(0, 0));
        wait = new WebDriverWait(driver, 15); // явные

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            driver.quit();
            driver = null;
        }));
    }
}