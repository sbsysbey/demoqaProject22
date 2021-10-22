package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US05_ButtonBoxPage {

    public US05_ButtonBoxPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//li[@id='item-4'])[1]")
    public WebElement button;

    @FindBy(id = "doubleClickBtn")
    public WebElement doubleClickMe;

    @FindBy(id = "rightClickBtn")
    public WebElement rightClickMe;

    @FindBy(xpath= "(//button[@class='btn btn-primary'])[3]")
    public WebElement ClickMe;

    @FindBy(id = "doubleClickMessage")
    public WebElement doubleClickMessage;

    @FindBy(id = "rightClickMessage")
    public WebElement rightClickMessage;

    @FindBy(id = "dynamicClickMessage")
    public WebElement dynamicClickMessage;

    @FindBy(xpath = "//div[@class='main-header']")
    public WebElement yaziButton;


}
