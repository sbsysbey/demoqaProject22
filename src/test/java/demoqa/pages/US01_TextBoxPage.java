package demoqa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import demoqa.utilities.Driver;

public class US01_TextBoxPage {


    public US01_TextBoxPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div[@class='card-up']")

    public WebElement elementsCard;

    @FindBy(xpath = "(//span[@class='pr-1'])[1]")
    public WebElement elementsMenu;


    @FindBy(xpath ="//span[.='Text Box']")
    public WebElement textBoxMenuLink;

    @FindBy(xpath = "//div[@class='main-header']")
    public WebElement textBoxHeader;

    @FindBy(id = "userForm")
    public WebElement userForm;

    @FindBy(id = "userName")
    public WebElement fullnameTextBox;

    @FindBy(xpath = "//input[@id='userEmail']")
    public WebElement emailTextBox;

    @FindBy(id = "currentAddress")
    public WebElement currentAdressTextBox;
    @FindBy(id = "permanentAddress")
    public WebElement permanentAddressTextBox;

    @FindBy(xpath="//button[@class='btn btn-primary']")
    public WebElement submitButton;

    @FindBy(xpath = "//div[@class='border col-md-12 col-sm-12']")
    public WebElement formKayit;

    @FindBy(xpath = "//input[@class='mr-sm-2 field-error form-control']")
    public WebElement mailHata;

}