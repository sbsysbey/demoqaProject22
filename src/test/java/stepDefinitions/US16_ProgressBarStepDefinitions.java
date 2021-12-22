package stepDefinitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.testng.asserts.SoftAssert;
import pages.US16_SlidersPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class US16_ProgressBarStepDefinitions {


    US16_SlidersPage progressBar=new US16_SlidersPage();
Actions actions=new Actions(Driver.getDriver());


    @Given("Kullanici progressbar butonunu tiklar")
    public void kullanici_progressbar_butonunu_tiklar() {
      actions.sendKeys(Keys.PAGE_DOWN).perform();
      progressBar.progressBar.click();
    }

    @Then("Kullanici start ikonuna basildiginda veri islendigini dogrular")
    public void kullanici_start_ikonuna_basildiginda_veri_islendigini_dogrular() {
        ReusableMethods.waitFor(1);
progressBar.startStopButton.click();
        Assert.assertFalse(progressBar.progressBarPercent.getAttribute("aria-valuenow").equals(0));
    }

    @Then("Kullanici veri islemeye basladiginda stop dugmesi ciktigini dogrular")
    public void kullanici_veri_islemeye_basladiginda_stop_dugmesi_ciktigini_dogrular() {
       Assert.assertTrue(progressBar.startStopButton.getText().contains("Stop"));

    }

    @Then("Kullanici veri islemi bittiginde cizginin yesile donmesi ve %{int} yazisi reset yazisinin oldugunu dogrular")
    public void kullaniciVeriIslemiBittigindeCizgininYesileDonmesiVeYazisiResetYazisininOldugunuDogrular(int arg0) {
       ReusableMethods.waitForClickablility(progressBar.progressBarSuccess,15);
    String color=progressBar.progressBarSuccess.getCssValue("background-color");
    String colorHex= Color.fromString(color).asHex();
        System.out.println(colorHex);
        SoftAssert softAssert=new SoftAssert();

        softAssert.assertEquals(colorHex,"#28a745");

        softAssert.assertTrue(progressBar.progressBarSuccess.getAttribute("aria-valuenow").equals("100"));
        softAssert.assertTrue(progressBar.resetButton.getText().equals("Reset"));

        softAssert.assertAll();
    }

    @Then("Kullanici reset butonuna bastiginda tekrar basladigini dogrular")
    public void kullanici_reset_butonuna_bastiginda_tekrar_basladigini_dogrular() {
        progressBar.resetButton.click();
        Assert.assertTrue(progressBar.startStopButton.getText().equals("Start"));

    }










}
