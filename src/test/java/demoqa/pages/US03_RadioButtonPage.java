package demoqa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import demoqa.utilities.Driver;

public class US03_RadioButtonPage {


        public US03_RadioButtonPage() {
            PageFactory.initElements(Driver.getDriver(), this);
        }

    @FindBy(xpath ="//span[.='Radio Button']")
    public WebElement radioButtonMenuLink;


    @FindBy(xpath = "(//label[@class='custom-control-label'])[1]")
    public WebElement yes;

    @FindBy(xpath = "//span[@class='text-success']")
    public WebElement yesYaziyiDogrulama;

    @FindBy(xpath = "(//label[@class='custom-control-label'])[2]")
    public WebElement impressive;


    @FindBy(xpath = "//input[@class='custom-control-input disabled']")
    public WebElement noButton;

    @FindBy(id="noRadio")
    public WebElement noluButton;




}







