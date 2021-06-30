import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

public class TestBase {
    public static WebDriver driver;

    public static void initialize() {
        if (driver == null) {
            if (Constants.browserName.equalsIgnoreCase("Chrome")) {
                System.setProperty(Constants.driverChrome, Constants.chromeDriverPath);
                driver = new ChromeDriver();
            } else if (Constants.browserName.equalsIgnoreCase("FF")) {
                System.setProperty(Constants.driverFF, Constants.ffDriverPath);
                driver = new FirefoxDriver();
            } else if (Constants.browserName.equalsIgnoreCase("IE")) {
                System.setProperty(Constants.driverIe, Constants.ieDriverPath);
                driver = new InternetExplorerDriver();
            }

            TestBase.driver.manage().deleteAllCookies();
            TestBase.driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
            TestBase.driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
            TestBase.driver.manage().window().maximize();
            TestBase.driver.get(Constants.url);
        }
    }

    public static void quiteBrowser() {
        TestBase.driver.quit();
        System.out.println("Quitting browser");
        driver = null;
    }

    public static void closeBrowser() {
        TestBase.driver.close();
        System.out.println("Closing browser");
        driver = null;
    }
}