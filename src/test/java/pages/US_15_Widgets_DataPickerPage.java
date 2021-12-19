package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class US_15_Widgets_DataPickerPage {
    public US_15_Widgets_DataPickerPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

}
