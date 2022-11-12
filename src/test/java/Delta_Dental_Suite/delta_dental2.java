package Delta_Dental_Suite;

import Reusable_Library.ReusableActions_Logger;
import Reusable_Library.Reusable_Annotations;
import org.testng.annotations.Test;

public class delta_dental2 extends Reusable_Annotations {

    @Test(priority = 1)
    public void dd11registerAsDentist() throws InterruptedException {
        driver.navigate().to("http://www.deltadental.com");
        //click on sign in and then create an account
        ReusableActions_Logger.clickAction(driver, "//*[text()='Sign in / Register ']", logger, "clickSignIn");
        ReusableActions_Logger.clickAction(driver, "//*[@href='https://identity.deltadental.com/role_select.jsp?register=true&DView=RegistrationDestination']", logger, "createAnAccount");
        //hover over to 1st option and click, then click on proceed to step 2
        //driver.navigate().refresh();
        //click on first bulletin and then click on proceed to step 2
        ReusableActions_Logger.clickAction(driver, "//*[@value='provider_registration_controller.jsp']", logger, "clickFirstBulletin");
        ReusableActions_Logger.clickAction(driver, "//*[@value='Proceed to step 2']", logger, "clickOnProceed");
        //input keys in all text fields and click on register
        ReusableActions_Logger.sendKeysAction(driver,"//*[@id='input_first_name']","test",logger,"firstName");
        ReusableActions_Logger.sendKeysAction(driver,"//*[@id='input_last_name']","test",logger,"lastName");
        ReusableActions_Logger.sendKeysAction(driver,"//*[@id='input_business_tax_id']","test",logger,"businessTaxId");
        ReusableActions_Logger.sendKeysAction(driver,"//*[@name='BusinessCity']","New Jersey",logger,"businessCity");
        ReusableActions_Logger.sendKeysAction(driver,"//*[@id='input_business_zip']","07022",logger,"businessZipCode");
        ReusableActions_Logger.sendKeysAction(driver,"//*[@id='input_provider_first_name']","test",logger,"dentistFirstName");
        ReusableActions_Logger.sendKeysAction(driver,"//*[@id='input_provider_last_name']","test",logger,"dentistLastName");
        ReusableActions_Logger.sendKeysAction(driver,"//*[@id='input_license_id']","123456789",logger,"licenseId");
        ReusableActions_Logger.selectByText(driver,"//*[@id='select_license_state']","New Jersey", logger,"selectLicenseState");
        ReusableActions_Logger.scrollIntoView(driver,"//*[@value='Register']",0,logger,"register");
        ReusableActions_Logger.clickAction(driver,"//*[@value='Register']",logger,"clickRegister");
        //delay to show that all elements have keys in them
        Thread.sleep(10000);
    }//end of dd11

    @Test(dependsOnMethods = "dd11registerAsDentist")
    public void dd12printDentistFAQ() throws InterruptedException {
        driver.navigate().to("http://www.deltadental.com");
        //mouse action hover over "For Dentists", mouse action click on "Dentist FAQ"
        ReusableActions_Logger.mouseHover(driver,"//*[text()='For dentists']",logger,"hoverOverForDentists");
        ReusableActions_Logger.mouseHoverClick(driver,"//*[@href='/us/en/dentist/dentist-faq.html']",logger,"clickOnDentistFaq");
        Thread.sleep(6000);
        //capturing element into a string to capture text of dentist faq
        String pageText = ReusableActions_Logger.getTextAction(driver,"//*[@id='content-component-wrapper']", logger, "dentistFaqText");
        //print statement
        System.out.println(pageText);
    }//end of dd12

    @Test(dependsOnMethods = "dd12printDentistFAQ")
    public void dd20rootCanalCostBySearch() throws InterruptedException {
        //navigate to delta dental
        driver.navigate().to("http://www.deltadental.com");
        //send keys into search bar and enter
        ReusableActions_Logger.sendKeysAction(driver,"//*[@aria-label='Search the site:']","root canal cost\n", logger, "searchRootCanal");
        //click on root canal cost link
        ReusableActions_Logger.clickAction(driver,"//*[text()='Root canal cost']", logger, "rootCanalLink");
        //capturing elements into a get text action & print statement for all root canal costs
        String frontTooth = ReusableActions_Logger.getTextAction(driver,"//*[@id='content-component-wrapper']/div[4]/div/div[1]/div/div/ol/li[1]",logger,"frontToothPrice");
        String preMolar = ReusableActions_Logger.getTextAction(driver,"//*[@id='content-component-wrapper']/div[4]/div/div[1]/div/div/ol/li[2]",logger,"preMolarPrice");
        String molar = ReusableActions_Logger.getTextAction(driver,"//*[@id='content-component-wrapper']/div[4]/div/div[1]/div/div/ol/li[3]",logger,"molarPrice");
        System.out.println("Price for Front Tooth Root Canal: " + frontTooth);
        System.out.println("Price for Premolar Root Canal: " +preMolar);
        System.out.println("Price for Molar Root Canal: " +molar);
    }//end of dd20
}//end of test suite

