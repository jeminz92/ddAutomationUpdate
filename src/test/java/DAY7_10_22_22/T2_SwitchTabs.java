package DAY7_10_22_22;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class T2_SwitchTabs {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("Start-Maximized","Incognito");
        WebDriver driver = new ChromeDriver(options);

        driver.navigate().to("http://www.fideliscare.org/");
        //wait 2 secs for page to load
        //click on shop for a plan
        driver.findElement(By.xpath("//*[text() = 'Shop For a Plan']")).click();
        //wait a bit
        Thread.sleep(2000);
        //click on medicaid managed care
        driver.findElement(By.xpath("//*[text() = 'Medicaid Managed Care']")).click();
        //wait a bit
        Thread.sleep(2000);
        //click on find a doctor search icon (which will launch a new tab)
        driver.findElement(By.xpath("//*[@class= 'btn btn-outline-primary btn-external btn-show link-external']")).click();
        //wait a bit
        Thread.sleep(2000);
//store the tabs in arraylist
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        //switch to the new tab
        driver.switchTo().window(tabs.get(1));
        //enter a zip code on the search field
        driver.findElement(By.xpath("//*[@id = 'searchLocation']")).sendKeys("11230");
        //wait a bit
        Thread.sleep(2000);
        //close the find a doctor tab
        driver.close();
        //switch to the initial tab (parent tab)
        driver.switchTo().window(tabs.get(0));
        //click on get coverage, first match is index 0
        //driver.findElements(By.xpath("//*[@class = 'btn ng-binding btn-primary']")).get(0).click();
        Thread.sleep(2000);
        driver.switchTo().window(tabs.get(0));
        driver.navigate().to("http://www.fideliscare.org/");
        driver.findElement(By.xpath("//*[@class = 'btn ng-binding btn-primary']")).click();
        Thread.sleep(2000);

    }//end of main
}//end of class
