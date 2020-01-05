import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

// все технические подробности спрятаны в этом классе, создаётся Driver и здесь он используется
// в итоге получаем двухслойные тесты:
// 1 - спецификация поведения системы, наш тестовый класс "Tests"
// 2 - второй слой, реаоизация, этот "BookingApp" класс
// также описывает Мартин Файлер, когда описывал Page Object в своей статье
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
        // открыть главную страницу
        driver.get("https://www.booking.com");

        // кликаем на кнопку и ждем открытие новое страницы для ввода email, ждем пока появится определенный элемент на странице
        driver.findElement(By.xpath(".//li[@id = 'current_account_create']//div[@class = 'sign_in_wrapper']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//input[@id = 'login_name_register']")));

        // вводим логин и жмем на кнопку ОК и ждем пока появится нужный элемент на следующей странице
        driver.findElement(By.xpath(".//input[@id = 'login_name_register']")).sendKeys(user.getEmail());
        driver.findElement(By.xpath(".//button[@class = 'bui-button bui-button--large bui-button--wide']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//input[@id = 'password']")));

        // вводим пароль и жем пока появится нужный элемент на главной странице
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