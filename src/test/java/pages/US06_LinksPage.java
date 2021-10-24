package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US06_LinksPage {
    public US06_LinksPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }




    @FindBy(xpath ="//span[.='Links']")
    public WebElement lineMenuLink;
    @FindBy(id ="simpleLink")
    public WebElement linkHome;

    @FindBy(xpath ="//.mg[@class='banner-image']")
    public WebElement anasayfa;



}


