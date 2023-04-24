package login;

import Pages.LoginPage;
import Pages.secureAreaPage;
import base.BaseTests;
import org.openqa.selenium.bidi.log.Log;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class loginTests extends BaseTests {
    //the class extends the BaseTests cause that's where we set up our webdriver
    //we don't want to set up the driver everytime for every class. So we just need to extend it.

    //good practice - start or end test methods names with "test"

    @Test
    public void testSuccessfulLogin(){

        //calling the loginPage handle from the homePage class - remember: LoginPage is the TYPE of the method here. Much like void or String.
        // "loginPage" is just the name of the variable in which we saved the clickForAuth method calling

        LoginPage loginPage = homePage.clickFormAuth(); //you click the link and it takes you to LoginPage
        loginPage.setUsername("tomsmith");
        loginPage.setPassword("SuperSecretPassword!");
        secureAreaPage secureareapage = loginPage.clickLoginButton(); //you click the button and it takes you to the secureAreaPage

        //to test this we need to use some kind of verification/assertion - Selenium is not a verification tool
        //TestNG and Junit are verification tools that we need to add their maven dependencies (for whichever we choose)
        assertTrue(secureareapage.getAlertText().contains("You logged into a secure area!"), "Alert text failed!");



    }
}
