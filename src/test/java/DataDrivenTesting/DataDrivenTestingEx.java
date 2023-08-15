package DataDrivenTesting;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class DataDrivenTestingEx {

    WebDriver driver;



    @Test(dataProvider = "LoginData")
    public void loginTest(String user, String pwd, String exp) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://admin-demo.nopcommerce.com/login");
        WebElement email = driver.findElement(By.xpath("//*[@id=\"Email\"]"));
        WebElement password = driver.findElement(By.xpath("//*[@id=\"Password\"]"));
        email.clear();
        email.sendKeys(user);
        password.clear();
        password.sendKeys(pwd);
        driver.findElement(By.xpath("//*[@class=\"button-1 login-button\"]")).click(); // loginButton
        String expTitle = "Dashboard / nopCommerce administration";
        String actualTitle = driver.getTitle();

        if(exp.equals("Valid")) {
            if (expTitle.equals(actualTitle)) {
                driver.findElement(By.linkText("Logout")).click();
                Assert.assertTrue(true);
            } else {
                Assert.assertTrue(false);
            }
        }
            else if (exp.equals("Invalid"))
            {
                if(expTitle.equals(actualTitle))
                {
                    driver.findElement(By.linkText("Logout")).click();
                    Assert.assertTrue(false);
                }
                else
                {
                    Assert.assertTrue(true);
                }
            }
        }



    @DataProvider(name = "LoginData")
    public String[][] getData() {
        String loginData[][] = {
                {"admin@yourstore.com","admin","Valid"},
                {"admin@yourstore.com","adm","Invalid"},
                {"adm@yourstore.com","admin","Invalid"},
                {"adm@yourstore.com","adm","Invalid"}



        };
        return loginData;
    }

    @AfterSuite
    void tearDown()
    {
        driver.quit();
    }
}
