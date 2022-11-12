package DAY6_10_16_22;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class T2_MlcalcWebElements {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("Start-maximized", "incognito");
        WebDriver driver = new ChromeDriver(options);

        driver.navigate().to("http://www.mlcalc.com");
        Thread.sleep(3000);

        WebElement pPrice = driver.findElement(By.xpath("//*[@name='ma']"));
        //clear the purchase price
        pPrice.clear();
        //type new value on the purchase price
        pPrice.sendKeys("450000");

        //clear and enter a new value on down payment field
        WebElement dPayment = driver.findElement(By.xpath("//*[@name='dp']"));
        //clear the down payment
        dPayment.clear();
        //type new value on the down payment
        dPayment.sendKeys("25");

        //WebElement cTMR = driver.findElement(By.xpath("//*[@type='button']"));
        //cTMR.click();

        WebElement calculate = driver.findElement(By.xpath("//*[@type='submit']"));
        calculate.click();


    }//end of main
}//end of class
