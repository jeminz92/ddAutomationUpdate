package DAY13_11_12_22;

import Reusable_Library.Reusable_Annotations;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

public class T2_StringComparison extends Reusable_Annotations {
    @Test(priority = 1)
    public void tc001_verifyYahooPageTitle(){
        //navigate to yahoo home page
        driver.navigate().to("http://www.yahoo.com");
        //define our expected string variable
        String expectedTitle = "Yahoo...";
        //get page title
        String actualTitle = driver.getTitle();
        System.out.println("My actual title is: " + actualTitle);
        System.out.println("My expected title is: " + expectedTitle);
        if(actualTitle.equals(expectedTitle)){
            logger.log(LogStatus.PASS,"Expected Result matches actual result");
        } else {
            logger.log(LogStatus.FAIL,"Expected result does not match actual result");
        }


    }//end of test 1
}//end of class
