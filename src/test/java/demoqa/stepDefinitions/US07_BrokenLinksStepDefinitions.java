package demoqa.stepDefinitions;

import demoqa.pages.US07_BrokenLinksPage;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;
import demoqa.utilities.Driver;
import demoqa.utilities.ReusableMethods;

public class US07_BrokenLinksStepDefinitions {
    US07_BrokenLinksPage us07_brokenLinksPage = new US07_BrokenLinksPage();
    Actions actions = new Actions(Driver.getDriver());

    SoftAssert softAssert=new SoftAssert();
    @Then("Broken links butonuna tiklayiniz")
    public void broken_links_butonuna_tiklayiniz() {
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
        us07_brokenLinksPage.brokenLinkButonu.click();
    }
    @Then("valid image gorunurlugunu dogrulayiniz")
    public void valid_image_gorunurlugunu_dogrulayiniz() {
        ReusableMethods.waitFor(1);
        Assert.assertTrue(us07_brokenLinksPage.validImage.isDisplayed());
    }
    @Then("Click Here for Valid Link tiklayiniz")
    public void click_here_for_valid_link_tiklayiniz() {
        ReusableMethods.waitFor(1);
        us07_brokenLinksPage.ClicklINK.click();
    }
    @Then("tikladiktan sonra anasayfaya gittigini dogrulayiniz")
    public void tikladiktan_sonra_anasayfaya_gittigini_dogrulayiniz() {
        String expectedCurrentUrl="https://demoqa.com/";
        String actualCurrentUrl=Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(actualCurrentUrl,expectedCurrentUrl);
        System.out.println(actualCurrentUrl);
        softAssert.assertAll();
    }
    @Then("Click Here for Broken Link tiklayiniz")
    public void click_here_for_broken_link_tiklayiniz() {
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
        us07_brokenLinksPage.brokenLink.click();
    }
    @Then("tikladiktan sonra sayfanin hata kodu verdigini dogrulayiniz")
    public void tikladiktan_sonra_sayfanin_hata_kodu_verdigini_dogrulayiniz() {
        String expectedCurrentUrl="http://the-internet.herokuapp.com/status_codes/500";
        String actualCurrentUrl=Driver.getDriver().getCurrentUrl();
        System.out.println(actualCurrentUrl);
        softAssert.assertEquals(actualCurrentUrl,expectedCurrentUrl);
        softAssert.assertAll();
    }
}