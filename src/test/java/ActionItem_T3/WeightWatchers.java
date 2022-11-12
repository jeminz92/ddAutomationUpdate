package ActionItem_T3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class WeightWatchers {
    public static void main(String[] args) throws InterruptedException {
        //declaring main method

        WebDriverManager.chromedriver().setup();
        //declaring webdriver to use chrome
        ChromeOptions options = new ChromeOptions();
        //setting Chrome to have options
        options.addArguments("Start-Maximized","incognito");
        //setting parameters for options, full screen & incognito
        WebDriver driver = new ChromeDriver(options);
        //assigning web driver variable as driver along with allowing chrome driver to use "options"
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        //defining javascript executor

        ArrayList<String> zipCode = new ArrayList<>();
        zipCode.add("07060");
        zipCode.add("11219");
        zipCode.add("10016");




        for(int i = 0; i < zipCode.size(); i++) {

            driver.navigate().to("http://www.weightwatchers.com/us/find-a-workshop");
            //navigates to website
            Thread.sleep(2000);
            //2 second delay
            driver.findElement(By.xpath("//*[text()='Find a Workshop']")).click();
            //click on "find a workshop"
            Thread.sleep(2000);
            //2 second delay
            driver.findElement(By.xpath("//*[@id='location-search']")).clear();
            //clear locator field
            WebElement locator = driver.findElement(By.xpath("//*[@id='location-search']"));
            //assign locator field to variable "locator"
            locator.sendKeys(zipCode.get(i));
            //using web element variable "locator" run arrayList "zipCode"
            Thread.sleep(2000);
            //2 second delay
            WebElement searchClick = driver.findElement(By.xpath("//*[@class='rightArrow-daPRP']"));
            //Arrow to go next after entering zipCode
            searchClick.click();
            //using web element variable "searchClick" click on arrow to go next after entering zipCode
            Thread.sleep(2000);
            //2 second delay
            // WebElement studio = driver.findElement(By.xpath("//*[@class='wrapperLink-2NobU']"));
            //identifying element of studio, belong to more than one, part of a group

            ArrayList<WebElement> link = new ArrayList<>(driver.findElements(By.xpath("//*[@class='wrapperLink-2NobU']")));
            //creating array list for web elements, link as the variable
            //xpath is studio link with common property 10/10

            if (i == 0) {
                link.get(i).click();

            }
            if (i == 1) {
                link.get(i).click();

            }
            if (i == 2) {
                link.get(i).click();

                //print statement
            } // end of conditional statement
            //click on second studio link
            String addressTextOne = driver.findElement(By.xpath("//*[@class='address-2PZwW']")).getText();
            //defining text of element as a string variable
            String[] studioOne = addressTextOne.split("Studio");
            //defining string into a split string variable
            WebElement studioInPersonOne = driver.findElement(By.xpath("//*[@class='title-3o8Pv']"));
            //storing variable as webElement
            jse.executeScript("arguments[0].scrollIntoView(true);",studioInPersonOne );
            //scrolling until in person studio is in view
            Thread.sleep(2000);
            //2 second delay
            String inPersonOne = driver.findElement(By.xpath("//*[@class='workshopSchedule-2foP8']")).getText();
            System.out.println(studioOne[0] + inPersonOne);
            //print statement
        } // end of for loop
        } // end of main
    } // end of class
