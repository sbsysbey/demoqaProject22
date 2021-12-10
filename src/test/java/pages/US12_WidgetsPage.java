package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US12_WidgetsPage {
    public US12_WidgetsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//div[@class='card-up'])[4]")
    public WebElement WidgetBolum;

//Accordian
    @FindBy(xpath ="//span[.='Accordian']")
    public WebElement accordianSekmesi;

    @FindBy(xpath ="(//div[@class='card-header'])[1]")
    public WebElement acordian1;

    @FindBy(xpath ="(//div[@class='card-header'])[2]")
    public WebElement acordian2;

    @FindBy(xpath ="(//div[@class='card-header'])[3]")
    public WebElement acordian3;

    @FindBy(xpath = "(//div[@class='card-body'])[1]")
    public WebElement acord1Text;
    @FindBy(xpath = "(//div[@class='card-body'])[2]")
    public WebElement acord2Text;
    @FindBy(xpath = "(//div[@class='card-body'])[3]")
    public WebElement acord3Text;

    @FindBy(xpath = "//div[@class='collapse show']")
    public WebElement collapseShow;

//Auto_Complete

    @FindBy(xpath ="//span[.='Auto Complete']")
    public WebElement Auto_CompleteSekmesi;
    @FindBy(id ="autoCompleteMultipleContainer")
    public WebElement multipleAuto_CompleteInput;

    @FindBy(xpath ="//div[@class='css-12jo7m5 auto-complete__multi-value__label']")
    public WebElement multipleAuto_CompleteInpu;


    @FindBy(xpath ="//div[@class='auto-complete__value-container css-1hwfws3']")
    public WebElement singleCompleteInput;



}
