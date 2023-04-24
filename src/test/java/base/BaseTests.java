package base;

import Pages.HomePage;
import Utils.WindowManager;
import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class BaseTests {

    //The Test folders contain the actual tests
    //The Pages folder contains the interactions of the driver with the website - there are no tests there or assertions, only interaction.

    private WebDriver driver;

    //providing a handle to the home page
    protected HomePage homePage;

    @BeforeClass
    public void setUp(){
        //get location of the exe webdriver file?
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");

        //instance of the driver
        driver = new ChromeDriver();
        goHome();

        //after we launch the application we instantiate the homepage, passing the driver as well
        homePage = new HomePage(driver);

        //maximises the window after starting the browser
        driver.manage().window().maximize();
    }

    //before every method runs mae sure it is on the homePage
    @BeforeMethod
    public void goHome(){
        driver.get("https://the-internet.herokuapp.com/");
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    //creating a method to give us a handle to the window manager
    public WindowManager getWindowManager(){
        return new WindowManager(driver);
    }

    //call to take screenshots
    @AfterMethod
    public void takeScreenshot(){
        //cast driver to takescreenshot class
        var camera = (TakesScreenshot)driver;
        File screenshot = camera.getScreenshotAs(OutputType.FILE);
        try {
            Files.move(screenshot, new File("resources/screenshots/test.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

// main method is not needed for the above methods to run. TestNG through the before and after annotations will run the methods itself.
}
