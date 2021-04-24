import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import java.util.logging.Logger;

public class LoginPage extends  BaseClass{

    @Test
    public void LoginTest() {
        Logger log = Logger.getLogger("devpinoyLogger");
        driver.get("https://www.gittigidiyor.com/");
        Assert.assertEquals(driver.getTitle(), "GittiGidiyor - Türkiye'nin Öncü Alışveriş Sitesi");
        log.info("Checking Website");
        /*String expectedTitle = "GittiGidiyor - Türkiye'nin Öncü Alışveriş Sitesi";
        String actualTitle = driver.findElement(By.xpath("./html/head/title")).getText();
        if (expectedTitle.equals(actualTitle)) //compare
        {
            System.out.println("Verification Successful - The correct title is displayed on the web page.");
        }
        else
        {
            System.out.println("Verification Failed - An incorrect title is displayed on the web page.");
        }*/

        driver.findElement(By.className("gekhq4-4 egoSnI")).click();
        driver.findElement(By.name("kullanici")).sendKeys("Your mail address");
        driver.findElement(By.name("sifre")).sendKeys("Your password");
        driver.findElement(By.id("gg-login-enter")).click();

    }

}
