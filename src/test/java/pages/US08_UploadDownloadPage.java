package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US08_UploadDownloadPage {
     public US08_UploadDownloadPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath ="//span[.='Upload and Download']")
     public WebElement uploadButonu;


    @FindBy(xpath ="//input[@id='uploadFile']")
    public WebElement dosyaSec;

    @FindBy(xpath ="//p[@id='uploadedFilePath']")
    public WebElement dosyaSecdogrula;


    @FindBy(xpath ="//*[@id='downloadButton']")
    public WebElement downLoad;











    @FindBy(xpath = "(//li[@id='item-6'])[1]")
    public WebElement brokenLinkButonu;

}
