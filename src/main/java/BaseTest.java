import org.junit.Before;

// базовый класс для тестов, создает новый экземпляр класса BookingApp
public class BaseTest {
    public static ThreadLocal<BookingApp> threadLocalBookingApp = new ThreadLocal<>();
    public BookingApp bookingApp;

    @Before
    public void start() {
        if (threadLocalBookingApp.get() != null) {
            bookingApp = threadLocalBookingApp.get();
            return;
        }

        bookingApp = new BookingApp();
        threadLocalBookingApp.set(bookingApp);

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            bookingApp.quit();
            bookingApp = null;
        }));
    }
}