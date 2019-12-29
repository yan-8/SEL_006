import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Locale;

public class Tests extends BaseTest {

    @Test
    public void registrationNewUser () throws Exception {
        faker = new Faker(Locale.US);
        String email = faker.name().firstName().toLowerCase() + "_" + System.currentTimeMillis() + "@4qmail.com";
        String password = faker.lorem().characters(8, 16) + faker.lorem().characters(8, 16);

        driver.get("https://www.booking.com");

        driver.findElement(By.xpath(".//li[@id = 'current_account_create']//div[@class = 'sign_in_wrapper']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//input[@id = 'login_name_register']")));

        driver.findElement(By.xpath(".//input[@id = 'login_name_register']")).sendKeys(email);
        driver.findElement(By.xpath(".//button[@class = 'bui-button bui-button--large bui-button--wide']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//input[@id = 'password']")));

        driver.findElement(By.xpath(".//input[@id = 'password']")).sendKeys(password);
        driver.findElement(By.xpath(".//input[@id = 'confirmed_password']")).sendKeys(password);
        driver.findElement(By.xpath(".//button[@class = 'bui-button bui-button--large bui-button--wide']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//span[@class = 'user_name_block']")));

//        Thread.sleep(3_000);
    }
}