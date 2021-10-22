package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class TrendPage {

    public TrendPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@class='search-bar']")
    public WebElement searcbar;

    @FindBy(xpath = "(//div[@class='image-wrapper'])[1]")
    public WebElement ilkurun;

    @FindBy(xpath = "//span[text()='40']")
    public WebElement ilkurunnumara;

    @FindBy(id = "add-to-basket")
    public WebElement sepet;


    @FindBy(xpath = "//span[@class='badge-count']")
    public WebElement Warenkorb;

}
