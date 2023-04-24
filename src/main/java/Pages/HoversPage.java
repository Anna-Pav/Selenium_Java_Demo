package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HoversPage {
    private WebDriver driver;

    private By figureBox = By.className("figure"); //locating the picture we want to hover over
    private By boxCaption = By.className("figcaption");

    //make constructor that says we must pass the webdriver
    public HoversPage(WebDriver driver){
        this.driver = driver;
    }

    /**
     *@Param user input index starts at 1 - if you want first picture, then enter 1
     */
    public FigureCaption hoverOverFigure(int index){ //the index represents which figure we want to hover over since we have 3 on the page

        WebElement figure = driver.findElements(figureBox).get(index-1); //index-1 because first index is 0 - so if they pass 1 to get first element we make sure it's index 0

        //Actions is Java class for advanced interactions in selenium
        Actions actions = new Actions(driver);  //actions takes a webdriver object
        actions.moveToElement(figure).perform();

        return new FigureCaption(figure.findElement(boxCaption));
    }

    //creating another class for the figure caption when hovering
    public class FigureCaption{
        private WebElement caption;
        private By header = By.tagName("h5"); //grabbing the h5 caption
        private By link = By.tagName("a"); //grabbing the link under the caption
        //constructor
        public FigureCaption(WebElement caption){
            this.caption = caption;
        }

        //method that returns is the caption is displayed when we hover over the figure
        public boolean isCaptionDisplayed(){
            return caption.isDisplayed();
        }

        //method to get the title of the header
        public String getTitle(){
            return caption.findElement(header).getText();
        }

        //method to get the link that appears when we hover over the figure
        public String getLink(){
            return caption.findElement(link).getAttribute("href");
        }

        //method to get the text of the link when we hover over the figure
        public String getLinkText(){
            return caption.findElement(link).getText();
        }
    }
}
