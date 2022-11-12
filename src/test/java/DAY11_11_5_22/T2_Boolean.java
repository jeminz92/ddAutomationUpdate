package DAY11_11_5_22;

import ReusableLibrary.ReusableActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class T2_Boolean {
    WebDriver driver;


    @BeforeSuite
    public void SetChromeDriver() {
        driver = ReusableActions.setUpDriver();
    }//end of set driver method

    @AfterSuite
    public void quitTheSession() {
        driver.quit();
    }//end of after suite

    @Test(priority = 1)
    public void tc1_verifySignedInOptionIsChecked() {
        //first navigate to yahoo
        driver.navigate().to("http://www.Yahoo.com");
        //click on sign in button
        ReusableActions.clickAction(driver, "//*[@class='_yb_1933e']", "Sign in button");
        //we need to verify that the checkbox is checked
        boolean isSignInChecked = driver.findElement(By.xpath("//*[@id='persistent']")).isSelected();
        System.out.println("The box is checked :" + isSignInChecked);
    }//end of test case one

        @Test(priority = 2)
        public void tc1_verifySignedInOptionIsUnchecked() {
            //first navigate to yahoo
            driver.navigate().to("http://www.Yahoo.com");
            //click on sign in button
            ReusableActions.clickAction(driver, "//*[@class='_yb_1933e']", "signedInCheckBox");
            //clicking on checkbox
            ReusableActions.clickAction(driver, "//*[@class='stay-signed-in checkbox-container']", "checkBox");
            //we need to verify that the checkbox is checked
            boolean isSignInUnChecked = driver.findElement(By.xpath("//*[@id='persistent']")).isSelected();
            System.out.println("The box is checked :" + isSignInUnChecked);

        }//end of test case two

    }// end of class
