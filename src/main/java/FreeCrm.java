import org.junit.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FreeCrm {

    @BeforeMethod
    public void setUp() {
        TestBase.initialize();
    }

    @Test(priority = 1)
    public void freeCrmHomePage() {
        String title = TestBase.driver.getTitle();
        System.out.println("Home Page title = " + title);
        Assert.assertEquals(title, Constants.pageTitle);
    }

    @Test(priority = 2)
    public void loginButton() {
        Assert.assertEquals(TestBase.driver.findElement(By.xpath("//a[@class = 'btn btn-primary btn-xs-2 btn-shadow btn-rect btn-icon btn-icon-left']")).isDisplayed(), true);
        System.out.println("Login button is displayed");
    }

    @AfterMethod
    public void tearDown() {
        TestBase.quiteBrowser();
    }
}
