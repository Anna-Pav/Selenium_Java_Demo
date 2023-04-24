package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class KeyPressesPage {

    private WebDriver driver;
    //locator to get the input field
    private By inputField = By.id("target");
    //locator to get the text confirmation that appears after we enter text in the input field
    private By resultText = By.id("result");
    //constructor
    public KeyPressesPage(WebDriver driver){
        this.driver = driver;
    }

    //method to enter text in the input field
    public void enterText(String text){
        driver.findElement(inputField).sendKeys(text);
    }

    //method to enter specific input - in this example "Pi" - calling the enterText method to do so of course
    public void enterPi(){
        enterText(Keys.chord(Keys.ALT, "p") + "=3.14"); //this types Pi and then "-3.14"
    }

    //method to get the text that appears after we enter text in the input field
    public String getResult(){
        String result = driver.findElement(resultText).getText();
        return result;
    }


}
