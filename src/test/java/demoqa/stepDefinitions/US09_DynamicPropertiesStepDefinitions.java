package demoqa.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.testng.asserts.SoftAssert;
import demoqa.pages.US09_DynamicPropertiesPage;
import demoqa.utilities.Driver;
import demoqa.utilities.ReusableMethods;

public class US09_DynamicPropertiesStepDefinitions {
    US09_DynamicPropertiesPage dynamicPropertiesPage = new US09_DynamicPropertiesPage();
    Actions actions = new Actions(Driver.getDriver());
    SoftAssert softAssert=new SoftAssert();





    @And("DynamicProperties butonuna tiklayiniz")
    public void dynamicpropertiesButonunaTiklayiniz() {
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
        dynamicPropertiesPage.dynamicPropertiesButonu.click();


    }

    @Then("Wil enable besseconds isimli buton sayfa acildiginda Disabled oldugunu  dogrulayin")
    public void wilEnableBessecondsIsimliButonSayfaAcildigindaDisabledOldugunuDogrulayin() {
        Assert.assertFalse(dynamicPropertiesPage.enableAfter.isEnabled());

    }

    @Then("bes sn sonra Enabled oldugunu dogrulayin")
    public void besSnSonraEnabledOldugunuDogrulayin() {

        ReusableMethods.waitForClickablility(dynamicPropertiesPage.enableAfter,5);
        Assert.assertTrue(dynamicPropertiesPage.enableAfter.isEnabled());

    }

    @Then("This text has random Id isimli Text Box sayfa her yenilendiginde farkli bir ID value'sune sahip oldugunu dogrulayin")
    public void thisTextHasRandomIdIsimliTextBoxSayfaHerYenilendigindeFarkliBirIDValueSuneSahipOldugunuDogrulayin() {




    }

    @Then("Color Change isimli butonun yazi renginin sayfa yuklendiginde {string} ve bes sn sonra {string} oldugunu dogrulayin")
    public void colorChangeIsimliButonunYaziRengininSayfaYuklendigindeVeBesSnSonraOldugunuDogrulayin(String arg0, String arg1) {

            String color1=dynamicPropertiesPage.colorchange.getCssValue("color");
            System.out.println(color1);

           String colorHex = Color.fromString(color1).asHex();
            System.out.println(colorHex);
           Assert.assertEquals(colorHex,"#ffffff");
            ReusableMethods.waitFor(6);
            String color2 = dynamicPropertiesPage.colorchange.getCssValue("color");
            System.out.println(color2);
            String colorHex2 = Color.fromString(color2).asHex();
            System.out.println(colorHex2);
            Assert.assertEquals(colorHex2, "#dc3545");



    }

    @Then("Visible After bes Seconds isimli butonun sayfa yuklendiginde goruntulenemez oldugunu")
    public void visibleAfterBesSecondsIsimliButonunSayfaYuklendigindeGoruntulenemezOldugunu() {
        Assert.assertTrue("yanlıs",dynamicPropertiesPage.visibleAfter.isDisplayed());
    }

    @Then("ve bes sn sonra goruntulenebilir oldugunu dogrulayin")
    public void veBesSnSonraGoruntulenebilirOldugunuDogrulayin() {
        ReusableMethods.waitForVisibility(dynamicPropertiesPage.visibleAfter,5);

        Assert.assertTrue(dynamicPropertiesPage.visibleAfter.isDisplayed());
        System.out.println(dynamicPropertiesPage.visibleAfter.getText());
    }
}
