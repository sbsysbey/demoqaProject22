package demoqa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import demoqa.utilities.Driver;

public class US10_FormPage {
    public US10_FormPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//div[@class='card-up'])[2]")

    public WebElement formSection;

    @FindBy(xpath="//span[.='Practice Form']")
    public WebElement practiseForm;

    @FindBy(xpath="//h5[.='Student Registration Form']")
    public WebElement baslikdogrulama;


    @FindBy(id ="firstName")
    public WebElement firstName;

    @FindBy(id="lastName")
    public WebElement lastName;

    @FindBy(id="userEmail")
    public WebElement userEmail;

    @FindBy(xpath ="//*[ text() ='Male']")
    public WebElement genderRadio1;

    @FindBy(xpath ="//*[ text() ='Female']")
    public WebElement genderRadio2;

    @FindBy(xpath ="//*[ text() ='Other']")
    public WebElement genderRadio3;


    @FindBy(id ="userNumber")
    public WebElement userNumber;

    @FindBy(id ="dateOfBirthInput")
    public WebElement dateOfBirthInput;


    @FindBy(id ="subjectsInput")
       public WebElement subjectsContainer;

    @FindBy(xpath ="//*[ text() ='Sports']")
    public WebElement sportCheckbox1;
    @FindBy(xpath ="//*[ text() ='Reading']")
    public WebElement readingCheckbox2;

    @FindBy(xpath ="//*[ text() ='Music']")
    public WebElement musicCheckbox;

    @FindBy(xpath="//input[@class='form-control-file']")
    public WebElement uploadPicture;


    @FindBy(id ="currentAddress")
    public WebElement currentAddress;

    @FindBy(id = "state")
    public WebElement state;

    @FindBy(id = "react-select-4-input")
    public WebElement city;

    @FindBy(xpath ="( //div[@class=' css-1uccc91-singleValue'])[1]")
    public WebElement stateTik;
    @FindBy(xpath ="( //div[@class=' css-1uccc91-singleValue'])[2]")
    public WebElement cityTik;
    @FindBy (id ="example-modal-sizes-title-lg")
    public WebElement sonucBaslik;




    @FindBy(xpath="//button[@id='submit']")
    public WebElement submit;

    @FindBy(xpath="//*[@class='table table-dark table-striped table-bordered table-hover']/tbody/tr[5]/td[2]")
    public WebElement birtDaySonuc;

    @FindBy(xpath="//*[@class='table table-dark table-striped table-bordered table-hover']/tbody/tr[6]/td[2]")
    public WebElement subjectSonuc;


    @FindBy(xpath="//*[@class='table table-dark table-striped table-bordered table-hover']/tbody/tr[7]/td[2]")
    public WebElement hobbiesSonuc;

    @FindBy(xpath="//*[@class='table table-dark table-striped table-bordered table-hover']/tbody/tr[8]/td[2]")
    public WebElement dosyaSecSonuc;

    @FindBy(xpath="//select[@class='react-datepicker__month-select']")
    public WebElement selectAy;

    @FindBy(xpath="//select[@class='react-datepicker__year-select']")
    public WebElement selectYil;

    @FindBy(xpath="//div[@class='css-12jo7m5 subjects-auto-complete__multi-value__label']")
    public WebElement subjectListe;
}
