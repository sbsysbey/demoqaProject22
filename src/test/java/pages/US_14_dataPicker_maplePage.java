package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class US_14_dataPicker_maplePage {

    public US_14_dataPicker_maplePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div[contains(@class,'react-datepicker__day') and (contains (@aria-label,'January'))]")
    public List<WebElement> january;

    @FindBy(xpath = "//div[contains(@class,'react-datepicker__day') and (contains (@aria-label,'February'))]")
    public List<WebElement> february;

    @FindBy(xpath = "//div[contains(@class,'react-datepicker__day') and (contains (@aria-label,'March'))]")
    public List<WebElement> march;

    @FindBy(xpath = "//div[contains(@class,'react-datepicker__day') and (contains (@aria-label,'April'))]")
    public List<WebElement> april;

    @FindBy(xpath = "//div[contains(@class,'react-datepicker__day') and (contains (@aria-label,'May'))]")
    public List<WebElement> may;

    @FindBy(xpath = "//div[contains(@class,'react-datepicker__day') and (contains (@aria-label,'June'))]")
    public List<WebElement> june;

    @FindBy(xpath = "//div[contains(@class,'react-datepicker__day') and (contains (@aria-label,'July'))]")
    public List<WebElement> july;

    @FindBy(xpath = "//div[contains(@class,'react-datepicker__day') and (contains (@aria-label,'August'))]")
    public List<WebElement> august;

    @FindBy(xpath = "//div[contains(@class,'react-datepicker__day') and (contains (@aria-label,'September'))]")
    public List<WebElement> september;

    @FindBy(xpath = "//div[contains(@class,'react-datepicker__day') and (contains (@aria-label,'October'))]")
    public List<WebElement> october;

    @FindBy(xpath = "//div[contains(@class,'react-datepicker__day') and (contains (@aria-label,'November'))]")
    public List<WebElement> november;

    @FindBy(xpath = "//div[contains(@class,'react-datepicker__day') and (contains (@aria-label,'December'))]")
    public List<WebElement> december;
    @FindBy(xpath ="//span[.='Date Picker']")
    public WebElement dataPickerSekmesi;


    @FindBy(xpath ="(//div[@class='react-datepicker__input-container'])[1]")
    public WebElement tarihsecme1;
    @FindBy(xpath ="(//div[@class='react-datepicker__input-container'])[2]")
    public WebElement zamansecme2;


    @FindBy(xpath="//select[@class='react-datepicker__month-select']")
    public WebElement selectAy;
    @FindBy(xpath="//div[@class='react-datepicker__month-dropdown-container react-datepicker__month-dropdown-container--select']")
    public WebElement selectSay;


    @FindBy(xpath="(//*[contains(@class,'react-datepicker')])[29]")
    public WebElement dateilkGun;
    @FindBy(id="datePickerMonthYearInput")
    public WebElement tarihsonuc;

    @FindBy(xpath="//select[@class='react-datepicker__year-select']")
    public WebElement selectYil;

    @FindBy(xpath="//div[@class='react-datepicker__month-read-view']")
    public WebElement selectZamanAy;

    @FindBy(xpath="//select[@class='react-datepicker__year-dropdown-container react-datepicker__year-dropdown-container--scroll']")
    public WebElement selectZamanYil;



    @FindBy(xpath = "//div[contains(@class,'react-datepicker__day') and (not(contains (class,'react-datepicker__day--weekend')))]")
    public List<WebElement> days;

public static String gunusecme(int a){
    String sonuc=Driver.getDriver().findElement(By.xpath("(//*[contains(@class,'react-datepicker')])["+a+"]")).getText();
    return sonuc;
}
}