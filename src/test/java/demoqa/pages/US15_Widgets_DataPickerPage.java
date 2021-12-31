package demoqa.pages;

import org.openqa.selenium.support.PageFactory;
import demoqa.utilities.Driver;

public class US15_Widgets_DataPickerPage {
    public US15_Widgets_DataPickerPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

}
