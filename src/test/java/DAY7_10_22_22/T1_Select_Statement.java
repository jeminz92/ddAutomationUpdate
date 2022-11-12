package DAY7_10_22_22;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class T1_Select_Statement {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("Start-maximized","incognito");
        WebDriver driver = new ChromeDriver(options);

        //navigate to mcalc
        driver.navigate().to("http://www.mlcalc.com");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[text()='Show advanced options']")).click();
        Thread.sleep(2000);

        //use select command for month dropdown
        WebElement strtMonth = driver.findElement(By.xpath("//*[@name='sm']"));
        Select startMonthDropDown = new Select(strtMonth);
        //select by visible text
        startMonthDropDown.selectByVisibleText("Nov");

        //use select command for year dropdown
       // WebElement startYear = driver.findElement(By.xpath("//*[@name='sy']"));
        //select by visible text
       // Select startYearDropDown = new Select(startYear);
        //startYearDropDown.selectByVisibleText("2023");
        driver.findElement(By.xpath("//*[@name='sy']")).click();
        driver.findElement(By.xpath("//*[text()='2023']")).click();

        // if you don't want to use select method you can use click method, select method is more
        // optimal for drop down menus
        // select method is limited to inspect elements that only have select tag, where as driver find element
        // technique isn't and can use any property (id,class,etc)



    }
}
