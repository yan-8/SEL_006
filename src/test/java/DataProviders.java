import com.github.javafaker.Faker;
import com.tngtech.java.junit.dataprovider.DataProvider;
import java.util.Locale;

// тестовые данные
public class DataProviders {
    private static Faker faker = new Faker(Locale.US);
    private static String email = faker.name().firstName().toLowerCase() + "_" + System.currentTimeMillis() + "@4qmail.com";
    private static String password = faker.lorem().characters(8, 16) + faker.lorem().characters(8, 16);

    @DataProvider
    public static Object[][] validUser() {
        return new Object[][] {
                {
                    User.newEntity()
                            .setEmail(email)
                            .setPassword(password)
                            .build()
                },
        };
    }
}