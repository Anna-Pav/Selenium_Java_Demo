package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class secureAreaPage {

    //webdriver field
    private WebDriver driver;

    //field to interact with
    private By statusAlert = By.id("flash");

    //constructor
    public secureAreaPage(WebDriver driver){
        this.driver = driver;
    }

    //checking to see if alert test shows up on the page, indicating successful login
    public String getAlertText(){
        return driver.findElement(statusAlert).getText();
    }
}
