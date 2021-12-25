package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US18_MenuAndSellectMenuPage {
    public US18_MenuAndSellectMenuPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }
    @FindBy(xpath = "(//div[@class='card mt-4 top-card'])[4]")
    public WebElement widgetsCard;
    @FindBy(xpath = "//span[.='Menu']")
    public WebElement menuLink;

    @FindBy(xpath = "//a[.='Main Item 1']")
    public WebElement mainMenu1;

    @FindBy(xpath = "//a[.='Main Item 3']")
    public WebElement mainMenu3;
    @FindBy(xpath = "//a[.='Main Item 2']")
    public WebElement mainMenu2;

    @FindBy(xpath = "(//a[.='Sub Item'])[1]")
    public WebElement Sub_Item1;
    @FindBy(xpath = "(//a[.='Sub Item'])[2]")
    public WebElement Sub_Item2;

    @FindBy(xpath = "//a[.='SUB SUB LIST »']")
    public WebElement SubSubList;

    @FindBy(xpath = "//a[.='Sub Sub Item 1']")
    public WebElement SubSubItem1;
    @FindBy(xpath = "//a[.='Sub Sub Item 2']")
    public WebElement SubSubItem2;
}
