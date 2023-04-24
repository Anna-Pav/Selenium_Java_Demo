package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.SplittableRandom;

public class WysiwygEditorPage {

    private WebDriver driver;
    private String editorIframeId = "mce_0_ifr";
    private By textArea = By.id("tinymce");
    private By decreaseIndentButton = By.cssSelector("button[title='Increase indent'] > .tox-icon.tox-tbtn__icon-wrap > svg");

    public WysiwygEditorPage(WebDriver driver){
        this.driver = driver;
    }

    //it is good practice to exit the iFrame DOM after we are done with our interactions

    public void clearTextArea(){
        switchToEditArea(); //switch to the iFrame
        driver.findElement(textArea).clear(); //clear the text in the iFrame
        switchToMainArea(); // switch back to the webpage DOM
    }

    //method to enter text
    public void setTextArea(String text){
        switchToEditArea(); //switch to the iFrame
        driver.findElement(textArea).sendKeys(text); //clear the text in the iFrame
        switchToMainArea(); // switch back to the webpage DOM
    }

    //method to read the text we entered so we can confirm it
    public String getTextFromEditor(){
        switchToEditArea();
        String text = driver.findElement(textArea).getText();
        switchToMainArea();
        return text;
    }


    public void decreaseIndention() throws InterruptedException {
        //the button is not part of the iFrame DOM so no need to switch here
        driver.findElement(decreaseIndentButton).click();
    }

    //method to enter the iFrame area
    private void switchToEditArea(){
        //this will switch the context from the webpage DOM to the iFrame DOM
        //it is necessary in order to interact with the elements inside the frame
        //once inside the iFrame DOM the only things we can access are the
        //elements within the <html> of the iFrame.
        driver.switchTo().frame(editorIframeId);
    }

    //method to exit the iFrame area
    private void switchToMainArea(){
        //parentFrame = webpage DOM
        driver.switchTo().parentFrame();
    }
}
 /*
 An inline frame (iframe) is an HTML element that loads another HTML page within the document.
 It essentially puts another webpage within the parent page.
 They are commonly used for advertisements, embedded videos, web analytics and interactive content.
  */