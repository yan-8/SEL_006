import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

@RunWith(DataProviderRunner.class)
public class Tests extends BaseTest {
    @Test
    @UseDataProvider(value = "validUser", location = DataProviders.class)
    public void registrationNewUser(User user) throws Exception {
        // открыть главную страницу
        driver.get("https://www.booking.com");

        // кликаем на кнопку и ждем открытие новое страницы, ждем пока не появится определенный элемент
        driver.findElement(By.xpath(".//li[@id = 'current_account_create']//div[@class = 'sign_in_wrapper']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//input[@id = 'login_name_register']")));

        // вводим логин/логин и жмем на кнопку ОК и ждем пока не появится нужный элемент на другой странице
        driver.findElement(By.xpath(".//input[@id = 'login_name_register']")).sendKeys(user.getEmail());
        driver.findElement(By.xpath(".//button[@class = 'bui-button bui-button--large bui-button--wide']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//input[@id = 'password']")));

        // заполняем пароль и жем пока не появится нужный элемент
        driver.findElement(By.xpath(".//input[@id = 'password']")).sendKeys(user.getPassword());
        driver.findElement(By.xpath(".//input[@id = 'confirmed_password']")).sendKeys(user.getPassword());
        driver.findElement(By.xpath(".//button[@class = 'bui-button bui-button--large bui-button--wide']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//span[@class = 'user_name_block']")));

//        Thread.sleep(3_000);
    }

//    @Test
    public void logInTestUser() {
    }
}