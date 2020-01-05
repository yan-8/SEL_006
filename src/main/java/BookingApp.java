import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

public class BookingApp {
    private WebDriver driver;
    private WebDriverWait wait;

    public BookingApp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/mac/chromedriver");

        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 15);

        driver.manage().window().setPosition(new Point(0, 0));
    }

    public void registration(User user) {
        driver.get("https://www.booking.com");

        driver.findElement(By.xpath(".//li[@id = 'current_account_create']//div[@class = 'sign_in_wrapper']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//input[@id = 'login_name_register']")));

        driver.findElement(By.xpath(".//input[@id = 'login_name_register']")).sendKeys(user.getEmail());
        driver.findElement(By.xpath(".//button[@class = 'bui-button bui-button--large bui-button--wide']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//input[@id = 'password']")));

        driver.findElement(By.xpath(".//input[@id = 'password']")).sendKeys(user.getPassword());
        driver.findElement(By.xpath(".//input[@id = 'confirmed_password']")).sendKeys(user.getPassword());
        driver.findElement(By.xpath(".//button[@class = 'bui-button bui-button--large bui-button--wide']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//span[@class = 'user_name_block']")));
    }

    public String getTextFromElement(String locator) {
        return driver.findElement(By.xpath(locator)).getText();
    }

    public void quit() {
        driver.quit();
    }
}