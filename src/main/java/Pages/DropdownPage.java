package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class DropdownPage {

    private WebDriver driver;
    private By dropdown = By.id("dropdown");

    //constructor with driver
    public DropdownPage(WebDriver driver) {
        this.driver = driver;
    }

    // we want to be able to select anything from the dropdown menu. Not just one thing.
    public void selectFromDropdown(String option) {

        //select is not a Java webElement, it's a Java class - we need to add it as dependency (from maven, selenium support)
        //Select built method to select from the dropdown menu
        findDropdownElement().selectByVisibleText(option);
    }

    //method that asserts what we selected
    public List<String> getSelectedOptions(){
        List<WebElement> selectedElements = findDropdownElement().getAllSelectedOptions();

        //lambda expression that collects the elements into a list - instead of old-fashioned looping
        return selectedElements.stream().map(e->e.getText()).collect(Collectors.toList());

        //webElements and other selenium stuff should be contained only within the framework folder, not the test folder.
        //remember selenium is NOT a assertion tool - only an interaction tool
    }

    private Select findDropdownElement(){
        //instead of having: Select dropdownElement = new Select(driver.findElement(dropdown)) in every method
        //we added the new Select object to a method to call it when we need it
        return new Select(driver.findElement(dropdown));
    }
}
