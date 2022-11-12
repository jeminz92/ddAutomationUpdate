package Reusable_Library;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;

public class Reusable_Annotations {
    public static WebDriver driver;
    public static ExtentReports reports;
    public static ExtentTest logger;
    @BeforeSuite
    public void setTheDriver() {
        driver = ReusableActions.setUpDriver();
        reports = new ExtentReports("C:\\Users\\Jemin\\Desktop\\TRIAGE GALLERY NOTES\\QA-PROJECT\\Triage.Project\\src\\test\\java\\Delta_Dental_Suite\\Delta_Dental_Report.html", true);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
    }//end of before suite

    @BeforeMethod
    public void captureTestName(Method testName) {
    //before every method this method will be called and take the name of your test
        //and it will add your test method name to the HTML report
        logger = reports.startTest(testName.getName());
    }//end of before method

    @AfterMethod
    public void endLogger() {
        reports.endTest(logger);

    }//end of after method

    @AfterSuite
    public void quitTheSession() {
        driver.quit();
        reports.flush();
        //writing back to the report
    }//end of after suite



}//end of class
