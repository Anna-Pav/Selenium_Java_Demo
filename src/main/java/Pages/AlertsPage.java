package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertsPage {

    private WebDriver driver;
    private By triggerAlertButton = By.xpath(".//button[text()='Click for JS Alert']");
    private By TriggerConfirmButton = By.xpath(".//button[text()='Click for JS Confirm']");
    private By results = By.id("result");
    private By TriggerPromptButton = By.xpath(".//button[text()='Click for JS Prompt']");


    public AlertsPage(WebDriver driver){
        this.driver = driver;
    }

    //method to click the triggerButton - first click element on the page
    public void triggerAlert(){
        driver.findElement(triggerAlertButton).click();
    }

    //method to click the second element on the page with a confirm alert
    public void triggerConfirm(){
        driver.findElement(TriggerConfirmButton).click();
    }

    //method to click the third element on the page with a prompt alert
    public void triggerPrompt(){
        driver.findElement(TriggerPromptButton).click();
    }

    //method to click the "ok" in the alert message
    public void alert_clickToAccept(){
        //we can't use driver.findElement for this cause alert is not a WebElement, it's js function.
        //for this we use the switchTo method. This method will switch from the current context of the DOM, to something else.
        driver.switchTo().alert().accept();
    }

    public void alert_clickToDismiss(){
        //the dismiss method will click on th "cancel" link on the alert message.
        driver.switchTo().alert().dismiss();
    }

    public String alert_getText(){
        return driver.switchTo().alert().getText();
    }

    //method to enter text in the prompt alert
    public void alert_setInput(String text){
         driver.switchTo().alert().sendKeys(text);
    }

    //method to get the result text when the trigger button is clicked
    public String getResult(){
        return driver.findElement(results).getText();
    }
}
