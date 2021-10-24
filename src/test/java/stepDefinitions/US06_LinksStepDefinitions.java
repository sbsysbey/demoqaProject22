package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;
import pages.US06_LinksPage;
import utilities.Driver;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class US06_LinksStepDefinitions {
   US06_LinksPage linksPage = new US06_LinksPage();
    Actions actions = new Actions(Driver.getDriver());


    @And("Links butonuna basiniz")
    public void linksButonunaBasiniz() {
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        linksPage.lineMenuLink.click();


    }

    @And("Home butonuna tiklayin")
    public void homeButonunaTiklayin() {
linksPage.linkHome.click();
    }

    @Then("Yeni bir sekme de anasayfa acildigini dogrulayiniz")
    public void yeniBirSekmeDeAnasayfaAcildiginiDogrulayiniz() {

     //   Driver.getDriver().findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");

          //  Driver.getDriver().switchTo().window(Driver.getDriver().getWindowHandle());
      //  Driver.getDriver().switchTo().window("1").getWindowHandle();
      //  ArrayList tabs = new ArrayList (Driver.getDriver().getWindowHandles());
      //  System.out.println(tabs.size());
        Driver.getDriver().get("https://demoqa.com/");
        System.out.println(Driver.getDriver().getTitle());
       // Driver.getDriver().switchTo().window(tabs.get(0));

        Assert.assertTrue(Driver.getDriver().getTitle().contains("ToolsQA"));

}}