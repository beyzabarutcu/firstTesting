import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class BaseClass {
    protected WebDriver driver;

    @Before
    public void setUp() {
        Logger log = Logger.getLogger("devpinoyLogger");
        System.setProperty("webdriver.chrome.driver", "C:/driver/chromedriver.exe");
        driver = new ChromeDriver();
        log.info("Chrome Opened");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @After
    public void quit(){
        //driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        driver.quit();
    }
}
