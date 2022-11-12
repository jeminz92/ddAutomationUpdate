package Reusable_Library;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.ArrayList;

public class ReusableActions_Logger {
    //reusable method to define and launch web driver

    static int Timeout = 10;

    public static WebDriver setUpDriver() {
        //define the web driver manager setup for chromedriver
        WebDriverManager.chromedriver().setup();
        //initialize chrome options
        ChromeOptions options = new ChromeOptions();
        //add argument to chrome options
        options.addArguments("start-maximized");
        //for mac use "start-fullscreen"
        //options.addArguments("start-fullscreen");
        //if above does not work on mac, then try --kiosk
        //options.addArguments("--kiosk");
        //initialize driver with chrome options
        WebDriver driver = new ChromeDriver(options);
        //setup JavaScript Executor
        return driver;

    }//end of setup driver method

    public static void clickAction(WebDriver driver, String xpath, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            element.click();
            logger.log(LogStatus.PASS,"Able to click on element: " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to click on element: " + elementName + " for reason: " + e);
            logger.log(LogStatus.FAIL,"Unable to click on element: " + elementName);
            getScreenShot(driver,elementName,logger);
        }
    }

    public static void clickActionByIndex(WebDriver driver, String xpath, int index, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath))).get(index).click();
            logger.log(LogStatus.PASS,"Able to click on: " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to click on element: " + elementName + " for reason: " + e);
            logger.log(LogStatus.FAIL,"Unable to click on element: " + elementName);
        }
    }

    public static void mouseHover(WebDriver driver, String xpath, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        //declare mouse actions
        Actions actions = new Actions(driver);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            actions.moveToElement(element).perform();
        } catch (Exception e) {
            System.out.println("Unable to hover to element: " + elementName + " for reason: " + e);
        }
    }

    public static void mouseHoverClick(WebDriver driver, String xpath, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        //declare mouse actions
        Actions actions = new Actions(driver);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            actions.moveToElement(element).click().perform();
        } catch (Exception e) {
            System.out.println("Unable to hover to element: " + elementName + " for reason: " + e);
        }
    }

    public static void sendKeysAction(WebDriver driver, String xpath, String userInput, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            element.sendKeys(userInput);
            logger.log(LogStatus.PASS,"Successfully submit on: " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to send keys to : " + elementName + " for reason: " + e);
            logger.log(LogStatus.FAIL, "Unable to send keys to: " + elementName);
        }// end of catch
    }//end of reusable action

    public static String getTextAction(WebDriver driver, String xpath, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        String textOutput = "";
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            textOutput = element.getText();
            logger.log(LogStatus.PASS, "Able to get text for: " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to get text for : " + elementName + " for reason: " + e);
            logger.log(LogStatus.FAIL, "Unable to get text for: " + elementName);
        }
        return textOutput;



    }
    public static void submitAction(WebDriver driver, String xpath, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver,Timeout);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            element.submit();
            logger.log(LogStatus.PASS,"Able to submit: " +elementName);
        } catch (Exception e) {
            System.out.println("Unable to submit on element: " + elementName + " for reason: " + e);
            logger.log(LogStatus.FAIL,"Unable to submit: " + elementName);
        }
    }//end of submit action

    public static void selectByText(WebDriver driver, String xpath, String visibleText, ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver, Timeout);
        try{
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            Select dropDown = new Select(element);
            dropDown.selectByVisibleText(visibleText);
            logger.log(LogStatus.PASS,"able to get text for: " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to select on element: " + elementName + "for reason" + e);
            logger.log(LogStatus.PASS, "unable to get text for: " + elementName);
        }// end of catch
    }// end of select by text

    public static void switchToTabByIndex(WebDriver driver, int tabIndex , ExtentTest logger){
        //store the tabs in array list
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabIndex));
        logger.log(LogStatus.INFO,"Tabs in Array List");
    }// end of tab switch reusable action

    public static void scrollIntoView(WebDriver driver, String xpath, int scrollIndex, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, Timeout);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        try {
            ArrayList<WebElement> scrollElement = new ArrayList<>(wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath))));
            jse.executeScript("arguments[0].scrollIntoView(true);", scrollElement.get(scrollIndex));
            logger.log(LogStatus.PASS,"Able to scroll to element: " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to scroll by view" + elementName + "reason" + e);
            logger.log(LogStatus.FAIL,"Unable to scroll by view: " + elementName);
        }//end of catch
    }//end of scrollIntoView method

    public static void sendKeysByIndex(WebDriver driver, String xpath, int xpathIndex, String input, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, Timeout);
        try {
            ArrayList<WebElement> sendKeysElement = new ArrayList<>(wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath))));
            sendKeysElement.get(xpathIndex).sendKeys(input);
            logger.log(LogStatus.PASS,"keys sent");
        } catch (Exception e) {
            logger.log(LogStatus.FAIL,"keys not sent");
            e.printStackTrace();
            System.out.println("element can't be found" +elementName);
        }
    }//end of sendKeysByIndex

    public static void getScreenShot(WebDriver driver, String imageName, ExtentTest logger) {
        try {
            String fileName = imageName + ".png";
            String directory = null;
            String snPath = null;
            directory = "src/main/java/HTML_Report/Screenshots/";
            snPath = "Screenshots//";
            File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(sourceFile, new File(directory + fileName));
            //String imgPath = directory + fileName;
            String image = logger.addScreenCapture(snPath + fileName);
            logger.log(LogStatus.FAIL, "", image);
        } catch (Exception e) {
            logger.log(LogStatus.FAIL, "Error Occured while taking SCREENSHOT!!!");
            e.printStackTrace();
        }
    }//end of getScreenshot method

    public static void compareExpectedAndActualText(String expectedText, String actualText, ExtentTest logger) {
        if (actualText.equals(expectedText)) {
            logger.log(LogStatus.PASS, "Expected Text: " + expectedText + " and Actual Text: " + actualText + " match");
        }
        else{
            logger.log(LogStatus.FAIL, "Expected Text: " + expectedText + " and Actual Text: " + actualText + " does not match");
        }
    }//end of compareExpectedAndActualText

}// end of class


