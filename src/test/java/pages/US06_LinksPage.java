package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US06_LinksPage {
    public US06_LinksPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }




    @FindBy(xpath ="//span[.='Links']")
    public WebElement lineMenuLink;
    @FindBy(id ="simpleLink")
    public WebElement linkHome;

    @FindBy(xpath ="//.mg[@class='banner-image']")
    public WebElement anasayfa;

    @FindBy(id ="dynamicLink")
    public WebElement linkHomeDynamic;

    @FindBy(id ="created")
    public WebElement created;

    @FindBy(id ="no-content")
    public WebElement nocontent;

    @FindBy(id ="moved")
    public WebElement moved;

    @FindBy(id ="bad-request")
    public WebElement badrequest;

    @FindBy(id ="unauthorized")
    public WebElement unauthorized;

    @FindBy(id ="forbidden")
    public WebElement forbidden;

    @FindBy(id ="invalid-url")
    public WebElement notFound;

    @FindBy(id ="linkResponse")
    public WebElement yazi;
    @FindBy(xpath ="//div[@class='pattern-backgound playgound-header']")
    public WebElement linkTitle;


}


