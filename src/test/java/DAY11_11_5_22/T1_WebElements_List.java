package DAY11_11_5_22;

import ReusableLibrary.ReusableActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class T1_WebElements_List {

    WebDriver driver;
    ArrayList<WebElement> totalMenuHeaders, mainMenuHeaders;

    @BeforeSuite
    public void SetChromeDriver() {
        driver = ReusableActions.setUpDriver();
        //navigate to usps.com home page
        driver.navigate().to("https://www.usps.com/");
        //store all the elements of the menu header into an arraylist of webelements
        totalMenuHeaders = new ArrayList<>(driver.findElements(By.xpath("//*[@class = 'nav-list']/li")));
    }//end of set driver method

    @AfterSuite
    public void quitTheSession() {
        driver.quit();
    }//end of after suite


    //Test Case 1 should verify total count of displayed headers

    @Test(priority = 1)
    public void tc01_getAmountOfHeaders() {

        System.out.println("total amount of menu headers: " + totalMenuHeaders.size());
    }//end of test one

    @Test(priority = 2)
    public void tc02_clickOnTab() {
        totalMenuHeaders.get(0).click();
    }//end of test two

    @Test(priority = 3)
    public void tc03_getAmountOfHeaders() {
        mainMenuHeaders = new ArrayList<>(driver.findElements(By.xpath("//*[@class='menuheader']")));
        System.out.println("Amount of headers is: " + mainMenuHeaders.size());
    }//end of test three

}//end of class
