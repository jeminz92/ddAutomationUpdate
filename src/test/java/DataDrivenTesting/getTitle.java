package DataDrivenTesting;

import Reusable_Library.Reusable_Annotations;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class getTitle extends Reusable_Annotations {
    @Test
    public void getTitle(){
        driver.get("https://admin-demo.nopcommerce.com/login");
        driver.findElement(By.xpath("//*[@class=\"button-1 login-button\"]")).click(); // loginButton
      String actualTitle = driver.getTitle();
        System.out.println(actualTitle);
    }
}
