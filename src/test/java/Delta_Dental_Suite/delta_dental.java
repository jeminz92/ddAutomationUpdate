package Delta_Dental_Suite;

import Reusable_Library.ReusableActions;
import Reusable_Library.ReusableActions_Logger;
import Reusable_Library.Reusable_Annotations;
import com.relevantcodes.extentreports.ExtentReports;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class delta_dental extends Reusable_Annotations {




    @Test(priority = 1)
    public void dd02dentistByInsuranceAndSpecialty() throws InterruptedException {
        //navigate to delta dental
        driver.navigate().to("http://deltadental.com");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //delay
        Thread.sleep(2000);
        //click on Member Tools
        ReusableActions_Logger.mouseHover(driver, "//*[text()='Member tools']", logger, "memberTools");
        //delay
        Thread.sleep(2000);
        //click on dentist finder
        ReusableActions.mouseHoverClick(driver, "//*[@href='/us/en/member/find-a-dentist.html']", "dentistFinder");
        //delay
        Thread.sleep(2000);
        //select general dentist on drop down
        ReusableActions_Logger.clickActionByIndex(driver, "//*[@class='selectize-input items full has-options has-items']", 2, logger, "dentistSpecialty");
        ReusableActions_Logger.clickAction(driver, "//*[text()='General Dentist']", logger, "pickingTypeOfDentist");
        Thread.sleep(2000);
        //select delta dental premier insurance
        ReusableActions_Logger.clickActionByIndex(driver, "//*[@class='selectize-input items full has-options has-items']", 2, logger, "insuranceType");
        ReusableActions_Logger.clickAction(driver, "//*[text()='Delta Dental Premier']", logger, "insuranceTypeTest");
        Thread.sleep(2000);
        //click on no for location
        ReusableActions_Logger.clickActionByIndex(driver, "//*[@id='search-location']/div[2]/label[2]", 1, logger, "locationNo");
        Thread.sleep(2000);
        //click on zipCode
        ReusableActions_Logger.clickActionByIndex(driver, "//*[@class='address-fields']", 1, logger, "clickOnZipCode");
        //enter zipCode input into field and enter
        ReusableActions_Logger.sendKeysByIndex(driver, "//*[@id='findDentistAddress']", 1, "07022\n", logger, "zipCode");
        //Lists how many doctors are in a 15 mile radius of 07022
        ArrayList<WebElement> doctorNames = new ArrayList<>(driver.findElements(By.xpath("//*[@class='full-name']")));
        System.out.println("List of all doctors: " + doctorNames.size());
        reports.flush();
    }//end of dd02


    @Test(dependsOnMethods = "dd02dentistByInsuranceAndSpecialty")
    public void dd06checkCostOfTreatment() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //navigate to delta dental
        driver.navigate().to("http://www.deltadental.com");
        Thread.sleep(2000);
        //hover over member tools then click on cost estimator
        ReusableActions_Logger.mouseHover(driver, "//*[text()='Member tools']", logger, "memberTools");
        ReusableActions_Logger.mouseHoverClick(driver, "//*[@href='/us/en/member/cost-estimator.html']", logger, "costEstimator");
        Thread.sleep(2000);
        //click on treatments then select Bleaching
        ReusableActions_Logger.mouseHoverClick(driver, "//*[@id='content-component-wrapper']/div/div/div[1]/div/div[1]/div[1]/div/div[2]/div/form/div[1]/div[1]", logger, "clickOnTreatments");
        ReusableActions_Logger.mouseHoverClick(driver, "//*[text()='Bleaching']", logger, "clickOnTreatments");
        Thread.sleep(5000);
        //send keys 07022 into zipcode input search function
        ReusableActions_Logger.sendKeysByIndex(driver, "//*[@id='ceZipCode']", 1, "07022\n", logger, "zipCode");
        Thread.sleep(5000);
        //scroll to the bottom of the page where "accept" is
        ReusableActions_Logger.scrollIntoView(driver, "//*[@id='ceAcceptTermsCond']", 1, logger, "acceptTab");
        Thread.sleep(2000);
        //click accept
        ReusableActions_Logger.clickActionByIndex(driver, "//*[@id='ceAcceptTermsCond']", 1, logger, "clickAcceptTab");
        //capture cost of treatment into a string variable and print it into a statement
        String cost = ReusableActions.getTextAction(driver, "//*[@class='ce-compared-table']", "treatmentCharges");
        System.out.println(cost);
        Thread.sleep(2000);
    }//end of test dd06

    @Test(dependsOnMethods = "dd06checkCostOfTreatment")
    public void dd06navigateToFaceBookPage() throws InterruptedException {
        //navigate to delta dental
        driver.navigate().to("http://www.deltadental.com");
        Thread.sleep(2000);
        //scroll xpath (facebook icon) into view
        ReusableActions_Logger.scrollIntoView(driver, "//*[@title='facebook']", 0, logger, "facebookIcon");
        Thread.sleep(2000);
        //click on facebook icon
        ReusableActions_Logger.mouseHoverClick(driver, "//*[@title='facebook']", logger, "clickOnFacebookIcon");
        //arrayList for window tabs
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        Thread.sleep(2000);
        //switch to tab 2
        driver.switchTo().window(tabs.get(1));
        //click on contact us
        ReusableActions_Logger.clickAction(driver, "//*[text()='Contact us']", logger, "contactUs");
        Thread.sleep(2000);
        //switch to tab 3
        driver.switchTo().window(tabs.get(2));
        //getting text for contact us info with a string variable through reusable action printing it through print statement
        String printInfo = ReusableActions_Logger.getTextAction(driver, "//*[@class='company-description rte-list']", logger, "contactUsInfo");
        System.out.println("Contact Us Info: " + printInfo);
        Thread.sleep(2000);
    }//end of dd06
}//end of test suite


