package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US16_SlidersPage {

    public US16_SlidersPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }
    @FindBy(xpath = "(//div[@class='card mt-4 top-card'])[4]")
    public WebElement widgetsCard;
    @FindBy(xpath = "//span[.='Slider']")
    public WebElement sliderLink;
    @FindBy(xpath = "//input[@class='range-slider range-slider--primary']")
    public WebElement sliderBall;
    @FindBy(id = "sliderValue")
    public WebElement sliderValue;
    @FindBy(xpath = "//div[@class='range-slider__tooltip__label']")
    public WebElement sliderValue2;

    //PROGRESS---BAR
    @FindBy(xpath = "//span[.='Progress Bar']")
    public WebElement progressBar;
    @FindBy(xpath = "//button[@id='startStopButton']")
    public WebElement startStopButton;
    @FindBy(xpath = "//div[@class='progress-bar bg-info']")
    public WebElement progressBarPercent;
    @FindBy(xpath = "//button[@id='resetButton']")
    public WebElement resetButton;
    @FindBy(xpath = "//div[@class='progress-bar bg-success']")
    public WebElement progressBarSuccess;



       //TABS
       @FindBy(xpath = "//span[.='Tabs']")
        public WebElement tabsLink;

    @FindBy(xpath = "//a[@id='demo-tab-what']")
    public WebElement tab_What;

    @FindBy(xpath = "//a[@id='demo-tab-origin']")
    public WebElement tab_Origin;

    @FindBy(xpath = "//a[@id='demo-tab-use']")
    public WebElement tab_Use;

    @FindBy(xpath = "//a[@id='demo-tab-more']")
    public WebElement tab_More;

    @FindBy(xpath = "//div[@class='fade tab-pane active show']")
    public WebElement activeTab;

    @FindBy(css = "#demo-tabpane-what")
    public WebElement whatTabText;

    @FindBy(css= "#demo-tabpane-origin")
    public WebElement originTabText;

    @FindBy(css = "#demo-tabpane-use")
    public WebElement useTabText;




    //TABS----
    @FindBy(xpath = "//span[.='Tabs']")
    public WebElement tabs;
    @FindBy(id = "demo-tab-what")
    public WebElement whatTab;
    @FindBy(css= "#demo-tabpane-what")
    public WebElement whatText;
    @FindBy(css = "#demo-tabpane-origin")
    public WebElement originText;
    @FindBy(css = "#demo-tabpane-use")
    public WebElement useText;
    @FindBy(id = "demo-tab-origin")
    public WebElement originTab;
    @FindBy(id = "demo-tab-use")
    public WebElement useTab;
    @FindBy(id = "demo-tab-more")
    public WebElement moreTab;




        ///// TOOL
        @FindBy(xpath = "//span[.='Tool Tips']")
        public WebElement toolTips;

    @FindBy(id = "toolTipButton")
    public WebElement hoverButton;

    @FindBy(css = ".tooltip-inner")
    public WebElement gorunurText;

}
