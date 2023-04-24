package alerts;

import Pages.HomePage;
import Pages.HoversPage;
import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AlertsTest extends BaseTests {

    //inherited from the BaseTest class our beforeMethod annotation will send us back to home page before each method runs
    @Test
    public void testAcceptAlert(){
        var alertsPage = homePage.clickJavaScriptAlerts();
        alertsPage.triggerAlert();
        alertsPage.alert_clickToAccept();
        //assertion
        assertEquals (alertsPage.getResult(), "You successfully clicked an alert", "Result text incorret");
    }

    @Test
    public void testGetTextFromAlert(){
        var alertsPage = homePage.clickJavaScriptAlerts();
        alertsPage.triggerConfirm();
        String text = alertsPage.alert_getText(); //get the alert text and save it to assert it in the next step.
        alertsPage.alert_clickToDismiss();
        //assertion
        assertEquals(text, "I am a JS Confirm","Alert text incorrect");
    }

    @Test
    public void testSetInputInAlert(){
        var alertsPage = homePage.clickJavaScriptAlerts();
        alertsPage.triggerPrompt();
        String text = "TAU rocks!";
        alertsPage.alert_setInput(text);
        alertsPage.alert_clickToAccept();
        String result = alertsPage.getResult();
        //assertion
        assertEquals(result, "You entered: TAU rocks!", "text input is incorrect");
    }
}
