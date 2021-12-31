package demoqa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import demoqa.utilities.Driver;

public class US11_AlertsFramePage {
    public US11_AlertsFramePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//div[@class='card-up'])[3]")
    public WebElement alertSection;


    @FindBy(xpath ="//span[.='Browser Windows']")
    public WebElement browserWindowsSekmesi;

    @FindBy(xpath ="//span[.='Frames']")
    public WebElement framesSekmesi;

    @FindBy(xpath ="//span[.='Nested Frames']")
    public WebElement nestedFramesSekmesi;

    @FindBy(xpath ="//span[.='Modal Dialogs']")
    public WebElement ModalDialogSekmesi;

    @FindBy(id ="tabButton")
    public WebElement tabButton;

    @FindBy(id ="windowButton")
    public WebElement windowButton;

    @FindBy(id ="messageWindowButton")
    public WebElement messageWindowButton;



    @FindBy(id ="sampleHeading")
    public WebElement newTabText;
    @FindBy(xpath ="//span[.='Alerts']")
    public WebElement Alertssekmesi;
    @FindBy(xpath ="(//button[@class='btn btn-primary'])[1]")
    public WebElement alertbirinciclikcme;
    @FindBy(xpath ="(//button[@class='btn btn-primary'])[2]")
    public WebElement alertikinciclickme;

    @FindBy(xpath ="(//button[@class='btn btn-primary'])[3]")
    public WebElement alertucuncuclikcme;

    @FindBy(xpath ="(//button[@class='btn btn-primary'])[4]")
    public WebElement alertdorduncuclickme;

    @FindBy(id ="confirmResult")
    public WebElement sonucYazisi;

    @FindBy(id ="promptResult")
    public WebElement promptResult;

    @FindBy(tagName ="body")
    public WebElement messagText;

    @FindBy(id ="showLargeModal")
    public WebElement showLargeModal;

    @FindBy(id ="showSmallModal")
    public WebElement showSmallModal;

    @FindBy(id ="closeSmallModal")
    public WebElement closeSmallModal;

    @FindBy(id ="closeLargeModal")
    public WebElement closeLargeModal;

    @FindBy(id ="example-modal-sizes-title-lg")
    public WebElement largeModalBaslik;

    @FindBy(id ="example-modal-sizes-title-sm")
    public WebElement smallModalBaslik;

    @FindBy(xpath = "//div[@class='modal-body']")
    public WebElement small_LargeModaltext;
}
