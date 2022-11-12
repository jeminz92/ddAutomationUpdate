package DAY6_10_16_22;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class T1_FindElements {
    public static void main(String[] args){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("Start-maximized","incognito");
        WebDriver driver = new ChromeDriver(options);


        driver.navigate().to("Http://www.Yahoo.com");
        //driver.findElements(By.xpath("//*[contains(@class,'_yb_sc88r ')]")).get(3).click();
                //class="_yb_sc88r "
        driver.findElements(By.xpath("//*[contains(@class,'D(b)')]")).get(2).click();
        //class="D(b)         //*[contains(@class,'D(b)')]
        //by contain = "//*[contains(@id,'myId2')]"



    }
}
