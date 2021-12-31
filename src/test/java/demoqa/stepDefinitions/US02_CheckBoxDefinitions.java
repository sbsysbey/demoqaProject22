package demoqa.stepDefinitions;

import demoqa.pages.US02_CheckBoxPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import demoqa.utilities.Driver;
import demoqa.utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.List;

public class US02_CheckBoxDefinitions {
    US02_CheckBoxPage checkBoxPage = new US02_CheckBoxPage();
    Actions actions = new Actions(Driver.getDriver());



    @Then("checktbox butonuna tiklayiniz")
    public void checktbox_butonuna_tiklayiniz() {
checkBoxPage.checkBoxMenuLink.click();
    }

    @Then("+ butonuna basiniz")
    public void butonuna_basiniz() {
checkBoxPage.Checkboxarti.click();
    }

    @Then("butun mnenunun acildigini dogrulayin")
    public void butun_mnenunun_acildigini_dogrulayin() {
     /*   for(int i =1; i<=17; i++ ) {
            String xpathInput= "(//input)[" + i + "]"; //  (//input)[17]
            System.out.println( "Xpath Kontrol: " + xpathInput);
            WebElement checkbox = Driver.getDriver().findElement(By.xpath(xpathInput));

            Assert.assertTrue(checkbox.isEnabled());*/
            List<WebElement> elems=Driver.getDriver().findElements(By.xpath("//li[@class='rct-node rct-node-leaf']"));
            List list=new ArrayList();
            list= ReusableMethods.getElementsText(elems);
            System.out.println(list);
        }

    @Then("eksibutonuna basiniz")
    public void eksibutonuna_basiniz() {
        checkBoxPage.Checkboxeksi.click();
    }
    @Then("menunun kapalı oldugunu dogrulayiniz")
    public void menunun_kapali_oldugunu_dogrulayiniz() {
        Assert.assertTrue(checkBoxPage.eksiDogrulama.isDisplayed());
        System.out.println("MENU KAPALI");
    }




    @And("ExcelFile seciniz")
    public void excelfileSeciniz() {

        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
        checkBoxPage.excelFile.click();
    }

    @Then("Excelin secili oldugunu dogrulayiniz")
    public void excelinSeciliOldugunuDogrulayiniz() {
ReusableMethods.waitFor(1);
Assert.assertTrue(checkBoxPage.succeskontrol.getText().contains("excelFile"));
        System.out.println(checkBoxPage.succeskontrol.getText());
    }
}
