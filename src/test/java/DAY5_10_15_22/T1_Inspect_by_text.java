package DAY5_10_15_22;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class T1_Inspect_by_text {
    public static void main(String[] args) throws InterruptedException {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.navigate().to("https://www.yahoo.com");
        driver.manage().window().maximize();

        // driver.manage().window().maximize();

        driver.findElement(By.xpath("//*[text()='Sign in']")).click();

        driver.navigate().to("http://www.Yahoo.com");
        driver.findElement(By.xpath("//*[text()='Sign in']")).click();

        driver.findElement(By.xpath("//*[@id='createacc']")).click();
        driver.findElement(By.xpath("//*[@name='firstName']")).sendKeys("test");
        driver.findElement(By.xpath("//*[@name='lastName']")).sendKeys("test");
        driver.findElement(By.xpath("//*[@id='usernamereg-userId']")).sendKeys("testaccount");
        driver.findElement(By.xpath("//*[@id='usernamereg-password']")).sendKeys("Password");
        driver.findElement(By.xpath("//*[@id='usernamereg-birthYear']")).sendKeys("test");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[text()='Continue']")).submit();

        // text is a function that is why it uses parenthesis = 'value'
        // driver.findElement(By.xpath("//*[text()='Create an&nbsp;account']")).click();
        // contains is very useful if there is a space in text or the id class or value is very long
        // or if it's dynamically changing
        //*[text()='Create an&nbsp;account']


        //*[contains(@data-stid,'destination_form_field-result-item-button']
       // driver.findElement(By.xpath("//*[@id='tpa-google-button']")).click();
        //by text = "//*[text()='placeholder']"
        //by contain = "//*[contains(@id,'myId2')]"
        //by xpath = "//*[@name='placeholder']"
        Thread.sleep(3000);
        //ytd-searchbox  //*[text()='ytd-searchbox']"
        // driver.quit();

    }


}
