import org.junit.Test;

public class Tests extends BaseTest {

    @Test
    public void test1 () throws Exception {
        driver.get("https://www.booking.com");
        Thread.sleep(3_000);
    }
}