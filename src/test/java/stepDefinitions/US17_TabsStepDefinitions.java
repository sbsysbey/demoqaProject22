package stepDefinitions;

import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.US16_SlidersPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class US17_TabsStepDefinitions {
    US16_SlidersPage slidersPage=new US16_SlidersPage();
    Actions actions=new Actions(Driver.getDriver());



    @Given("Kullanici Tabs sekmesini tiklar")
    public void kullaniciTabsSekmesiniTiklar() {
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
        slidersPage.tabsLink.click();
        actions.sendKeys(Keys.PAGE_UP).perform();
    }

    @And("Kullanici Whats tab tiklar")
    public void kullaniciWhatsTabTiklar() {
        slidersPage.tab_What.click();

    }



    @And("Kullanici Origin Tab tiklar")
    public void kullaniciOriginTabTiklar() {
        slidersPage.tab_Origin.click();
    }

    @And("Kullanici Use tab tiklar")
    public void kullaniciUseTabTiklar() {
        slidersPage.tab_Use.click();
    }



    @And("Kullanici More tab tiklar")
    public void kullaniciMoreTabTiklar() {

    }

    @Then("kullanici texti dogrular")
    public void kullaniciTextiDogrular(String teks) {

        System.out.println(ReusableMethods.jsGetInnerText(slidersPage.activeTab));
        Assert.assertTrue(slidersPage.activeTab.getText().contains(teks));

/*
        System.out.println(ReusableMethods.getHexColor(slidersPage.tab_What,"color"));
       if (ReusableMethods.getHexColor(slidersPage.tab_What,"color").equals("#495057")){
        System.out.println(ReusableMethods.jsGetInnerText(slidersPage.whatTabText));
        Assert.assertTrue(slidersPage.whatTabText.getText().contains(teks));

    }else  if (ReusableMethods.getHexColor(slidersPage.tab_Origin,"color").equals("#495057")){
            System.out.println(ReusableMethods.jsGetInnerText(slidersPage.originTabText));
        Assert.assertTrue(slidersPage.originTabText.getText().contains(teks));
     }else if (ReusableMethods.getHexColor(slidersPage.tab_Use,"color").equals("#495057")){
            System.out.println(ReusableMethods.jsGetInnerText(slidersPage.useTabText));
        Assert.assertTrue(slidersPage.useTabText.getText().contains(teks));
}
*/
    }
    }

