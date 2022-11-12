package ActionItem_T2;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;


public class AutomationAI_2 {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<String> Hobbies = new ArrayList<>();
        Hobbies.add("Boxing");
        Hobbies.add("Weight lifting");
        Hobbies.add("Hunting");
        Hobbies.add("Basketball");
        //adding arraylist to variable "Hobbies"

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        //setting up Driver&Driver Variable to Chrome Driver

        for(int i = 0; i < Hobbies.size(); i++) {
            //creating for loop and assigning loop to start at 0

            driver.navigate().to("http://www.Bing.com");
            //navigates driver to specified URL
            driver.manage().window().maximize();
            //driver maximizes window
            driver.findElement(By.xpath("//*[@id='sb_form_q']")).sendKeys(Hobbies.get(i));
            //types in first iteration of arraylist in search bar
            driver.findElement(By.xpath("//*[@id='search_icon']")).submit();
            //presses enter to search
            String result = driver.findElement(By.xpath("//*[@id='b_tween']")).getText();
            //assigning result as the variable to call .gettext command
            String[] splitResult = result.split(" ");
            //assigning splitResult as the variable to call result.split
            System.out.println("This search result belongs to: " +Hobbies.get(i) +" is "+ splitResult[0]);
            //prints out specified text, also getting the iteration of Hobbies and result.split as "splitResult"
            //while in a for loop 4x
            Thread.sleep(3000);
            //closes out browser after 3 seconds since in milliseconds
        }//end of for loop
        driver.quit();
        //quits driver after thread.sleep finishes
    }//end of main
}//end of class
