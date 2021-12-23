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





          ///TOOL TİPS HOVER OVER

    String beforeBgColor;
    String afterBgColor;
    String beforeBColor;
    String afterBColor;

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
        beforeBgColor=ReusableMethods.getHexColor(slidersPage.hoverButton,"background-color");
        beforeBColor=ReusableMethods.getHexColor(slidersPage.hoverButton,"border-color");
        actions.moveToElement(slidersPage.hoverButton).build().perform();
        ReusableMethods.waitFor(3);
        afterBgColor=ReusableMethods.getHexColor(slidersPage.hoverButton,"background-color");
    }

    @Then("Kullanici rengin degistigini dogrular")
    public void kullaniciRenginDegistiginiDogrular() {

        System.out.println("Before : "+beforeBgColor+"  -  after    : "+afterBgColor);

     Assert.assertFalse(beforeBgColor.equals(afterBgColor));


    }

    @Then("Kullanici {string} textinin gorundugunu dogrular")
    public void kullaniciTextininGorundugunuDogrular(String arg0) {

        ReusableMethods.waitFor(3);
        System.out.println("actual text   : "+slidersPage.gorunurText.getText());
        System.out.println("Expected Text : You hovered over the "+arg0);
        Assert.assertTrue(slidersPage.gorunurText.getText().equals("You hovered over the "+arg0));

    }

    @And("Kullanici hover butonunu tiklar")
    public void kullaniciHoverButonunuTiklar() {
        actions.click(slidersPage.hoverButton).perform();
        ReusableMethods.waitFor(2);
        afterBColor=ReusableMethods.getHexColor(slidersPage.hoverButton,"border-color");
    }
    @And("kullanici rengi dogrular")
    public void kullaniciRengiDogrular() {

        System.out.println("Before border : "+beforeBColor+"  -  after border    : "+afterBColor);
        Assert.assertFalse(beforeBColor.equals(afterBColor));



    }

    @And("Kullanici fareyi textboxin uzerine getirir")
    public void kullaniciFareyiTextboxinUzerineGetirir() {
        beforeBColor=ReusableMethods.getHexColor(slidersPage.hovertextBox,"border-color");
       ReusableMethods.hover(slidersPage.hovertextBox);
ReusableMethods.waitFor(3);
    }

    @And("Kullanici  textboxa tiklar")
    public void kullaniciTextboxaTiklar() {
        slidersPage.hovertextBox.click();
        ReusableMethods.waitFor(2);
        afterBColor=ReusableMethods.getHexColor(slidersPage.hovertextBox,"border-color");

    }

    @And("Kullanici fareyi textin uzerine getirir {string}")
    public void kullaniciFareyiTextinUzerineGetirir(String arg0) {
        if(arg0.equals("Contrary")){
            beforeBgColor=ReusableMethods.getHexColor(slidersPage.hoverContraryText,"color");
            ReusableMethods.hover( slidersPage.hoverContraryText);
            ReusableMethods.waitFor(2);
            afterBgColor=ReusableMethods.getHexColor(slidersPage.hoverContraryText,"color");
        }else if(arg0.equals("deger")){
            actions.sendKeys(Keys.PAGE_DOWN).perform();
            ReusableMethods.waitFor(2);
            beforeBgColor=ReusableMethods.getHexColor(slidersPage.hoverDegerText,"color");
            ReusableMethods.hover(slidersPage.hoverDegerText);
            ReusableMethods.waitFor(2);
            afterBgColor=ReusableMethods.getHexColor(slidersPage.hoverDegerText,"color");
        }


    }

}

