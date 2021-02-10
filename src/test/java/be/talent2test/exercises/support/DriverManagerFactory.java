package be.talent2test.exercises.support;

public class DriverManagerFactory {
    public DriverManager getDriverManager(BROWSERS browser) {
        switch (browser) {
            case CHROME:
                return new ChromeManager();
            case FIREFOX:
            default:
                return new FireFoxManager();
        }
    }
}
