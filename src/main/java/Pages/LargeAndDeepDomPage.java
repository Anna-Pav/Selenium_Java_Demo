package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LargeAndDeepDomPage {

    private WebDriver driver;
    private By table = By.id("large-table");

    public LargeAndDeepDomPage(WebDriver driver) {
        this.driver = driver;
    }

    //method that uses JS to scroll (Webdriver does not have scrolling tools)
    public void scrollToTable(){
        //create the WebElement to find that table
        WebElement tableElement = driver.findElement(table);
        //In order to utilize the JavascriptExecutor class, we have to cast our driver to JavascriptExecutor
        //We only have 1 argument, so that would be 0.
        String script = "arguments[0].scrollIntoView();";
        //tableElement object will replace arguments[0] with the table element.
        ((JavascriptExecutor)driver).executeScript(script, tableElement);

    }

}
