package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US_15_Widgets_DataPickerPage {
    public US_15_Widgets_DataPickerPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

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

}
