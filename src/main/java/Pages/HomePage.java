package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    //Page object model
    //fields and methods of the home page
    //every different page on the website gets its own class

    private WebDriver driver;
    //private By formAuthenticationLink = By.linkText("Form Authentication");

    //make constructor that says we must pass the webdriver
    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    //if your action changes the page then you should return a handle to that page (see our method has LoginPage class name)
    //so here we should return a login page object
    //basically this method points to the LoginPage class
    public LoginPage clickFormAuth () {
        //driver.findElement(formAuthenticationLink).click();
        clickLink("formAuthenticationLink"); //calling the generic clickLink method instead

        return new LoginPage(driver);
    }

    public DropdownPage clickDropDown(){
        clickLink("Dropdown");
        return new DropdownPage(driver); //once dropdown link in Home Page is clicked it will point to the new page.
    }

    //method for clicking the hovers link in home page
    public HoversPage clickHovers(){
        clickLink("Hovers");
        return new HoversPage(driver);
    }

    //method for pressing special keys in an input field
    public KeyPressesPage clickKeyPresses(){
        clickLink("Key Presses");
        return new KeyPressesPage(driver);
    }

    //method for clicking a link that will return a js alert
    public AlertsPage clickJavaScriptAlerts(){
        clickLink("JavaScript Alerts");
        return new AlertsPage(driver);
    }

    //method for the file upload
    public FileUploadPage clickFileUpload(){
        clickLink("File Upload");
        return new FileUploadPage(driver);
    }

    public WysiwygEditorPage clickWysiwygEditor(){
        clickLink("WYSIWYG Editor");
        return new WysiwygEditorPage(driver);
    }

    public DynamicLoadingPage clickDynamicPage(){
        clickLink("Dynamic Loading");
        return new DynamicLoadingPage(driver);
    }

    public LargeAndDeepDomPage clickLargeAndDeepDom(){
        clickLink("Large & Deep DOM");
        return new LargeAndDeepDomPage(driver);
    }

    //here we want to add another method to click on another link
    //we could add a new private field for the new link but imagine you have 40 links to check!
    //instead we will make a method that will take a parameter of link.
    //So we don't have to repeat field-method for each link
    public void clickLink(String linkText){
        driver.findElement(By.linkText(linkText)).click();
    }
}
