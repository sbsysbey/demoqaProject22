package demoqa.pages;

import demoqa.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class us20_BookstoreApplication_SigninPage {


    public us20_BookstoreApplication_SigninPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }


    @FindBy(xpath = "//h5[text()='Book Store Application']")
    public WebElement bookStoreApplication;

    @FindBy(xpath = "//span[text()='Login']")
    public WebElement bookStoreLogin;

    @FindBy(id = "login")
    public WebElement loginButton;

    @FindBy(xpath = "//button[text()='New User']")
    public WebElement newUserButton;

    @FindBy(id = "firstname")
    public WebElement firstName;

    @FindBy(id = "lastname")
    public WebElement lastName;

    @FindBy(id = "userName")
    public WebElement userName;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(xpath = "//*[@title='reCAPTCHA']")
    public WebElement captchaIframe;


    @FindBy(xpath = "//span[@role='checkbox']")
    public WebElement notRobotCheckBox;

    @FindBy(xpath = "//button[@id='register']")
    public WebElement registerButton;

    @FindBy(xpath = "//button[@id='gotologin']")
    public WebElement backToLoginButton;


    @FindBy(id = "searchBox")
    public WebElement searchBox;

    @FindBy(id = "submit")
    public WebElement logout;



    @FindBy(id = "gotoStore")
    public WebElement goToBookStore;
    @FindBy(xpath = "//span[text()='Profile']")
    public WebElement Profile;


    @FindBy(xpath = "//div[@class='rt-td']")
    public List<WebElement>  filtrelihepsi;

    @FindBy(xpath = "//div[@class='mt-2 row']/div")
    public List<WebElement>  kitapOzalikleri;

    @FindBy(xpath = "//div[@class='rt-td']/span")
    public List<WebElement>  bosSatirlar;

    @FindBy(xpath = "//div[@class='action-buttons']")
    public List<WebElement> allNameBooks;

    public WebElement getkitap(String kitapismi) {

        return Driver.getDriver().findElement(By.xpath("//span[contains (@id,'"+kitapismi+"')]"));
    }




}
