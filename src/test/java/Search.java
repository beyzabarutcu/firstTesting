import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class Search extends  BaseClass{

    @Test
    public void SearchTest(){
        Logger log = Logger.getLogger("devpinoyLogger");
        Random rnd=new Random();
        int index = rnd.nextInt(48)+1;
        System.out.println(index);

        driver.get("https://www.gittigidiyor.com/");
        WebElement txtSearch=driver.findElement(By.name("k"));
        txtSearch.sendKeys("bilgisayar");
        WebElement btnSearch=driver.findElement(By.xpath("//*[@id=\"main-header\"]/div[3]/div/div/div/div[2]/form/div/div[2]/button/span"));
        btnSearch.click();

       // driver.findElement(By.linkText("2")).click();//second page
      //  Assert.assertEquals(driver.getTitle(), "Bilgisayar - GittiGidiyor - 2/100");

        List<WebElement> products = driver.findElements(By.cssSelector("li[class='gg-uw-6 gg-w-8 gg-d-8 gg-t-8 gg-m-24 gg-mw-12 catalog-seem-cell srp-item-list  browser']"));
        products.get(index).click(); //we chose random product after searching
        String productName = driver.findElement(By.id("sp-title")).getText();
        System.out.println(productName);
        String priceProduct = driver.findElement(By.id("sp-price-lowPrice")).getText();//product price
        System.out.println(priceProduct);

        driver.findElement(By.id("add-to-basket")).click(); //added basket
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);

        driver.findElement(By.className("IncNumber gg-icon gg-icon-plus")).click();
        String quantity = driver.findElement(By.id("buyitnow_adet")).getText();
        Assert.assertEquals(quantity,"2");
        log.info("Checking Quantity");

        driver.findElement(By.xpath("//*[@id=\"header_wrapper\"]/div[4]/div[3]/div/div/div/div[2]/div[4]/div[1]/a")).click(); // basket page
        String priceBasket = driver.findElement(By.className("total-price")).getText();
        System.out.println(priceBasket);
        Assert.assertEquals(priceBasket,priceProduct);

        driver.findElement(By.className("btn-delete btn-update-item")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"empty-cart-container\"]/div[1]/div[1]/div/div[2]/h2")).getText(),"Sepetinizde ürün bulunmamaktadır." );
    }
}
