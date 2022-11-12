package DAY5_10_15_22;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class T2_ChromeOptions {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized", "incognito");
        // options.addArguments("Headless");
        WebDriver driver = new ChromeDriver(options);

        driver.navigate().to("http://www.google.com");
        //search a keyword on the search field
        //relative xpath to locate the element
        driver.findElement(By.xpath("//*[@name='q']")).sendKeys("Cars");
        //hit submit on the google search button
        driver.findElement(By.xpath("//*[@name='btnK']")).submit();

        //sleep statement
        Thread.sleep(3000);

        //capture the search result text
        String result = driver.findElement(By.xpath("//*[@id='result-stats']")).getText();
        //split message to extract out the search number
        String[] splitResult = result.split(" ");
        System.out.println("the search number is " + splitResult[1]);
        Thread.sleep(3000);
            driver.quit();

    }


}
