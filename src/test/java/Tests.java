import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

// тестовый класс "Tests" использует объект BookingApp, который представляет собой Page Object
@RunWith(DataProviderRunner.class)
public class Tests extends BaseTest {
    @Test
    @UseDataProvider(value = "validUser", location = DataProviders.class)
    public void registrationNewUser(User user) {
        bookingApp.registration(user);
        Assert.assertEquals("Your account", bookingApp.getTextFromElement(".//span[@id = 'profile-menu-trigger--content']"));
    }
}