package ActionItemClass_1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;

public class Hotels {
    public static void main(String[] args) throws InterruptedException {

        //setting up driver, adding options
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();

        options.addArguments("Start-Maximized","Incognito");

        WebDriver driver = new ChromeDriver(options);

        //create an arrayList for destinations
        ArrayList<String> destinations = new ArrayList<>();
        destinations.add("New York");
        destinations.add("New Jersey");
        destinations.add("Boston");


        //create an arrayList for adults
        ArrayList<Integer> adults = new ArrayList<>();
        adults.add(2);
        adults.add(3);
        adults.add(4);

        //create an arraylist for children age
        ArrayList<String> cAge = new ArrayList<>();
        cAge.add("3");
        cAge.add("4");
        cAge.add("5");

        //for loop to iterate through destinations
        for(int i = 0; i < destinations.size(); i++){

            //navigate to website
            driver.navigate().to("http://www.hotels.com");

            try {
                //click on search bar
                driver.findElement(By.xpath("//*[@class='uitk-fake-input uitk-form-field-trigger']")).click();
                //enter keys in search bar using web element
                WebElement searchBar = driver.findElement(By.xpath("//*[@id='destination_form_field']"));
                searchBar.sendKeys(destinations.get(i));
                //delay
                Thread.sleep(2000);
                searchBar.sendKeys(Keys.ENTER);
                //clicking on Travelers
                driver.findElement(By.xpath("//*[@class='uitk-menu-trigger uitk-fake-input uitk-form-field-trigger']")).click();
            } catch (Exception e) { System.out.println("Keys were not able to be sent" +e); } //end of catch
            //creating arrayList for plus minus function on adults and children
            ArrayList<WebElement> plusMinus = new ArrayList<>(driver.findElements(By.xpath("//*[@class='uitk-step-input-button']")));
            //setting adult to 1
            plusMinus.get(0).click();


            for(int j = 1; j < adults.get(i); j++){
                plusMinus.get(1).click();
            }//end of adult nested loop

            //sets children to 1
            plusMinus.get(3).click();

            try {
                //select method for child age
                WebElement childAge = driver.findElement(By.xpath("//*[@id='age-traveler_selector_children_age_selector-0-0']"));
                Select childDropDown = new Select(childAge);
                //using select method for each iteration of cAge
                childDropDown.selectByValue(cAge.get(i));
                //delay
                Thread.sleep(2000);
                //click on done
                driver.findElement(By.xpath("//*[text()='Done']")).click();
                //delay
                Thread.sleep(2000);
                //click on search
                driver.findElement(By.xpath("//*[@class='uitk-icon uitk-icon-leading uitk-icon-medium']")).click();
                Thread.sleep(2000);
            } catch (Exception e){ System.out.println("Child age was not able to be selected" +e); } //end of catch
            //creating arrayList for resort links
            ArrayList<WebElement> links = new ArrayList<>(driver.findElements(By.xpath("//*[@class='uitk-card-link']")));

            if(i == 0){
                links.get(1).click();
            }else if(i == 1){
                links.get(3).click();
            }else if(i == 2){
                links.get(2).click();
            }//end of conditional statements


            //ArrayList for window tabs
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));

            try {
                //capturing name of resort into a string
                String resort = driver.findElement(By.xpath("//*[@class='uitk-heading uitk-heading-3']")).getText();
                //print out hotel name
                System.out.println("Name of resort: " + resort);
                Thread.sleep(2000);
                //click on reserve room
                driver.findElement(By.xpath("//*[text()='Reserve a room']")).click();
                //capturing price into string
                String price = driver.findElement(By.xpath("//*[@class='uitk-text uitk-type-600 uitk-type-bold uitk-text-emphasis-theme']")).getText();
                System.out.println("Cost of resort: " + price);
            } catch (Exception e) { System.out.println("hotel name and price were not able to be printed" +e); } //end of catch

            Thread.sleep(3000);


            try {
                //click on reserve
                driver.findElement(By.xpath("//*//*[@class='uitk-button uitk-button-medium uitk-button-primary']")).click();

                Thread.sleep(3000);

                String timeTable = driver.findElement(By.xpath("//*[@class='travel-details w-full table-bc-s ph-base mt-mouse mb-tiny']")).getText();
                System.out.println("Check in & Check out times are: " + timeTable);
            } catch (Exception e) { System.out.println("Time table was not able to be printed" +e); } // end of catch

            //close current window, switch to parent window, delay, end of loop, quit driver.
            driver.close();
            driver.switchTo().window(tabs.get(0));
            Thread.sleep(3000);
        }//end of loop
        driver.quit();
    }//end of main
}//end of class
