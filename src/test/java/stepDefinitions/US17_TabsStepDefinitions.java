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
        ReusableMethods.waitFor(1);
    }



    @And("Kullanici Origin Tab tiklar")
    public void kullaniciOriginTabTiklar() {
        slidersPage.tab_Origin.click();
        ReusableMethods.waitFor(1);
    }

    @And("Kullanici Use tab tiklar")
    public void kullaniciUseTabTiklar() {
        slidersPage.tab_Use.click();
        ReusableMethods.waitFor(2);
    }



    @And("Kullanici More tab tiklar")
    public void kullaniciMoreTabTiklar() {
ReusableMethods.waitFor(2);
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

    @And("KullaniciTool Tips sekmesini tiklar")
    public void kullanicitoolTipsSekmesiniTiklar() {
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
        slidersPage.toolTips.click();
        actions.sendKeys(Keys.PAGE_UP).perform();
        ReusableMethods.waitFor(1);
    }

    @And("Kullanici fareyi butonun uzerine getirir")
    public void kullaniciFareyiButonunUzerineGetirir() {
        actions.moveToElement(slidersPage.hoverButton).build().perform();
        ReusableMethods.waitFor(3);
    }

    @Then("Kullanici rengin degistigini dogrular")
    public void kullaniciRenginDegistiginiDogrular() {

        System.out.println(ReusableMethods.getHexColor(slidersPage.hoverButton,"background-color"));
     Assert.assertTrue(ReusableMethods.getHexColor(slidersPage.hoverButton,"background-color").equals("#218838"));


    }

    @Then("Kullanici {string} textinin gorundugunu dogrular")
    public void kullaniciTextininGorundugunuDogrular(String arg0) {

        ReusableMethods.waitFor(3);
        System.out.println(slidersPage.gorunurText.getText());

    }

    @And("Kullanici hover butonunu tiklar")
    public void kullaniciHoverButonunuTiklar() {
        actions.click(slidersPage.hoverButton).perform();
    }
    @And("kullanici rengi dogrular")
    public void kullaniciRengiDogrular() {

        System.out.println(ReusableMethods.getHexColor(slidersPage.hoverButton,"border-color"));
        Assert.assertTrue(   ReusableMethods.getHexColor(slidersPage.hoverButton,"border-color").equals("#1e7e34"));



    }

    @And("Kullanici fareyi textboxin uzerine getirir")
    public void kullaniciFareyiTextboxinUzerineGetirir() {
    }

    @And("Kullanici  textboxa tiklar")
    public void kullaniciTextboxaTiklar() {
    }

    @And("Kullanici fareyi textin uzerine getirir")
    public void kullaniciFareyiTextinUzerineGetirir() {
    }

}

