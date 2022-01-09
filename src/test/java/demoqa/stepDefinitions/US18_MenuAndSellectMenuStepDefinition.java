package demoqa.stepDefinitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import demoqa.pages.US18_MenuAndSellectMenuPage;
import demoqa.utilities.Driver;
import demoqa.utilities.ReusableMethods;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

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
ReusableMethods.waitFor(1);
    }
    @Then("Kullanici degeri secer ve dogrular degerini secer")
    public void kullaniciDegeriSecerVeDogrularDegeriniSecer(List<String> kontrolList) {
        List<String> optionslar=ReusableMethods.getElementsText(By.xpath("//div[@tabindex='-1']"));
        for (int i=0;i<optionslar.size();i++)
        {
            ReusableMethods.waitFor(1);
            System.out.println("gelen: "+optionslar.get(i)+" listeden: "+kontrolList.get(i));
           softAssert.assertTrue(optionslar.get(i).equals(kontrolList.get(i)));
            actions.sendKeys(kontrolList.get(i)).sendKeys(Keys.ENTER).perform();
            softAssert.assertTrue(kontrolList.contains(menuveSelectM.selectOptionText.getText()));
            actions.sendKeys(Keys.TAB).click(menuveSelectM.selectOption).perform();
            softAssert.assertAll();
        }
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
    public void kullaniciIkiTaneSubItemVeBirtaneSubSubListOldugunuDogrular(String a) {


        List<String> subList=ReusableMethods.getElementsText(By.xpath("//ul[@id='nav']//li[2]/ul/li"));

        System.out.println(subList);
        softAssert.assertTrue(subList.size()==8);
        softAssert.assertTrue(subList.contains(a));


    }




    @Then("Kullanici sekiz tane linkin oldugunu ve isimlerini dogrular")
    public void kullaniciSekizTaneLinkinOldugunuVeIsimleriniDogrular(String arg0) {
        System.out.println(arg0);
        List<String> subItemList=ReusableMethods.getElementsText(By.xpath("//ul[@id='nav']//li/a"));

        System.out.println("Toplamda "+subItemList.size()+" link var. İsimleri ise: ");
        System.out.println(subItemList);
        softAssert.assertTrue(subItemList.size()==8);

        softAssert.assertTrue(subItemList.contains(arg0));
        softAssert.assertAll();








    }

    @And("Kullanici liste  degerini secer")
    public void kullaniciListeDegeriniSecer() {
List<WebElement> optionslar=Driver.getDriver().findElements(By.xpath("//div[@tabindex='-1']"));
        for (int i=0;i<optionslar.size();i++)
             {
                 System.out.println(optionslar.get(i).getText());
             ;
        }
    }


    @Then("Kullanici degeri secer ve dogrular")
    public void kullaniciDegeriSecerVeDogrular(List<String> kontrolList) {
        List<String> optionslar=ReusableMethods.getElementsText(By.xpath("//div[@tabindex='-1']"));
        for (int i=0;i<optionslar.size();i++)
        {
            ReusableMethods.waitFor(1);
            System.out.println("gelen: "+optionslar.get(i)+" listeden: "+kontrolList.get(i));
            softAssert.assertTrue(optionslar.get(i).equals(kontrolList.get(i)));
            actions.sendKeys(kontrolList.get(i)).sendKeys(Keys.ENTER).perform();
            softAssert.assertTrue(kontrolList.contains(menuveSelectM.selectOptionText.getText()));
            actions.sendKeys(Keys.TAB).click(menuveSelectM.sellectTitle).perform();
            softAssert.assertAll();
        }


    }

    @And("Kullanici old Title dropdownunu tiklar")
    public void kullaniciOldTitleDropdownunuTiklar() {
        Select oldText1=new Select(menuveSelectM.oldSelectBox);
        oldText1.selectByIndex(3);
        System.out.println(menuveSelectM.oldSelectBox.getAttribute("value"));
    }

    @Then("Kullanici renk degerlerini secer ve dogrular")
    public void kullaniciRenkDegerleriniSecerVeDogrular(Map<String,String> renkler) {

        System.out.println(renkler);

        for (int i = 0; i < renkler.size() ; i++) {
            Select oldText=new Select(menuveSelectM.oldSelectBox);
            oldText.selectByIndex(i);
        oldText.selectByIndex(i);
        ReusableMethods.waitFor(1);
            System.out.print("gelmesi gereken ren: "+renkler.get(menuveSelectM.oldSelectBox.getAttribute("value")));
        System.out.println("yazılı renk: "+ menuveSelectM.oldSelectBox.getAttribute("value"));
        if (menuveSelectM.oldSelectBox.getAttribute("value").equals("Red")){
            softAssert.assertTrue(menuveSelectM.oldSelectBox.getAttribute("value").equals(renkler.get(i)));
        }else
       softAssert.assertTrue(menuveSelectM.oldSelectBox.getAttribute("value").equals(renkler.get(i)));
softAssert.assertAll();
        }}





    }




