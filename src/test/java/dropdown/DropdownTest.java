package dropdown;

import Pages.DropdownPage;
import Pages.HomePage;
import base.BaseTests;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DropdownTest extends BaseTests {

    @Test
    public void testSelectionOption(){

        DropdownPage dropDownPage = homePage.clickDropDown(); //click link in home page and point to the dropdown page
        dropDownPage.selectFromDropdown("Option 1");  //in the dropdown page select option 1 from menu
        var selectedOption = dropDownPage.getSelectedOptions(); //save selected option to a list

        //now we write assertions
        //we will make two. One to assert there is only one option selected.
        //and one to assert the text of the selection
        assertEquals(selectedOption.size(), 1, "incorrect number of selections");
        assertTrue(selectedOption.contains("Option 1"), "Wrong option selected");
    }
}
