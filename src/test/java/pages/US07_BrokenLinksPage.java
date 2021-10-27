package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US07_BrokenLinksPage {
    public US07_BrokenLinksPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }



    @FindBy(xpath = "(//li[@id='item-6'])[1]")
    public WebElement brokenLinkButonu;
    @FindBy(xpath = "(//img[@src='/images/Toolsqa.jpg'])[2]")
    public WebElement validImage;
    @FindBy(linkText = "Click Here for Valid Link")
    public WebElement ClicklINK;
    //Click Here for Valid Link
    @FindBy(linkText = "Click Here for Broken Link")
    public WebElement brokenLink;
}
