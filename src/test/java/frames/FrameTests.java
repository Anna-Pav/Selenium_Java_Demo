package frames;

import base.BaseTests;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FrameTests extends BaseTests {


    @Test
    public void testWysiwyg() throws InterruptedException {
        var editorPage = homePage.clickWysiwygEditor();
        editorPage.clearTextArea();

        String text1 = "Hello";
        String text2 = "World";

        editorPage.setTextArea(text1);
        editorPage.decreaseIndention();

        editorPage.setTextArea(text2);

        //assertion
       assertEquals(editorPage.getTextFromEditor(),text1 + text2, "text from editor is incorrect");
    }
}
