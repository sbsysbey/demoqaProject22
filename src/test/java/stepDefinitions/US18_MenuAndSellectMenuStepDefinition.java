package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;
import pages.US18_MenuAndSellectMenuPage;
import utilities.Driver;
import utilities.ReusableMethods;

import javax.swing.*;

public class US18_MenuAndSellectMenuStepDefinition {
    US18_MenuAndSellectMenuPage menuveSelectM = new US18_MenuAndSellectMenuPage();
    Actions actions = new Actions(Driver.getDriver());
    SoftAssert softAssert = new SoftAssert();


    @Given("Kullanici Menu sekmesini tiklar")
    public void kullaniciMenuSekmesiniTiklar() {
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
        menuveSelectM.menuLink.click();
        actions.sendKeys(Keys.PAGE_UP).perform();
        ReusableMethods.waitFor(2);

    }


    @And("Kullanici mouse Mainıtem{int} uzerine getirir")
    public void kullaniciMouseMainıtemUzerineGetirir(int arg0) {
        ReusableMethods.hover(Driver.getDriver().findElement(By.xpath("//a[.='Main Item " + arg0 + "']")));
        ReusableMethods.waitFor(1);
    }

    @Then("Kullanici SubItemlerin gorunmedigini dogrular")
    public void kullaniciSubItemlerinGorunmediginiDogrular() {
        softAssert.assertFalse(menuveSelectM.Sub_Item1.isDisplayed());
        softAssert.assertFalse(menuveSelectM.Sub_Item2.isDisplayed());
        softAssert.assertFalse(menuveSelectM.SubSubList.isDisplayed());
        softAssert.assertAll();
    }

    @Then("Kullanici SubItemlerin gorundugunu dogrular")
    public void kullaniciSubItemlerinGorundugunuDogrular() {
        softAssert.assertTrue(menuveSelectM.Sub_Item1.isDisplayed());
        softAssert.assertTrue(menuveSelectM.Sub_Item2.isDisplayed());
        softAssert.assertAll();
    }

    @And("Kullanici mouse subItem{int} uzerine getirir")
    public void kullaniciMouseSubItemUzerineGetirir(int arg0) {
        if (arg0 == 1) {
            ReusableMethods.hover(menuveSelectM.Sub_Item1);
        } else if (arg0 == 2) {
            ReusableMethods.hover(menuveSelectM.Sub_Item2);

        }
        ReusableMethods.waitFor(1);

    }

    @Then("Kullanici SubSubItemlerin gorunmedigini dogrular")
    public void kullaniciSubSubItemlerinGorunmediginiDogrular() {
        softAssert.assertFalse(menuveSelectM.SubSubItem1.isDisplayed());
        softAssert.assertFalse(menuveSelectM.SubSubItem2.isDisplayed());
        softAssert.assertAll();

    }

    @And("Kullanici mouse subublist uzerine getirir")
    public void kullaniciMouseSubublistUzerineGetirir() {

        ReusableMethods.hover(menuveSelectM.SubSubList);
        ReusableMethods.waitFor(1);
    }

    @Then("Kullanici SubSubItemlerin gorundugunu dogrular")
    public void kullaniciSubSubItemlerinGorundugunuDogrular() {
        softAssert.assertTrue(menuveSelectM.SubSubItem1.isDisplayed());
        softAssert.assertTrue(menuveSelectM.SubSubItem2.isDisplayed());
        softAssert.assertAll();
    }


}
