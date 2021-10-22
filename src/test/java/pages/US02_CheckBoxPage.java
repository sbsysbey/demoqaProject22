package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.ArrayList;
import java.util.List;

public class US02_CheckBoxPage {

    public US02_CheckBoxPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath ="//span[.='Check Box']")
    public WebElement checkBoxMenuLink;



    @FindBy(xpath= "//button[@class='rct-option rct-option-expand-all']")
   public WebElement Checkboxarti;



    @FindBy(xpath= "(//*[@class='rct-icon rct-icon-leaf-close'])")
    public WebElement Checkboxrdogrulama;

    @FindBy(xpath= "//button[@class='rct-option rct-option-collapse-all']")
    public WebElement Checkboxeksi;

    @FindBy(xpath= "//button[@class='rct-option rct-option-expand-all']")
    public WebElement eksiDogrulama;



    @FindBy(xpath= "//span[text()='Excel File.doc']")
    public WebElement excelFile;


    @FindBy(xpath= "//span[@class='text-success']")
    public WebElement succeskontrol;



}
