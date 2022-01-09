package demoqa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import demoqa.utilities.Driver;

import java.util.List;

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

    @FindBy(xpath = "//ul[@id='nav']/li")
    public List<WebElement> menuItems;

    @FindBy(xpath = "//div[@class=' css-2613qy-menu']")
    public List<WebElement> selectOptionssecenekler;


    ///////SELECT MENU
    @FindBy(xpath = "//span[.='Select Menu']")
    public WebElement sellectMenuLink;

    @FindBy(id = "withOptGroup")
    public WebElement selectOption;


    @FindBy(xpath = "(//div[@class=' css-1uccc91-singleValue'])[1]")
    public WebElement selectOptionText;


    @FindBy(xpath = "(//div[@class=' css-1wa3eu0-placeholder'])[2]")
    public WebElement sellectTitle;

    @FindBy(xpath = "(//div[@class=' css-1uccc91-singleValue")
    public WebElement sellectTitleText;

    @FindBy(id = "oldSelectMenu")
    public WebElement oldSelectBox;
}
