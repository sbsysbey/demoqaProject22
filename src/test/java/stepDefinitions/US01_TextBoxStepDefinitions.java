package stepDefinitions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.US01_TextBoxPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.awt.*;

public class US01_TextBoxStepDefinitions {
    US01_TextBoxPage textBoxPage = new US01_TextBoxPage();
    Actions actions = new Actions(Driver.getDriver());

    @Given("demoqa anasayfaya gidin")
    public void demoqa_anasayfaya_gidin() throws AWTException {
        Driver.getDriver().get(ConfigReader.getProperty("demoqa_url"));
     // Driver.getDriver().manage().window().maximize();
   }

    @Then("elements butonuna basiniz")
    public void elements_butonuna_basiniz() {
        textBoxPage.elementsCard.click();

    }
    @Then("textbox butonuna tiklayiniz")
    public void textbox_butonuna_tiklayiniz() {

       actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
        textBoxPage.textBoxMenuLink.click();
    }

    @Then("Fullname giriniz")
    public void fullname_giriniz() {
        textBoxPage.fullnameTextBox.sendKeys(ConfigReader.getProperty("fullName"));
    }

    @Then("email giriniz")
    public void email_giriniz () {
        textBoxPage.emailTextBox.sendKeys(ConfigReader.getProperty("email"));
    }

    @Then("adres1 giriniz")
    public void adres1_giriniz () {
        textBoxPage.currentAdressTextBox.sendKeys(ConfigReader.getProperty("currentAdress"));
    }
    @Then("adres2 giriniz")
    public void adres2_giriniz () {
        textBoxPage.permanentAddressTextBox.sendKeys(ConfigReader.getProperty("permanentAdress"));
    }
    @Then("submit butonuna tiklayin")
    public void submit_butonuna_tiklayin () {
        actions.sendKeys(Keys.PAGE_DOWN).perform();
       // ReusableMethods.waitFor(1);
        textBoxPage.submitButton.click();
        ReusableMethods.waitFor(1);
    }


    @Then("giris isleminin tamamlandigini dogrulayin")
    public void giris_isleminin_tamamlandigini_dogrulayin () {
        Assert.assertTrue(textBoxPage.formKayit.isDisplayed());

        System.out.println(textBoxPage.formKayit.getText());

        Assert.assertTrue(textBoxPage.formKayit.getText().contains(textBoxPage.fullnameTextBox.getText()));
        Assert.assertTrue(textBoxPage.formKayit.getText().contains(textBoxPage.emailTextBox.getText()));
        Assert.assertTrue(textBoxPage.formKayit.getText().contains(textBoxPage.currentAdressTextBox.getText()));
        Assert.assertTrue(textBoxPage.formKayit.getText().contains(textBoxPage.permanentAddressTextBox.getText()));
    }


    @And("email giriniz {string}")
    public void emailGiriniz(String arg0) {
        textBoxPage.emailTextBox.sendKeys(arg0);
        //ReusableMethods.waitFor(1);

    }

    @And("Name  giriniz {string}")
    public void tenameGiriniz(String arg0) {
        textBoxPage.fullnameTextBox.sendKeys(arg0);
       // ReusableMethods.waitFor(1);

    }

    @And("currentadres giriniz {string}")
    public void currentadresGiriniz(String arg0) {
        textBoxPage.currentAdressTextBox.sendKeys(arg0);
      //  ReusableMethods.waitFor(1);
    }

    @And("PermanentAdres giriniz {string}")
    public void permanentadresGiriniz(String arg0) {
        textBoxPage.permanentAddressTextBox.sendKeys(arg0);
        ReusableMethods.waitFor(1);
    }


    @Then("isim onaylandigini dogrulayiniz {string}")
    public void isimOnaylandiginiDogrulayiniz(String arg0) {
        Assert.assertTrue(textBoxPage.formKayit.getText().contains(arg0));
        System.out.println(textBoxPage.formKayit.getText());
        System.out.println("------------------------------");
    }

    @Then("mail onaylandigini dogrulayiniz {string}")
    public void mailOnaylandiginiDogrulayiniz(String arg0) {
        Assert.assertTrue(textBoxPage.formKayit.getText().contains(arg0));
    }

    @Then("currentadres onaylandigini dogrulayiniz {string}")
    public void currentadresOnaylandiginiDogrulayiniz(String arg0) {
        Assert.assertTrue(textBoxPage.formKayit.getText().contains(arg0));
    }

    @Then("permanentadres onaylandigini dogrulayiniz {string}")
    public void permanentadresOnaylandiginiDogrulayiniz(String arg0) {
        Assert.assertTrue(textBoxPage.formKayit.getText().contains(arg0));
        ReusableMethods.waitFor(2);
    }


    @Then("mail onaylanmadigini dogrulayiniz {string}")
    public void mailOnaylanmadiginiDogrulayiniz(String arg0) {
        actions.sendKeys(Keys.PAGE_UP).perform();

        ReusableMethods.waitFor(3);
        Assert.assertTrue(textBoxPage.mailHata.isDisplayed());
       
        System.out.println(arg0+" girildi fakat  "+textBoxPage.mailHata.getAttribute("value")+" gecerli bir mail degil");

    }


    @Given("slide duzenle")
    public void slideDuzenle() {
        actions.clickAndHold(textBoxPage.emailTextBox).perform();

     ReusableMethods.setSliderBall(textBoxPage.fullnameTextBox,2,5);
    }

    @And("Map olusturmayi duzenle")
    public void mapOlusturmayiDuzenle() {
    }
}
