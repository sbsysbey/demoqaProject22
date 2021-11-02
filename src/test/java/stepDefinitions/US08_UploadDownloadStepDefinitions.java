package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;
import pages.US07_BrokenLinksPage;
import pages.US08_UploadDownloadPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class US08_UploadDownloadStepDefinitions {

    US08_UploadDownloadPage uploadDownloadPage = new US08_UploadDownloadPage();
    Actions actions = new Actions(Driver.getDriver());
    SoftAssert softAssert=new SoftAssert();






    @And("UploandandDownland butonuna tiklayiniz")
    public void uploandanddownlandButonunaTiklayiniz() {
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
        uploadDownloadPage.uploadButonu.click();
    }

    @Given("choosefile btonunu seciniz")
    public void choosefileBtonunuSeciniz() {
        WebElement upload_file = uploadDownloadPage.dosyaSec;
        upload_file.sendKeys("C:/Users/MRN/Pictures/mesaj.png");
      //  uploadDownloadPage.dosyaSec.click();
    }



    @Given("sectigimiz dosyanin gorunurlugunu dogrulayiniz")
    public void sectigimizDosyaninGorunurlugunuDogrulayiniz() {
        System.out.println(uploadDownloadPage.dosyaSecdogrula.getText());

    }

    @Given("bir dosya indiriniz")
    public void birDosyaIndiriniz() {
        uploadDownloadPage.downLoad.click();
    }
    @Given("dosyaninin indriildigini dogrulayiniz")
    public void dosyanininIndriildiginiDogrulayiniz() {
    }

    @Given("Dowland butonuna tiklayiniz")
    public void dowlandButonunaTiklayiniz() {
    }

    @Given("indirilen dosyayi gorunurlugunu dogrulayiniz")
    public void indirilenDosyayiGorunurlugunuDogrulayiniz() {
    }
}
