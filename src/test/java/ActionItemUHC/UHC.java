package ActionItemUHC;

import ReusableLibrary.ReusableActions;
import okio.Timeout;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class UHC {
    WebDriver driver;

    @BeforeSuite
    public void setupChrome() {
        driver = ReusableActions.setUpDriver();
    }//end of suite

    @AfterSuite
    public void driverClose() {
        //driver.quit();


    }//end of after suite

    @Test(priority = 1)
    public void testCaseOne() throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        //navigate to UHC
        driver.navigate().to("http://www.UHC.com");

        //click on find a doctor
        ReusableActions.clickAction(driver, "//*[text()='Find a doctor']", "findDoctor");
        Thread.sleep(2000);
        //click no on popup if it appears
        ReusableActions.clickAction(driver, "//*[@id='ip-no']", "clickPopUp");
        //scroll into view find a dentist
        Thread.sleep(2000);
        WebElement findDentist = driver.findElement(By.xpath("//*[@aria-label='Find a dentist Opens a new window']"));
        //scroll into view to find a dentist
        ReusableActions.scrollIntoView(driver, "//*[@aria-label='Find a dentist Opens a new window']", 0,"findDentist");
        //jse.executeScript("scroll(0,2000)");
        Thread.sleep(2000);
        //click on find a dentist
        ReusableActions.clickAction(driver, "//*[@aria-label='Find a dentist Opens a new window']", "findDentist");
        //delay
        Thread.sleep(3000);
        //refresh tab
        driver.navigate().refresh();
        //switch to tab 1
        ReusableActions.switchToTabByIndex(driver, 1);
        //click on Employer and individual plans
        ReusableActions.clickAction(driver, "//*[@ng-src='/static/media/icn_united_all-7651bc16.svg']", "Employer");

    } // end of test 1

    @Test(priority = 2)
    public void testCaseTwo() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //enter zipcode in search box
        ReusableActions.sendKeysAction(driver, "//*[@id='location']", "07022", "zipCode");
        //delay
        Thread.sleep(2000);
        //click on continue button
        ReusableActions.clickAction(driver, "//*[@type='submit']", "clickOnLocation");
        //delay
        Thread.sleep(2000);
        //click on nationals PPO
        try {
            driver.findElement(By.xpath("//*[@class='sc-eIUifz jzFBFO']")).click();
            Thread.sleep(3000);
            //refresh tab
        }catch (Exception e) {
            System.out.println("Not clicking on nationals" +e);
        }//end of catch

        driver.navigate().refresh();
        //delay
        Thread.sleep(3000);
        //click on general dentist
        ReusableActions.clickAction(driver, "//*[@class='sc-gSYDnn fslDuO']", "generalDentists");
        Thread.sleep(2000);
        driver.navigate().refresh();



    }//end of test case two

    @Test(priority = 3)
    public void testCaseThree() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //reusable action select method by text
        ReusableActions.selectByText(driver, "//*[@data-test-id='radius-miles-dropdown']", "Within 2 Miles", "selectMiles");
        Thread.sleep(3000);
        //click on doctor
        ReusableActions.clickAction(driver, "//*[@data-test-id='provider-name-link']", "doctorName");
        //click on save
        ReusableActions.clickAction(driver, "//*[text()='Save']", "save");

        //getting text for location miles and in network
        String addressValue = ReusableActions.getTextAction(driver, "//*[@class='btn-label-wrapper']", "address");
        String milesValue = ReusableActions.getTextAction(driver, "//*[@data-test-id='distance-away']", "miles");
        String networkValue = ReusableActions.getTextAction(driver, "//*[@value='::location.inNetwork']", "network");
        System.out.println("Address: " +addressValue + "Miles: " + milesValue + "Network: " + networkValue);
        //close tab
        driver.close();
    }//end of test 3

    @Test(priority = 4)
    public void testCaseFour() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        ReusableActions.switchToTabByIndex(driver,0);
        ReusableActions.sendKeysAction(driver, "//*[@id='search-desktop']","doctor","searchBar");
        ReusableActions.submitAction(driver, "//*[@id='search-desktop']", "submitSearchBar");
        String searchResult = ReusableActions.getTextAction(driver, "//*[@id='search-results-count__header']", "searchNumbers");
        String[] splitSearch = searchResult.split(" ");
        System.out.println(splitSearch[0] + splitSearch[1] + splitSearch[2]);

    }
}//end of main class







