package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    //again, each class needs its webdriver field
    private WebDriver driver;

    //for this page we need the username field, the password field and a login button field
    //basically our fields are the elements we need to interact with
    private By usernameField = By.id("username");
    private  By passwordField = By.id("password");

    //css selector for the button - first getting its parent (#login) then getting the button
    private  By loginButton = By.cssSelector("#login button");

    //and its constructor that takes this webdriver
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    //methods to interact with our fields
    //the first two methods return void because they don't take us to another page.

    public void setUsername( String username){
        driver.findElement(usernameField).sendKeys(username);

    }

    public void setPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }

    //this method will take us to a different page, so it needs to return the handle of another class that represents the new page
    public secureAreaPage clickLoginButton(){
        driver.findElement(loginButton).click();
        return new secureAreaPage(driver);

    }
}
