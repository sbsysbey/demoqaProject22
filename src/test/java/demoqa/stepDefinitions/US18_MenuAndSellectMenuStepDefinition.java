package demoqa.stepDefinitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import demoqa.pages.US18_MenuAndSellectMenuPage;
import demoqa.utilities.Driver;
import demoqa.utilities.ReusableMethods;

import java.util.List;

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

        List<String> subItemList=ReusableMethods.getElementsText(By.xpath("//ul[@id='nav']/li/ul/li"));
        System.out.println("subItem listesi bos olmalı: "+subItemList);
    softAssert.assertTrue(subItemList.size()==0);

        softAssert.assertFalse(menuveSelectM.Sub_Item1.isDisplayed());
        softAssert.assertFalse(menuveSelectM.Sub_Item2.isDisplayed());
        softAssert.assertFalse(menuveSelectM.SubSubList.isDisplayed());
        softAssert.assertAll();
    }

    @Then("Kullanici SubItemlerin gorundugunu dogrular")
    public void kullaniciSubItemlerinGorundugunuDogrular() {
        List<String> subItemList=ReusableMethods.getElementsText(By.xpath("//ul[@id='nav']/li/ul/li"));
        System.out.println("subItem listesi 3 olmalı: "+subItemList);
        softAssert.assertTrue(subItemList.size()==3);

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
        List<String> subsubItemler=ReusableMethods.getElementsText(By.xpath("//ul[@id='nav']/li/ul/li/ul/li"));
        System.out.println(" subsubItemler listesi 0 olmalı: "+subsubItemler);
                softAssert.assertTrue(subsubItemler.size()==0);

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
        List<String> subsubItemler1=ReusableMethods.getElementsText(By.xpath("//ul[@id='nav']/li/ul/li/ul/li"));
        System.out.println("2 tane olmalı subsubItemler: "+subsubItemler1);
       softAssert.assertTrue(subsubItemler1.size()==2);
        softAssert.assertTrue(menuveSelectM.SubSubItem1.isDisplayed());
        softAssert.assertTrue(menuveSelectM.SubSubItem2.isDisplayed());
        softAssert.assertAll();
    }



    /////SELECT MENU

    @And("Kullanici Select Menu sekmesini tiklar")
    public void kullaniciSelectMenuSekmesiniTiklar() {
     actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
       menuveSelectM.sellectMenuLink.click();
   //     actions.sendKeys(Keys.PAGE_UP).perform();
        ReusableMethods.waitFor(1);

    }

    @And("Kullanici select Option dropdownunu tiklar")
    public void kullaniciSelectOptionDropdownunuTiklar() {
        menuveSelectM.selectOption.click();

    }

        @And("Kullanici {string} degerini secer")
    public void kullaniciDegeriniSecer(String arg0) {


      actions.sendKeys(arg0).sendKeys(Keys.ENTER).perform();
   // actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
            //   jsx.executeScript("Group 1, option 1",menuveSelectM.selectOption);

            //ReusableMethods.jsClick(menuveSelectM.sellectOption);

             }

    @Then("Kuulanici secimde {string} oldugunu dogrular")
    public void kuulaniciSecimdeOldugunuDogrular(String arg0) {
        System.out.println(arg0);
        System.out.println(menuveSelectM.selectOptionText.getText());
        Assert.assertTrue(menuveSelectM.selectOptionText.getText().equals(arg0));




   }

    @Then("Kullanici {string} inputunun border color mavi oldugunu dogrular")
    public void kullaniciInputununBorderColorMaviOldugunuDogrular(String arg0) {
        ReusableMethods.waitFor(1);
        System.out.println(menuveSelectM.selectOption.getCssValue("border-color"));
Assert.assertTrue(menuveSelectM.selectOption.getCssValue("border-color").equals("rgb(33, 37, 41)"));


    }

    @Then("Kuulanici secimde {string} olmadini dogrular")
    public void kuulaniciSecimdeOlmadiniDogrular(String arg0) {
        System.out.println(arg0);
        System.out.println(menuveSelectM.selectOptionText.getText());
        Assert.assertFalse(menuveSelectM.selectOptionText.getText().equals(arg0));

     }

    @And("Kullanici select Title dropdownunu tiklar")
    public void kullaniciSelectTitleDropdownunuTiklar() {
        menuveSelectM.sellectTitle.click();


    }

    @And("Kullanici title {string} degerini secer")
    public void kullaniciTitleDegeriniSecer(String arg0) {

        actions.sendKeys(arg0).sendKeys(Keys.ENTER).perform();

    }

    @Then("Kuulanici title {string} oldugunu dogrular")
    public void kuulaniciTitleOldugunuDogrular(String arg0) {
        ReusableMethods.waitFor(1);
        System.out.println(arg0);
        System.out.println(menuveSelectM.sellectTitleText.getText());
        Assert.assertTrue(menuveSelectM.sellectTitleText.getText().equals(arg0));


    }



    @Then("Kullanici uc tane main-item oldugunu dogrular")
    public void kullaniciUcTaneMainItemOldugunuDogrular() {

        softAssert.assertTrue(menuveSelectM.menuItems.size()==3);
        System.out.println(menuveSelectM.menuItems.size());

        softAssert.assertAll();
    }

    @Then("Kullanici iki tane sub-item ve birtane sub-sub list oldugunu dogrular")
    public void kullaniciIkiTaneSubItemVeBirtaneSubSubListOldugunuDogrular() {


        List<String> subList=ReusableMethods.getElementsText(By.xpath("//ul[@id='nav']//li[2]/ul/li"));
        System.out.println(subList);
        softAssert.assertTrue(subList.size()==3);


    }



    @Then("Kullanici sekiz tane linkin oldugunu ve isimlerini dogrular")
    public void kullaniciSekizTaneLinkinOldugunuVeIsimleriniDogrular(List<String> arg0) {
        List<String> subItemList=ReusableMethods.getElementsText(By.xpath("//ul[@id='nav']//li/a"));
        System.out.println(subItemList);
        softAssert.assertTrue(subItemList.size()==8);
        softAssert.assertTrue(subItemList.contains(arg0));
    }
}



